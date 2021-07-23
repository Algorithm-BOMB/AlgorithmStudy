const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .split(' ')
  .map(Number);

let bigger, smaller;
if (input[0] > input[1]) {
  bigger = input[0];
  smaller = input[1];
} else {
  bigger = input[1];
  smaller = input[0];
}

const multiply = bigger * smaller;
let remainder = bigger % smaller;
while (remainder !== 0) {
  bigger = smaller;
  smaller = remainder;
  remainder = bigger % smaller;
}

console.log(smaller);
console.log(multiply / smaller);
