const stdin = require('fs').readFileSync('/dev/stdin').toString();

const input = stdin.split(' ');
const a = Number(input[0]);
const b = Number(input[1]);
const c = Number(input[2]);

console.log((a + b) % c);
console.log(((a % c) + (b % c)) % c);
console.log((a * b) % c);
console.log(((a % c) * (b % c)) % c);
