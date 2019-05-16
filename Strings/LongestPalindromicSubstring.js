/* This question is from AlgoExpert

Write a function that, given a string, returns its longest palindromic substring.
Assume that there will only be one longest palindromic substring and letters are all lowercase.

Sample input: "abaxyzzyxf"
Sample output: "xyzzyx" */

// Solution 1: Brute Force Method: find all possible substrings and compare lengths to find the longest one
// O(n^3) Time | O(1) Space
function longestPalindromicSubstringSoln1(string) {
  let longest = "";
  for (let i = 0; i < string.length; i++) {
    for (let j = i; j < string.length; j++) {
      const substring = string.slice(i, j + 1);
      // if the current substring length is longer than the current longest and its a palindrome
      // longest becomes the current substring
      if (substring.length > longest.length && isPalindrome(substring)) {
        longest = substring;
      }
    }
  }
  return longest;
}

function isPalindrome(string) {
  let left = 0;
  let right = string.length - 1;

  while (left < right) {
    if (string[left] !== string[right]) {
      return false;
    }
    left++;
    right--;
  }
  return true;
}

/* Solution 2: Keep track of indices for even and odd length palindromic substrings, 
the greatest difference between indices will be the longest substring */
// O(n^2) Time | O(1) Space
function longestPalindromicSubstringSoln2(string) {
  let currentLongest = [0, 1];
  for (let i = 1; i < string.length; i++) {
    const odd = getLongestPalindromeFrom(string, i - 1, i + 1);
    const even = getLongestPalindromeFrom(string, i - 1, i);
    const longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
    currentLongest =
      currentLongest[1] - currentLongest[0] > longest[1] - longest[0]
        ? currentLongest
        : longest;
  }
  return string.slice(currentLongest[0], currentLongest[1]);
}

function getLongestPalindromeFrom(string, left, right) {
  while (left >= 0 && right < string.length) {
    if (string[left] !== string[right]) {
      break;
    }
    left--;
    right++;
  }
  return [left + 1, right];
}

console.log(longestPalindromicSubstringSoln1("abaxyzzyxf"));
console.log(longestPalindromicSubstringSoln2("abaxyzzyxf"));
