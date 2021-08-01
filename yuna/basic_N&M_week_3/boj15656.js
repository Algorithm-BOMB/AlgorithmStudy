/* N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
   - N개의 자연수 중에서 M개를 고른 수열
   - 같은 수를 여러 번 골라도 된다. */

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
let list = [];
let result = [];
let numbers = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", async function () {
  let input_n = input[0].split(" ");
  numbers = input[1].split(" ").sort((a, b) => a - b);

  let n = input_n[0];
  let m = input_n[1];
  dfs(0, n, m);
  console.log(result.join("\n"));
  process.exit();
});

let dfs = function (cnt, n, m) {
  if (cnt == m) {
    result.push(list.join(" "));
    return 1;
  }
  for (let i = 0; i < n; i++) {
    list[cnt] = numbers[i];
    dfs(cnt + 1, n, m);
  }
};
