/** This question is from Project Euler: (Problem 3) Largest Prime Factor

The prime factors of 13195 are 5, 7, 13 and 29. The largest of these is 29.
What is the largest prime factor of the number 600851475143?
*/

//Solution: Find the largest prime factor of any number
function largestPrimeFactor(number) {
  // declare a variable i to represent the largest prime factor
  // assign the input number to the variable greatest prime
  let i;
  let greatestPrime = number;

  // keep dividing by prime factors starting with 2
  for (i = 2; i <= greatestPrime; i++) {
    if (greatestPrime % i == 0) {
      greatestPrime /= i;
      i--;
    }
  }
  return i;
}

// Output should be 29
console.log(largestPrimeFactor(13195));
// Output should be 6857
console.log(largestPrimeFactor(600851475143));
