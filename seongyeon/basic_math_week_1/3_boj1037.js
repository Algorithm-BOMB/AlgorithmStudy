const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

const nums = input[1].split(' ').map(Number);
let max = 1;
let min = 1000001;
for (num of nums) {
  if (num > max) max = num;
  if (num < min) min = num;
}

console.log(max * min);
