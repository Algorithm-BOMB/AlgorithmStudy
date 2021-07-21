/* 입력 */
const fs = require('fs');

const stdin = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `3
7
9901`
).split('\n');

/* 구현 */
let oneNumber;
for (number of stdin) {
  oneNumber = '1';
  while (oneNumber % number != 0) oneNumber += '1';

  console.log(oneNumber.length);
}

// 시간초과ㅠ
