"use strict";

/* 
Create times table
    1,2,3...10
    2,4,6...20
    ...
    10,20,30...100

        Then create 2d array and fill it in with the data above
        output the 2d array
 */

let value = 0;
let timesTable = [];

for (let i = 1; i <= 10; i++) {
  let table = [];
  for (let j = 1; j <= 10; j++) {
    value = i * j;
    table.push(value);
  }
  timesTable.push(table);
}
console.log(timesTable);
