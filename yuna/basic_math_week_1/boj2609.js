/* 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오. */

const { RSA_X931_PADDING } = require("constants");
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function sol(a, b) {
  if (b === 0) return a;
  else return sol(b, a % b);
}

rl.on("line", function (line) {
  const input = line.split(" ");
  let num1 = Number(input[0]);
  let num2 = Number(input[1]);

  const gcd = sol(num1, num2);
  const lcm = (num1 * num2) / gcd;
  console.log(gcd);
  console.log(lcm);

  rl.close();
}).on("close", function () {
  process.exit();
});
