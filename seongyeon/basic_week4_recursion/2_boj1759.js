const stdin = require('fs').readFileSync('/dev/stdin').toString();

const input = stdin.split('\n');
const [L, C] = input[0].split(' ').map(Number);
const alpha = input[1].split(' ').sort();

let arr = new Array(L);
let result = '';
let vowels;

function dfs(depth, start) {
  if (depth === L) {
    vowels = 0;
    arr.forEach(char => {
      if (
        char === 'a' ||
        char === 'e' ||
        char === 'i' ||
        char === 'o' ||
        char === 'u'
      )
        vowels++;
    });
    if (vowels >= 1 && L - vowels >= 2) result += arr.join('') + '\n';
    return;
  }

  for (let i = start; i < C; i++) {
    arr[depth] = alpha[i];
    dfs(depth + 1, i + 1);
  }
}

dfs(0, 0);
console.log(result);
