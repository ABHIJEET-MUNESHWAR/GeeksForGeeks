# 📝 892. Shortest Subarray with Sum at Least K (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Array, Binary Search, Queue, Sliding Window, Heap (Priority Queue), Prefix Sum, Monotonic Queue

### 🚀 Performance
- **Runtime:** 35 ms
- **Memory:** 58.4 MB

---

### 📜 Problem Description

Given an integer array  `nums`  and an integer  `k` , return  *the length of the shortest non-empty  **subarray**  of*  `nums`  *with a sum of at least*  `k` . If there is no such  **subarray** , return  `-1` .

A  **subarray**  is a  **contiguous**  part of an array.

**Example 1:**

```
Input: nums = [1], k = 1
Output: 1

```

**Example 2:**

```
Input: nums = [1,2], k = 4
Output: -1

```

**Example 3:**

```
Input: nums = [2,-1,2], k = 3
Output: 3

```

**Constraints:**

	
- `1 <= nums.length <= 105`
	
- `-105 <= nums[i] <= 105`
	
- `1 <= k <= 109`