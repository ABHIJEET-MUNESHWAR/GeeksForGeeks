# 📝 572. Subtree of Another Tree (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/subtree-of-another-tree/)

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Tree, Depth-First Search, String Matching, Binary Tree, Hash Function

### 🚀 Performance
- **Runtime:** 5 ms
- **Memory:** 46.9 MB

---

### 📜 Problem Description

Given the roots of two binary trees  `root`  and  `subRoot` , return  `true`  if there is a subtree of  `root`  with the same structure and node values of `subRoot`  and  `false`  otherwise.

A subtree of a binary tree  `tree`  is a tree that consists of a node in  `tree`  and all of this node's descendants. The tree  `tree`  could also be considered as a subtree of itself.

**Example 1:**

 ![image](https://assets.leetcode.com/uploads/2021/04/28/subtree1-tree.jpg) 

```
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

```

**Example 2:**

 ![image](https://assets.leetcode.com/uploads/2021/04/28/subtree2-tree.jpg) 

```
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

```

**Constraints:**

	
- The number of nodes in the  `root`  tree is in the range  `[1, 2000]` .
	
- The number of nodes in the  `subRoot`  tree is in the range  `[1, 1000]` .
	
- `-104 <= root.val <= 104`
	
- `-104 <= subRoot.val <= 104`