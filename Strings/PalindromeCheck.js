/* This question is from AlgoExpert

Write a function that takes in a non-empty string and that returns a boolean 
representing whether or not the string is a palindrome.

Sample input: "abcdcba" OR "ABCDcba"
Sample output: True */

// Solution 1: create a reversed string and compare it to the input string
// O(n^2) Time | O(n) Space
function isPalindromeSoln1(string) {
  let reversedStr = "";
  for (let i = string.length - 1; i >= 0; i--) {
    reversedStr += string[i];
  }
  return reversedStr.toLowerCase() === string.toLowerCase();
}

/* Solution 2: create an array with reversed string characters, change it back to a string, 
and then compare it to the input string */
// O(n) Time | O(n) Space
function isPalindromeSoln2(string) {
  let reversed = [];
  for (let i = string.length - 1; i >= 0; i--) {
    reversed.push(string[i]);
  }
  return reversed.join("").toLowerCase() === string.toLowerCase();
}

/* Solution 3: check if starting and ending chars are the same, then recursively check if chars 
between these make up a palindrome */
// O(n) Time | O(n) Space
function isPalindromeSoln3(string, i = 0) {
  const lowerCaseStr = string.toLowerCase();
  const j = string.length - 1 - i;
  if (i >= j) {
    return true;
  } else {
    return (
      lowerCaseStr[i] === lowerCaseStr[j] &&
      isPalindromeSoln3(lowerCaseStr, i + 1)
    );
  }
}

/* Optimal Solution 4: use left and right pointers (for indices) to compare first and last chars, if 
they're equal, then move pointers to compare second and second-to-last chars, etc */
// O(n) Time | O(1) Space
function isPalindromeSoln4(string) {
  const inputStr = string.toLowerCase();
  let left = 0;
  let right = string.length - 1;
  while (left < right) {
    if (inputStr[left] !== inputStr[right]) {
      return false;
    } else {
      left++;
      right--;
    }
  }
  return true;
}

console.log(isPalindromeSoln1("Racecar"));
console.log(isPalindromeSoln2("ABCDcba"));
console.log(isPalindromeSoln3("C.ABa.C"));
console.log(isPalindromeSoln4("1a2B343b2a1"));
