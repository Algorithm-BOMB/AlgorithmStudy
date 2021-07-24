/* 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
   정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오. */

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", async function () {
  const count = input[0];
  const dp = [0, 1, 2, 4];
  for (let j = 0; j < count; j += 1) {
    let i = 4;
    for (; i <= input[j + 1]; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    console.log(dp[input[j + 1]]);
  }
  process.exit();
});
