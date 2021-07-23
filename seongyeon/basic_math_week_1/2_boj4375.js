const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map(Number);

let answer;
let count;
for (number of input) {
  answer = 1;
  count = 1;
  while (answer % number != 0) {
    answer = answer * 10 + 1;
    answer %= number;
    count++;
  }
  console.log(count);
}

// 왜 시간초과냐;;
