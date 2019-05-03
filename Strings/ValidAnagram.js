/* This question is from LeetCode (also on Udemy)

Given two strings s and t, write a function to determine if t is an anagram of s.
An anagram is a word, phrase, or name formed by rearranging the letters of another.
See Examples below.

Input: s = "@ana1ram", t = "@na1aram"
Output: true

Input: s = "aaz", t = "zza"
Output: false

Input: s = "qwerty", t = "qeywrt"
Output: true */

//Solution 1: Use a Frequency Counter Pattern
const validAnagram = function(s, t) {
  // create an object to collect the frequency of characters in s and t
  const sCounter = {};
  const tCounter = {};

  for (let i = 0; i < s.length; i++) {
    let charS = s[i];
    // for each character in s, store the frequency of that char into the sCounter object
    sCounter[charS] ? (sCounter[charS] += 1) : (sCounter[charS] = 1);
  }
  for (let j = 0; j < t.length; j++) {
    let charT = t[j];
    // for each character in t, store the frequency of that char into the tCounter object
    tCounter[charT] ? (tCounter[charT] += 1) : (tCounter[charT] = 1);
  }

  // iterate through each key in sCounter
  for (let key in sCounter) {
    // if that key is not in tCounter or the values with that property are unequal, return false
    if (!key in tCounter || sCounter[key] !== tCounter[key]) {
      return false;
    }
  }
  // else return true
  return true;
};

console.log(validAnagram("@ana1ram", "@na1aram"));
console.log(validAnagram("aaz", "zza"));
console.log(validAnagram("qwerty", "qeywrt"));
