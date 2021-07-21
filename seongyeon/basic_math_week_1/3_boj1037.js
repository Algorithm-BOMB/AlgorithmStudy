/* 입력 */
const fs = require('fs');

const stdin = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `4
4 6 2 3`
).split('\n');

/* 구현 */

const len = stdin[0];
const nums = stdin[1].split(' ');

// sort 이용
nums.sort(function (a, b) {
  return a - b;
});

console.log(nums[0] * nums[len - 1]);

// max, min 이용 - 메모리랑 시간 더 많이 잡아먹음
// const max = Math.max.apply(null, nums);
// const min = Math.min.apply(null, nums);
// console.log(max * min);
