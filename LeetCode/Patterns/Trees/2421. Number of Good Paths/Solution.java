public int numberOfGoodPaths(int[] vals, int[][] edges) {
    int N = vals.length;
    ArrayList<Integer>[] adj = new ArrayList[N];
    TreeMap<Integer, ArrayList<Integer>> sameValues = new TreeMap<>();
    int ans = 0;
    
    for(int i=0; i<N; i++) {
        adj[i] = new ArrayList<>();
        
        if(!sameValues.containsKey(vals[i])) sameValues.put(vals[i], new ArrayList<>());
        sameValues.get(vals[i]).add(i);
    }
    
    for(int[] e : edges) {
        int u = e[0];
        int v = e[1];
        
        if(vals[u] >= vals[v]) {
            adj[u].add(v);
        } else {
            adj[v].add(u);
        }
    }
    
    UF uf = new UF(N);
    
    for(int val : sameValues.entrySet()) {
        for(int u : sameValues.get(val)) {
            for(int v : adj[u]) {
                uf.union(u, v);
            }
        }
        
        HashMap<Integer, Integer> group = new HashMap<>();
        
        for(int u : sameValues.get(val)) {
            group.put(uf.find(u), group.getOrDefault(uf.find(u), 0) + 1);
        }
        
        ans += sameValues.get(val).size();
        
        for(int key : group.keySet()) {
            int size = group.get(key);
            ans += size * (size-1) / 2;
        }
    }
    
    return ans;
    
}

class UF {

    int[] parent;

    public UF(int len) {
        parent = new int[len];
        Arrays.fill(parent, -1);
    }

    public int find(int a) {
        if(parent[a] >= 0) {
            return parent[a] = find(parent[a]);    
        }
        return a;
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return false;

        if(parent[pa] <= parent[pb]) {
            parent[pa] += parent[pb];
            parent[pb] = pa;
        } else {
            parent[pb] += parent[pa];
            parent[pa] = pb;
        }
        
        return true;
    }
}