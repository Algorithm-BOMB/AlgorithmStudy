const stdin = require('fs').readFileSync('/dev/stdin').toString();

const [n, m] = stdin.split(' ').map(Number);
let arr = [];
let visited = new Array(9).fill(false);
let result = '';

function dfs(depth) {
  if (depth === m) {
    result += arr.join(' ') + '\n';
    return;
  }

  for (let i = 1; i <= n; i++) {
    if (visited[i]) continue;

    visited[i] = true;
    arr.push(i);

    dfs(depth + 1);

    visited[i] = false;
    arr.pop();
  }
}

dfs(0);
console.log(result);
