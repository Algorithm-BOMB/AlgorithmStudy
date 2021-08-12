// const stdin = require('fs').readFileSync('/dev/stdin').toString().trim();

const stdin = `3
CCP
CCP
PPC`;
const input = stdin.split('\n');
const N = Number(input[0]);
let candies = new Array(N);
for (let i = 1; i <= N; i++) candies[i - 1] = input[i].split('');
