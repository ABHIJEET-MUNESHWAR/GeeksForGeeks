# 📝 230. Kth Smallest Element in a BST (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Tree, Depth-First Search, Binary Search Tree, Binary Tree

### 🚀 Performance
- **Runtime:** 0 ms
- **Memory:** 44.6 MB

---

### 📜 Problem Description

Given the  `root`  of a binary search tree, and an integer  `k` , return  *the*   `kth`   *smallest value ( **1-indexed** ) of all the values of the nodes in the tree* .

**Example 1:**

 ![image](https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg) 

```
Input: root = [3,1,4,null,2], k = 1
Output: 1

```

**Example 2:**

 ![image](https://assets.leetcode.com/uploads/2021/01/28/kthtree2.jpg) 

```
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

```

**Constraints:**

	
- The number of nodes in the tree is  `n` .
	
- `1 <= k <= n <= 104`
	
- `0 <= Node.val <= 104`

**Follow up:**  If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?