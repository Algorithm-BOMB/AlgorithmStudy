/* eslint-disable no-undef */

/* 입력 */
const fs = require('fs');
const stdin = (process.platform === 'linux'
	? fs.readFileSync('/dev/stdin').toString()
	: `10 10 3
13 2 5 11 7 8 2 4 9 10
1
2
3
8
9
10
11
16
17
49`
).split('\n');

/* 구현 */


/* 출력 */
console.log(stdin);