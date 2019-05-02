/* This question is from AlgoExpert

The Fibonacci sequence is defined as follows: 0, 1, 1, 2, 3, 5, ...
The nth number is the sum of the (n-1)th and the (n-2)th numbers. Write
a function that takes in an integer n and returns the nth Fibonacci number.

Sample input: 6
Sample output: 5 given 0,1,1,2,3,5 is the 6th term */

//Recursive Solution 1: Base Case 1st term = 0, 2nd term = 1, Recursive Case nth Term = (n-1)th + (n-2)th terms
//O(2^n) Time | O(n) Space
function getNthFib(n) {
  if (n === 1) return 0;
  if (n === 2) return 1;
  else return getNthFib(n - 1) + getNthFib(n - 2);
}

console.log(getNthFib(7));
