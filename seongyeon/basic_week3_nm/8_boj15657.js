const stdin = require('fs').readFileSync('/dev/stdin').toString();

const input = stdin.split('\n');
const [n, m] = input[0].split(' ').map(Number);
const nums = input[1]
  .split(' ')
  .map(Number)
  .sort((a, b) => {
    return a - b;
  });

let arr = new Array(m);
let result = '';

function dfs(depth, start) {
  if (depth === m) {
    result += arr.join(' ') + '\n';
    return;
  }

  for (let i = start; i < n; i++) {
    arr[depth] = nums[i];
    dfs(depth + 1, i);
  }
}

dfs(0, 0);
console.log(result);
