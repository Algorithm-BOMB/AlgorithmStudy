const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", async function () {
  const num = input[0].split(" ");
  const n = parseInt(num[0]);
  const m = parseInt(num[1]);

  for (let i = n; i <= m; i++) {
    for (let j = 2; j <= i; j++) {
      if (i % j === 0) {
        if (i === j) {
          console.log(i);
        } else {
          break;
        }
      }
    }
  }

  process.exit();
});
