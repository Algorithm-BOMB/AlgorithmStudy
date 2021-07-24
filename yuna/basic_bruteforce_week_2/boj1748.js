/* 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
   1234567891011121314151617181920212223...
   이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오. */

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", async function () {
  let result = 0;
  result = writeNum(input[0]);
  console.log(result);
  process.exit();
});

let writeNum = (n) => {
  let result = 0;
  let a = 1;
  let pow = 10;

  for (let i = 1; i <= n; i++) {
    if (i % pow < pow - 1) {
      result += a;
      console.log("if문 rs = ", result);
    } else {
      result += a;
      pow *= 10;
      a++;
      console.log("i: ", i, "a: ", a, " n: ", n);
    }
  }
  return result;
};
