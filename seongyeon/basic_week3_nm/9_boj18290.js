// const stdin = require('fs').readFileSync('/dev/stdin').toString().trim();

const stdin = `5 5 3
1 9 8 -2 0
-1 9 8 -3 0
-5 1 9 -1 0
0 0 0 9 8
9 9 9 0 0`;
const input = stdin.split('\n');
const [n, m, k] = input[0].split(' ').map(Number);
let grid = new Array(n);
for (let i = 1; i <= n; i++) grid[i - 1] = input[i].split(' ').map(Number);

let max = -40000;
const x = [0, 0, 1, -1];
const y = [-1, 1, 0, 0];
function getMaxK(sum, pick) {
  if (pick === 0) {
    if (sum > max) max = sum;
    return;
  }
}

getMaxK(0, k);
