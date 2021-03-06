const stdin = require('fs').readFileSync('/dev/stdin').toString();

const [n, m] = stdin.split(' ').map(Number);
let arr = new Array(m);
let visited = new Array(9).fill(false);
let result = '';

function dfs(depth) {
  if (depth === m) {
    result += arr.join(' ') + '\n';
    return;
  }

  for (let i = 1; i <= n; i++) {
    if (visited[i]) continue;
    arr[depth] = i;
    visited[i] = true;
    dfs(depth + 1);
    visited[i] = false;
  }
}

dfs(0);
console.log(result);
