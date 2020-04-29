/** This question is from Project Euler: (Problem 5) Smallest Multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

//Solution: Find the smallest postive number that is evenly divisible by all of the numbers from 1 to n

// To get the least common multiple, you can use GCD
function leastCommonMult(a, b) {
  return (a * b) / greatestCommonDivisor(a, b);
}

// To find the GCD use the Euclidean Algorithm
function greatestCommonDivisor(a, b) {
  if (a === 0) return b;
  if (b === 0) return a;
  return greatestCommonDivisor(b, a % b);
}

// Find the smallest multiple for 1 to n
function smallestMult(n) {
  let smallestLCM = 1;

  for (let i = 2; i <= n; i++) {
    smallestLCM = leastCommonMult(smallestLCM, i);
    console.log("LCM(" + smallestLCM + "," + i + ") = " + smallestLCM);
  }
  return smallestLCM;
}

console.log(smallestMult(20)); // Output: 232792560
