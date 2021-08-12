const stdin = require('fs').readFileSync('/dev/stdin').toString().trim();

const input = stdin.split('\n');
const [N, M, K] = input[0].split(' ').map(Number);
let grid = new Array(N);
for (let i = 1; i <= N; i++) grid[i - 1] = input[i].split(' ').map(Number);

let max = -40000;
let trap = new Array(N);
for (let i = 0; i < N; i++) trap[i] = new Array(M).fill(0);

function check(i, j) {
  trap[i][j]++;
  if (i > 0) trap[i - 1][j]++;
  if (i < N - 1) trap[i + 1][j]++;
  if (j > 0) trap[i][j - 1]++;
  if (j < M - 1) trap[i][j + 1]++;
}

function uncheck(i, j) {
  trap[i][j]--;
  if (i > 0) trap[i - 1][j]--;
  if (i < N - 1) trap[i + 1][j]--;
  if (j > 0) trap[i][j - 1]--;
  if (j < M - 1) trap[i][j + 1]--;
}

function dfs(pick, sum) {
  if (pick === K) {
    if (max < sum) max = sum;
  } else {
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (trap[i][j] > 0) continue;
        check(i, j);
        dfs(pick + 1, sum + grid[i][j]);
        uncheck(i, j);
      }
    }
  }
}

dfs(0, 0);
console.log(max);
