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
for (number of stdin) {
  let count = number.length;
  let oneNumber = '1'.repeat(count);
  while (oneNumber % number != 0) {
    count += 1;
    oneNumber += '1';
  }
  console.log(count);
}

// 시간초과ㅠㅠ
