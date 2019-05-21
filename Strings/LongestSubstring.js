/* This question is from leetcode

Given a string, find the length of the longest substring without repeating characters.

Sample input: "abcabcbb"
Sample output: 3 since the longest substring without duplication is "abc" */

// Solution:
// O(n) Time | O(min(n, a)) Space
function lengthOfLongestSubstring(string) {
  const hash = {};
  let longest = [0, 1];
  let start = 0;

  for (let i = 0; i < string.length; i++) {
    let char = string[i];

    if (char in hash) {
      start = Math.max(start, hash[char] + 1);
    }
    if (longest[1] - longest[0] < i + 1 - start) {
      longest = [start, i + 1];
    }
    hash[char] = i;
  }
  const len = string.slice(longest[0], longest[1]);
  return len.length;
}

console.log(lengthOfLongestSubstring("abcabcbb"));
console.log(lengthOfLongestSubstring("bbbbb"));
console.log(lengthOfLongestSubstring("pwwkew"));
