# 📝 442. Find All Duplicates in an Array (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/find-all-duplicates-in-an-array/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Array, Hash Table, Sorting

### 🚀 Performance
- **Runtime:** 6 ms
- **Memory:** 53.4 MB

---

### 📜 Problem Description

Given an integer array  `nums`  of length  `n`  where all the integers of  `nums`  are in the range  `[1, n]`  and each integer appears  **at most**   **twice** , return  *an array of all the integers that appears  **twice*** .

You must write an algorithm that runs in  `O(n)`  time and uses only  *constant*  auxiliary space, excluding the space needed to store the output

**Example 1:**

```
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

```

**Example 2:**

```
Input: nums = [1,1,2]
Output: [1]

```

**Example 3:**

```
Input: nums = [1]
Output: []

```

**Constraints:**

	
- `n == nums.length`
	
- `1 <= n <= 105`
	
- `1 <= nums[i] <= n`
	
- Each element in  `nums`  appears  **once**  or  **twice** .