/** This question is from Project Euler: (Problem 2) Even Fibonacci Numbers

Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
By starting with 1 and 2, the first 10 terms will be:
        1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, 
find the sum of the even-valued terms.
*/

// Function used to find the next Fibonacci number given its two previous terms
function findNextFibTerm(prev, next) {
  return prev + next;
}

// Function used to find the sum of the even terms in the sequence such that the terms do not exceed n
function fiboEvenSum(n) {
  let prev = 1;
  let next = 1;
  let evenSum = 0;
  let curr = findNextFibTerm(prev, next);

  // while the current term is less than the given n value
  // if it is even, add the current value to the even sum
  while (curr < n) {
    if (curr % 2 === 0) {
      evenSum += curr;
    }
    // set the new two previous terms to be used in the function to find the next Fibonacci term
    prev = next;
    next = curr;
    curr = findNextFibTerm(prev, next);
  }
  // finally return the evenSum
  return evenSum;
}

// Output should be 4613732
console.log(fiboEvenSum(4000000));