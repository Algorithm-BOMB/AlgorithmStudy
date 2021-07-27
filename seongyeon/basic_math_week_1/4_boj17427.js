const stdin = require('fs').readFileSync('/dev/stdin').toString();

const n = Number(stdin);
let answer = 0;
for (let i = 1; i <= n; i++) {
  answer += Math.floor(n / i) * i;
}

console.log(answer);
