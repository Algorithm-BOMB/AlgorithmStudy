const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .split(' ')
  .map(Number);

let [bigger, smaller] = input.sort((a, b) => b - a);

const multiply = bigger * smaller;
let remainder = bigger % smaller;
while (remainder !== 0) {
  bigger = smaller;
  smaller = remainder;
  remainder = bigger % smaller;
}

console.log(smaller);
console.log(multiply / smaller);
