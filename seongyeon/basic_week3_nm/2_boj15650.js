const stdin = require('fs').readFileSync('/dev/stdin').toString();

const [n, m] = stdin.split(' ').map(Number);
let arr = new Array(m);
let result = '';

function dfs(depth, start) {
  if (depth === m) {
    result += arr.join(' ') + '\n';
    return;
  }

  for (let i = start; i <= n; i++) {
    arr[depth] = i;
    dfs(depth + 1, i + 1);
  }
}

dfs(0, 1);
console.log(result);
