# 1679 Max Number of K-Sum Pairs

[link](https://leetcode.com/problems/max-number-of-k-sum-pairs/)

## Desc

+ numbers are not necessarily sorted
+ Constraints:
    + 1 <= nums.length <= 10^5
    + 1 <= nums[i] <= 10^9
    + 1 <= k <= 10^9

## Retro

### Time Complexity Analysis

+ (Waiting Room Analogy): _O(N)_
    + I iterate through the array exactly once.
    + HashMap operations (put, get, containsKey) are O(1) on average.

### Space Complexity Analysis

+ (Waiting Room Analogy): _O(N)_ (worst-case scenario)
    + In the worst case (e.g., [1, 2, 3, 4] with k=100), no pairs are found, and every single number is stored in the
      map.

### Key & What to bear in mind

+ Waiting room analogy:
  ![Waiting Room Analogy Diagram](/src/main/resources/1679-waiting-room-analogy.svg)
