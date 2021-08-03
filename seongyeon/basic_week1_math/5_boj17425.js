const stdin = require('fs').readFileSync('/dev/stdin').toString();

const LENGTH = 1000001;
const nList = stdin.split('\n').map(Number);
let fList = new Array(LENGTH).fill(1);
let gList = new Array(LENGTH).fill(0);

for (let i = 2; i < LENGTH; i++) {
  for (let j = 1; i * j < LENGTH; j++) {
    fList[i * j] += i;
  }
}

for (let i = 1; i < LENGTH; i++) {
  gList[i] = gList[i - 1] + fList[i];
}

let result = '';
for (let i = 1; i <= nList[0]; i++) {
  result += gList[nList[i]] + '\n';
}

console.log(result);
