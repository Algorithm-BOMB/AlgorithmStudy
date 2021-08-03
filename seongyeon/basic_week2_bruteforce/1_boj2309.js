// const stdin = require('fs').readFileSync('/dev/stdin').toString();
const stdin = `20
7
23
19
10
15
25
8
13`;

const nums = stdin.split('\n').map(Number);
let arr = new Array(7);
let sum = 0;

function findDwarf(depth, index, remain) {
  if (remain === 0) {
    //blabla
  } else if (index === 9) return;
  else {
    arr[depth] = nums[index];
    findDwarf(depth + 1, index + 1, remain - 1);
    findDwarf(depth, index + 1, remain);
  }
}

findDwarf(0, 0, 7);
