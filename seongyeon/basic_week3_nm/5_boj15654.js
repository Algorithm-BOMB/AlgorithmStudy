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
let visited = new Array(9).fill(false);
let result = '';

function dfs(depth) {
  if (depth === m) {
    result += arr.join(' ') + '\n';
    return;
  }

  for (let i = 0; i < n; i++) {
    if (visited[i]) continue;
    arr[depth] = nums[i];
    visited[i] = true;
    dfs(depth + 1);
    visited[i] = false;
  }
}

dfs(0);
console.log(result);
