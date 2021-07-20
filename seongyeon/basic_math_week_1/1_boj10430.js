/* 입력 */
const fs = require('fs');

const stdin =
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `5 8 4`;

/* 구현 */
const abc = stdin.split(' ').map(Number);
console.log((abc[0] + abc[1]) % abc[2]);
console.log(((abc[0] % abc[2]) + (abc[1] % abc[2])) % abc[2]);
console.log((abc[0] * abc[1]) % abc[2]);
console.log(((abc[0] % abc[2]) * (abc[1] % abc[2])) % abc[2]);
