const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let oneNumber;
for (number of input) {
  oneNumber = '1';
  while (oneNumber % number != 0) oneNumber += '1';

  console.log(oneNumber.length);
}

// 시간초과ㅠ
