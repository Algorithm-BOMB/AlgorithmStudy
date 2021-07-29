const stdin = require('fs').readFileSync('/dev/stdin').toString();

const input = stdin.split('\n').map(Number);
const LENGTH = 1000000;
let isPrimeNumber = new Array(LENGTH + 1).fill(true);

isPrimeNumber[1] = false;
for (let i = 2; i <= LENGTH; i++) {
  if (isPrimeNumber[i])
    for (let j = i * 2; j <= LENGTH; j += i) {
      isPrimeNumber[j] = false;
    }
}

let n, primeNumber;
let result = [];
for (let i = 0; i < input.length - 1; i++) {
  n = input[i];
  primeNumber = 2;
  while (primeNumber <= n - primeNumber) {
    if (isPrimeNumber[n - primeNumber]) {
      result.push(n + ' = ' + primeNumber + ' + ' + (n - primeNumber));
      break;
    }
    while (!isPrimeNumber[++primeNumber]) {}
  }
  if (primeNumber > n - primeNumber)
    result.push("Goldbach's conjecture is wrong.");
}

console.log(result.join('\n'));
