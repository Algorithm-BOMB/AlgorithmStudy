/* 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
   - 1부터 N까지 자연수 중에서 M개를 고른 수열
   - 같은 수를 여러 번 골라도 된다.
   - 고른 수열은 비내림차순이어야 한다.
       - 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다. */

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
let list = [];
let result = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", async function () {
  input = input[0].split(" ");
  let n = input[0];
  let m = input[1];
  dfs(0, n, m, 0);
  console.log(result.join("\n"));
});

let dfs = function (cnt, n, m, k) {
  if (cnt == m) {
    result.push(list.join(" "));
    return 1;
  }
  for (let i = 1; i <= n; i++) {
    if (k <= i) {
      list[cnt] = i;
      dfs(cnt + 1, n, m, list[cnt]);
    }
  }
  return 1;
};
