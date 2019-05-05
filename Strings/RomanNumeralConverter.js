/* This project is from freeCodeCamp

JavaScript Algorithms and Data Structures Projects: Roman Numeral Converter

Convert the given number into a roman numeral. All roman numerals answers should
be provided in upper-case.

Input: "1984"  Output: "MCMLXXXIV" */

/* Roman Numeral Converter Solution: First convert number into an array that can then be 
converted into roman numerals */
function convertToRoman(num) {
  let remainingNum = num;
  let arrayToConvert = [];
  const numbersArr = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];

  let romanNum = "";
  const romansObj = {
    "1000": "M",
    "900": "CM",
    "500": "D",
    "400": "CD",
    "100": "C",
    "90": "XC",
    "50": "L",
    "40": "XL",
    "10": "X",
    "9": "IX",
    "5": "V",
    "4": "IV",
    "1": "I"
  };

  // loop through the numbers array
  for (let i = 0; i < numbersArr.length; i++) {
    // while the value in the numbers array is <= the remaining number, push it into the array to be converted,
    // then find the new remaining number by subtraction
    while (numbersArr[i] <= remainingNum) {
      arrayToConvert.push(`${numbersArr[i]}`);
      remainingNum = remainingNum - numbersArr[i];
    }
  }

  // for each number in the array to be converted into roman numerals, compare it to the key in the roman numerals object
  arrayToConvert.forEach(num => {
    for (let key in romansObj) {
      // if the number in the array is equal to the key, push the value into the roman numerals string
      if (num === key) {
        romanNum += romansObj[key];
      }
    }
  });

  // finally, return the converted roman numeral
  return romanNum;
}

console.log(convertToRoman(3999));
console.log(convertToRoman(1984));
console.log(convertToRoman(57));
console.log(convertToRoman(74));
console.log(convertToRoman(21));
