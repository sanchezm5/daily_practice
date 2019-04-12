/* This project is from freeCodeCamp

JavaScript Algorithms and Data Structures Projects: Palindrome Checker

Return true if the given string is a palindrome. Otherwise, return false.
A palindrome is a word or sentence that's spelled the same way both forward and backward, 
ignoring punctuation, case, and spacing.

Note: You'll need to remove all non-alphanumeric characters (punctuation, spaces and symbols) and 
turn everything into the same case (lower or upper case) in order to check for palindromes.

Input: "2A3*3a2", "2A3 3a2", and "2_A3*3#A2"  Output: True */

//Palindrome Checker Solution
function palindrome(str) {
  const myRegex = /[a-z0-9]/gi;
  //myRegex represents all alphanumeric characters
  //g is the global search flag (i.e. searches for all possible matches)
  //i is the flag for ignoring cases (i.e can be upper or lower)

  const changedStr = str
    .match(myRegex)
    .join("")
    .toLowerCase();
  // changedStr removes all non-alphanumeric characters and turns str into the same case

  let left = 0;
  let right = changedStr.length - 1;

  while (left < right) {
    if (changedStr[left] !== changedStr[right]) {
      return false;
    } else {
      left++;
      right--;
    }
  }
  return true;
}

console.log(palindrome("_eye"));
console.log(palindrome("A man, a plan, a canal. Panama"));
console.log(palindrome("not a palindrome"));
console.log(palindrome("race CAR"));
console.log(palindrome("2_A3*3#A2"));
