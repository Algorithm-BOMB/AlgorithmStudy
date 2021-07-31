const stdin = require('fs').readFileSync('/dev/stdin').toString();
const input = stdin.split('\n').map(Number);
const LENGTH = 1000000;
let isPrime = new Array(LENGTH + 1).fill(true);

isPrime[1] = false;
for (let i = 2; i <= LENGTH; i++) {
  if (isPrime[i])
    for (let j = i * 2; j <= LENGTH; j += i) {
      isPrime[j] = false;
    }
}

let isRight;
let result = '';
for (n of input) {
  if (n === 0) break;
  isRight = false;
  for (let j = 2; j <= n / 2; j++) {
    if (isPrime[j] && isPrime[n - j]) {
      result += `${n} = ${j} + ${n - j}\n`;
      isRight = true;
      break;
    }
  }
  if (!isRight) result.push("Goldbach's conjecture is wrong.");
}

console.log(result);
