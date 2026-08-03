/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> originalToClonedNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Node clonedNode = new Node(node.val);
        originalToClonedNodeMap.put(node, clonedNode);
        dfs(node, clonedNode);
        return clonedNode;
    }

    public void dfs(Node node, Node clonedNode) {
        for (Node neighbour : node.neighbors) {
            if (!originalToClonedNodeMap.containsKey(neighbour)) {
                Node clonedNeighbour = new Node(neighbour.val);
                originalToClonedNodeMap.put(neighbour, clonedNeighbour);
                clonedNode.neighbors.add(clonedNeighbour);
                dfs(neighbour, clonedNeighbour);
            } else {
                clonedNode.neighbors.add(originalToClonedNodeMap.get(neighbour));
            }
        }
    }
}