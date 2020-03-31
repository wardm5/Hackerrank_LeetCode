//-------------------------------------------------------------------------------
//    Misha Ward
//-------------------------------------------------------------------------------

/*-------------------------------------------------------------------------------

Problem:
287. Find the Duplicate Number
Medium

Given an array nums containing n + 1 integers where each integer is between 1 and
n (inclusive), prove that at least one duplicate number must exist. Assume that
there is only one duplicate number, find the duplicate one.

Example 1:
Input: [1,3,4,2,2]
Output: 2

Example 2:
Input: [3,1,3,4,2]
Output: 3

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

-------------------------------------------------------------------------------*/

//-------------------------------------------------------------------------------
//    Approach
//-------------------------------------------------------------------------------

/*
    1) the idea is to loop through the array, if you see a number, take that number as the index, make sure it is negative
    2) if you find a number that is negative after looking up the absolute value of index, you know that is the duplicate
*/

//-------------------------------------------------------------------------------
//    Soluton
//-------------------------------------------------------------------------------

class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0)
                return Math.abs(nums[i]);
            nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }
        return -1;
    }
}

/*
    Runtime: 1 ms, faster than 61.97% of Java online submissions for Find the Duplicate Number.
    Memory Usage: 39.7 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.
*/
