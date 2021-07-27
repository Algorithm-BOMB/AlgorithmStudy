const stdin = require('fs').readFileSync('/dev/stdin').toString();

const LENGTH = 1000001;
const [m, n] = stdin.split(' ').map(Number);
let eratos = new Array(LENGTH).fill(0);

eratos[1] = 1;
for (let i = 2; i < LENGTH && eratos[i] === 0; i++) {
  for (let j = 2; i * j < LENGTH; j++) {
    eratos[i * j] = 1;
  }
}

for (let i = m; i <= n; i++) {
  if (eratos[i] === 0) console.log(i);
}
