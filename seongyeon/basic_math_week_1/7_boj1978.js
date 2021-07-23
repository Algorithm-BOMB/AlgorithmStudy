const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

const nums = input[1].split(' ').map(Number);
let count = nums.length;
for (num of nums) {
  if (num === 1) {
    count--;
    continue;
  }
  for (let i = 2; i * i <= num; i++) {
    if (num % i === 0) {
      count--;
      break;
    }
  }
}

console.log(count);
