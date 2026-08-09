# 📝 143. Reorder List (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/reorder-list/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Linked List, Two Pointers, Stack, Recursion

### 🚀 Performance
- **Runtime:** 2 ms
- **Memory:** 48 MB

---

### 📜 Problem Description

You are given the head of a singly linked-list. The list can be represented as:

```
L0 → L1 → … → Ln - 1 → Ln

```

*Reorder the list to be on the following form:*

```
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

```

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

**Example 1:**

 ![image](https://assets.leetcode.com/uploads/2021/03/04/reorder1linked-list.jpg) 

```
Input: head = [1,2,3,4]
Output: [1,4,2,3]

```

**Example 2:**

 ![image](https://assets.leetcode.com/uploads/2021/03/09/reorder2-linked-list.jpg) 

```
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

```

**Constraints:**

	
- The number of nodes in the list is in the range  `[1, 5 * 104]` .
	
- `1 <= Node.val <= 1000`