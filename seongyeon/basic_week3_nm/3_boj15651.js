const stdin = require('fs').readFileSync('/dev/stdin').toString();

const [n, m] = stdin.split(' ').map(Number);
let arr = new Array(m);
let result = '';

function dfs(depth) {
  if (depth === m) {
    result += arr.join(' ') + '\n';
    return;
  }

  for (let i = 1; i <= n; i++) {
    arr[depth] = i;
    dfs(depth + 1);
  }
}

dfs(0);
console.log(result);
