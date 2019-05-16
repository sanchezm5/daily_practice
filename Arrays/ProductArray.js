/* This question is from LeetCode

Given an array nums of n integers where n > 1, return an array output such that output[i]
is equal to the product of all the elements of nums except nums[i].

Note: Please solve it without division and in O(n).

Input: [1,2,3,4]

Output: [24,12,8,6] */

//Solution 1: Use Multiple Pointers for the indices i and j
//Time O(n^2)
function productArray(arr) {
  // make a copy of the input array
  let arrCopy = arr.slice(0);
  // initialize i at the 0th index and a product variable = 1
  let i = 0;
  let prod = 1;

  while (i < arrCopy.length) {
    for (let j = 0; j < arr.length; j++) {
      // if i and j are at the same index, keep i as is and increment j
      if (i === j) {
        j++;
      }
      // find the product by multplying the value at the jth index by the current product value
      // then set the value of arr[i] to that product
      if (arr[j] !== undefined) {
        prod *= arrCopy[j];
        arr[i] = prod;
      }
    }
    // reset the product value to 1
    // increment i and repeat the process until the conditions are met
    prod = 1;
    i++;
  }
  // finally return the product array
  return arr;
}

/* Optimal Solution 2: Create a Left(L) and Right(R) Array, where for i, (L) contains the 
product of all numbers to left of i and to the right for (R) */
//Time O(n) | Space O(n)
function productExceptSelf(nums) {
  let left = new Array(nums.length).fill(1);
  let right = new Array(nums.length).fill(1);
  let result = [];
  let leftProd = 1;
  let rightProd = 1;

  for (let i = 1; i < nums.length; i++) {
    leftProd *= nums[i - 1];
    left[i] = leftProd;
    rightProd *= nums[nums.length - i];
    right[nums.length - i - 1] = rightProd;
  }

  for (let i = 0; i < nums.length; i++) {
    result.push(left[i] * right[i]);
  }
  return result;
}

console.log(productArray([1, 2, 3, 4]));
console.log(productExceptSelf([1, 2, 3, 4]));
