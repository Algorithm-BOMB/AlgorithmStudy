/* (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
   (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
   세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오. */

// readline 모듈을 import
const readline = require("readline");

// 인터페이스 객체 생성
// process의 입출력 스트림을 input과 output에 할당
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", function (line) {
  const input = line.split(" ");

  // 입력받은 값
  let num1 = Number(input[0]);
  let num2 = Number(input[1]);
  let num3 = Number(input[2]);

  // 계산
  const result1 = (num1 + num2) % num3;
  const result2 = ((num1 % num3) + (num2 % num3)) % num3;
  const result3 = (num1 * num2) % num3;
  const result4 = ((num1 % num3) * (num2 % num3)) % num3;

  console.log(result1);
  console.log(result2);
  console.log(result3);
  console.log(result4);

  rl.close();
}).on("close", function () {
  process.exit();
});
