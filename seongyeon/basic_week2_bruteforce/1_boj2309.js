const stdin = require('fs').readFileSync('/dev/stdin').toString().trim();

const dwarfs = stdin
  .split('\n')
  .map(Number)
  .sort((a, b) => {
    return a - b;
  });

let sum = 0;
for (let height of dwarfs) sum += height;

outer: for (let i = 0; i < 8; i++) {
  for (let j = i + 1; j < 9; j++) {
    if (sum - dwarfs[i] - dwarfs[j] === 100) {
      dwarfs.splice(j, 1);
      dwarfs.splice(i, 1);
      break outer;
    }
  }
}

console.log(dwarfs.join('\n'));
