/* This question is from AlgoExpert

Given a non-empty string of lowercase letters and non-negative integer value
representing a key, write a function that returns a new string obtained by shifting 
every letter in the input string by k positions in the alphabet, where k is the key.
Note that letters should "wrap" around the alphabet; in other words, the letter "z" 
shifted by 1 returns the letter "a".

Sample input: "xyz", 2
Sample output: "zab" */

// Solution 1:
// O(n) Time | O(n) Space
function caesarCipherEncryptorSoln1(string, key) {
  const newLetters = [];
  const newKey = key % 26;
  //we use newKey in case given key exceeds 26 letters of the alphabet
  for (const letter of string) {
    const newLetterCode = letter.charCodeAt() + newKey;
    newLetterCode <= 122
      ? newLetters.push(String.fromCharCode(newLetterCode))
      : //pushes a new letter corresponding to the newLetterCode into the newLetters array
        newLetters.push(String.fromCharCode(96 + (newLetterCode % 122)));
    /* when the newLetterCode is > 122, we have to start with 96 (since a = 97) and add the newLetterCode to that, 
      find the new Letter, and push it into the newLetters array */
  }
  return newLetters.join("");
}

console.log(caesarCipherEncryptorSoln1("xyz", 2));
