/* This question is from LeetCode (also on Udemy)

Given a sorted array nums, remove the duplicates in-place such that each element appear only 
once and return the new length. Do not allocate extra space for another array, you must do 
this by modifying the input array in-place with O(1) extra memory.

Input: [0,0,1,1,1,2,2,3,3,4]

Output: 5 with the first five elements of nums being modified to [0,1,2,3,4,2,2,3,3,4] */

//Solution: Use Multiple Pointers
//Time O(n) | Space O(n)

function removeDuplicates(nums) {
  // for an empty array of nums, return 0
  if (nums.length === 0) return 0;

  // define two pointers i = 0; j = 1
  let i = 0;
  for (let j = 1; j < nums.length; j++) {
    // if the two values in the nums array are not equal, increment i, and set nums[i] to value of nums[j]
    if (nums[i] !== nums[j]) {
      i++;
      nums[i] = nums[j];
    }
  }
  // should output [ 0, 1, 2, 3, 1, 2, 2, 3, 3, 4 ]
  console.log(nums);
  // return the value of the index plus 1
  return i + 1;
}

console.log(removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]));
