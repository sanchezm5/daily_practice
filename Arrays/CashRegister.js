/* This project is from freeCodeCamp

JavaScript Algorithms and Data Structures Projects: Cash Register

Design a cash register drawer function checkCashRegister() that accepts 
purchase price as the first argument (price), payment as the second argument (cash), 
and cash-in-drawer (cid) as the third argument, where cid is a 2D array listing available currency.

The checkCashRegister() function should always return an object with a status key and a change key.
Return {status: "INSUFFICIENT_FUNDS", change: []} if cash-in-drawer is less than the change due, 
or if you cannot return the exact change. Return {status: "CLOSED", change: [...]} with cash-in-drawer 
as the value for the key change if it is equal to the change due.

Otherwise, return {status: "OPEN", change: [...]}, with the change due in coins and bills, sorted in 
highest to lowest order, as the value of the change key.

Input: 
  19.5, 20, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], 
  ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]]  
Output: 
  {status: 'OPEN', change: [["QUARTER", 0.5]]} */

//Cash Register Solution
function checkCashRegister(price, cash, cid) {
  let change = { status: "", change: [] };
  let remainingChange = +(cash - price).toFixed(2);
  let total = 0;
  const changeArray = [0.01, 0.05, 0.1, 0.25, 1, 5, 10, 20, 100];

  //determine the total amount of the cash-in-drawer
  cid.forEach(elem => {
    total += elem[1];
  });
  total = +total.toFixed(2);

  //determine the status of the change due
  if (remainingChange > total) {
    change.status = "INSUFFICIENT_FUNDS";
    return change;
  } else if (remainingChange < total) {
    change.status = "OPEN";
  } else {
    change.status = "CLOSED";
    change.change = cid;
    return change;
  }

  while (remainingChange > 0) {
    // iterate through the cid array from right to left
    for (let i = cid.length - 1; i >= 0; i--) {
      // if the amount of the cid is >= denomination, find the greatest number of the denomination needed
      if (cid[i][1] >= changeArray[i]) {
        let valOfNumOfBills =
          Math.floor(remainingChange / changeArray[i]) * changeArray[i];

        // if that amount exceeds the amount of the cid, deduct a multiple of that denomination, then find
        // the new remainingChange amount, the new cid amount
        if (valOfNumOfBills > cid[i][1]) {
          valOfNumOfBills = valOfNumOfBills - changeArray[i];
        }
        remainingChange = (remainingChange - valOfNumOfBills).toFixed(2);
        cid[i][1] = cid[i][1] - valOfNumOfBills;

        // if the value of the denomination needed is > 0 and the cid amount is non-negative, push the
        // name and amt into the change array
        if (valOfNumOfBills > 0 && cid[i][1] >= 0) {
          change.change.push([cid[i][0], valOfNumOfBills]);
        }

        // if the cid amount is negative, return the correct change
        if (cid[i][1] < 0) {
          change.status = "INSUFFICIENT_FUNDS";
          change.change = [];
          return change;
        }
      }
    }
  }
  return change;
}

console.log(
  checkCashRegister(19.5, 20, [
    ["PENNY", 1.01],
    ["NICKEL", 2.05],
    ["DIME", 3.1],
    ["QUARTER", 4.25],
    ["ONE", 90],
    ["FIVE", 55],
    ["TEN", 20],
    ["TWENTY", 60],
    ["ONE HUNDRED", 100]
  ])
);

console.log(
  checkCashRegister(19.5, 20, [
    ["PENNY", 0.01],
    ["NICKEL", 0],
    ["DIME", 0],
    ["QUARTER", 0],
    ["ONE", 1],
    ["FIVE", 0],
    ["TEN", 0],
    ["TWENTY", 0],
    ["ONE HUNDRED", 0]
  ])
);

console.log(
  checkCashRegister(19.5, 20, [
    ["PENNY", 0.5],
    ["NICKEL", 0],
    ["DIME", 0],
    ["QUARTER", 0],
    ["ONE", 0],
    ["FIVE", 0],
    ["TEN", 0],
    ["TWENTY", 0],
    ["ONE HUNDRED", 0]
  ])
);

console.log(
  checkCashRegister(3.26, 100, [
    ["PENNY", 1.01],
    ["NICKEL", 2.05],
    ["DIME", 3.1],
    ["QUARTER", 4.25],
    ["ONE", 90],
    ["FIVE", 55],
    ["TEN", 20],
    ["TWENTY", 60],
    ["ONE HUNDRED", 100]
  ])
);
