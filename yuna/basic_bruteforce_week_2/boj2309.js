/* 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 
   일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
   아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 
   뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
   아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오. */

const { RSA_X931_PADDING } = require("constants");
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", async function () {
  let answer = whiteSnow(input);
  console.log(answer.sort((a, b) => a - b).join("\n"));
  process.exit();
});

let whiteSnow = (arr) => {
  const sum = arr.reduce((accumulator, currentValue) => {
    return accumulator + currentValue * 1;
  }, 0); // 합: 140
  let bool = false;
  const diff = sum - 100; // 차이값: 40

  for (let i = 0; i < arr.length; i++) {
    let head = arr.shift();
    for (let j = 0; j < arr.length; j++) {
      if (head * 1 + arr[j] * 1 == diff) {
        bool = true;
        arr.splice(j, 1);
        break;
      }
    }
    if (bool) break;
    else arr.push(head);
  }
  return arr;
};
