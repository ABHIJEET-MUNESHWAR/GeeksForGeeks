# 📝 98. Validate Binary Search Tree (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/validate-binary-search-tree/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Tree, Depth-First Search, Binary Search Tree, Binary Tree

### 🚀 Performance
- **Runtime:** 0 ms
- **Memory:** 44.9 MB

---

### 📜 Problem Description

Given the  `root`  of a binary tree,  *determine if it is a valid binary search tree (BST)* .

A  **valid BST**  is defined as follows:

	
- The left subtree of a node contains only nodes with keys  **strictly less than**  the node's key.
	
- The right subtree of a node contains only nodes with keys  **strictly greater than**  the node's key.
	
- Both the left and right subtrees must also be binary search trees.

**Example 1:**

 ![image](https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg) 

```
Input: root = [2,1,3]
Output: true

```

**Example 2:**

 ![image](https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg) 

```
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

```

**Constraints:**

	
- The number of nodes in the tree is in the range  `[1, 104]` .
	
- `-231 <= Node.val <= 231 - 1`