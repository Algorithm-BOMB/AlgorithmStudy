/* 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 
   어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오. */

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function sol(input) {
  const divisors = input[1].split(" ");
  return Math.min(...divisors) * Math.max(...divisors);
}

const input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  console.log(sol(input));
  process.exit();
});
