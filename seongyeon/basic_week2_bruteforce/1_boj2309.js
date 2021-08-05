const stdin = require('fs').readFileSync('/dev/stdin').toString();

const dwarfs = stdin
  .split('\n')
  .map(Number)
  .sort((a, b) => {
    return a - b;
  });
let sum = 0;
for (let height of dwarfs) sum += height;

let i, j;
outer: for (i = 0; i < 8; i++) {
  sum -= dwarfs[i];
  for (j = i + 1; j < 9; j++) {
    sum -= dwarfs[j];
    if (sum === 100) break outer;
    sum += dwarfs[j];
  }
  sum += dwarfs[i];
}

let result = '';
for (let index in dwarfs) {
  if (index == i || index == j) continue;
  result += dwarfs[index] + '\n';
}
console.log(result);
