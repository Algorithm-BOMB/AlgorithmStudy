const stdin = require('fs').readFileSync('/dev/stdin').toString();

const tests = stdin.split('\n').map(Number);
let count;

function dfs(n) {
  if (n === 0) count++;
  else if (n < 0) return;
  else {
    dfs(n - 1);
    dfs(n - 2);
    dfs(n - 3);
  }
}

let result = '';
for (let i = 1; i <= tests[0]; i++) {
  count = 0;
  dfs(tests[i]);
  result += count + '\n';
}

console.log(result);
