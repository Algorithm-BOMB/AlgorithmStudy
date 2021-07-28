const stdin = require('fs').readFileSync('/dev/stdin').toString();

const [m, n] = stdin.split(' ').map(Number);
let isPrimeNumber = new Array(n + 1).fill(true);
let result = [];

isPrimeNumber[1] = false;
for (let i = 2; i <= n; i++) {
  if (isPrimeNumber[i])
    for (let j = i * 2; j <= n; j += i) {
      isPrimeNumber[j] = false;
    }
}

for (let i = m; i <= n; i++) {
  if (isPrimeNumber[i]) result.push(i);
}

console.log(result.join('\n'));
