/* This project is from freeCodeCamp

JavaScript Algorithms and Data Structures Projects: Caesars Cipher

One of the simplest and most widely known ciphers is a Caesar cipher, also known as a shift cipher. 
In a shift cipher the meanings of the letters are shifted by some set amount. A common modern use is 
the ROT13 cipher, where the values of the letters are shifted by 13 places. Thus 'A' ↔ 'N', 'B' ↔ 'O' and so on.

Write a function which takes a ROT13 encoded string as input and returns a decoded string.
All letters will be uppercase. Do not transform any non-alphabetic character (i.e. spaces, punctuation), but do pass them on.

Input: "SERR PBQR PNZC"  Output: FREE CODE CAMP */

//ROT13 Cipher Solution
function rot13(str) {
  const alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
  const newLetters = [];
  let newLetterCode;

  for (const char of str) {
    const charIndex = alphabet.indexOf(char);

    //for non-alphabetic characters the index will be -1
    //we DO NOT want to transform these chars so push them as is into the newLetters array
    if (charIndex < 0) {
      newLetters.push(char);
    } else {
      //for alphabetic characters, add 13 to rotate the cipher 13-places
      newLetterCode = charIndex + 13;
      newLetterCode <= 25
        ? newLetters.push(alphabet[newLetterCode])
        : newLetters.push(alphabet[-1 + (newLetterCode % 25)]);
    }
  }
  return newLetters.join("");
}

console.log(rot13("SERR PBQR PNZC"));
console.log(rot13("V QVQ VG!"));
