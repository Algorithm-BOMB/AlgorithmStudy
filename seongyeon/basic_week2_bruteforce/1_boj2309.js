// const stdin = require('fs').readFileSync('/dev/stdin').toString();
const stdin = `32
2
79
4
5
6
3
1
10`;

const nums = stdin
  .split('\n')
  .map(Number)
  .sort((a, b) => {
    return a - b;
  });
let arr = new Array(7);
let sum = 0;
let isFound = false;

function findDwarf(depth, index) {
  if (isFound) return;

  if (depth === 7) {
    if (sum === 100) {
      isFound = true;
      console.log(arr.join('\n'));
    }
  } else if (index === 9) return;
  else {
    arr[depth] = nums[index];
    sum += nums[index];
    findDwarf(depth + 1, index + 1);
    sum -= nums[index];
    findDwarf(depth, index + 1);
  }
}

findDwarf(0, 0);
