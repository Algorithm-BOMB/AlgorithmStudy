const stdin = require('fs').readFileSync('/dev/stdin').toString();

const input = stdin.split('\n');
const N = Number(input[0]);
let time = new Array(N + 1);
let pay = new Array(N + 1);

for (let i = 1; i <= N; i++)
  [time[i], pay[i]] = input[i].split(' ').map(Number);

let max = 0;
function getMaxPay(day, sum) {
  if (day > N + 1) return;
  else if (day === N + 1) {
    if (max < sum) max = sum;
    return;
  } else {
    getMaxPay(day + time[day], sum + pay[day]);
    getMaxPay(day + 1, sum);
  }
}

getMaxPay(1, 0);
console.log(max);
