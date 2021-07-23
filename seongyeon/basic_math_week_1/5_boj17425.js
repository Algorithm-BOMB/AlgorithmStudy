const stdin = require('fs').readFileSync('/dev/stdin').toString();

const input = stdin.split('\n').map(Number);
let n;
for (let test = 1; test < input.length; test++) {
  n = input[test];
  let gSum = 0;
  let fSum;

  // n 이하의 자연수
  for (let i = 1; i <= n; i++) {
    fSum = 0;

    // 약수의 합 구하기
    for (let j = 1; j * j <= i; j++) {
      if (i % j === 0) {
        fSum += j;
        if (j * j < i) {
          fSum += i / j;
        }
      }
    }

    gSum += fSum;
  }

  console.log(gSum);
}

// 시간초과
