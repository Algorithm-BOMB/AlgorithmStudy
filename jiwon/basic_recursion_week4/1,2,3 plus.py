# 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하라

# 풀이
# 1. 1, 2, 3을 더하는 각각의 재귀 함수를 만든다.
# 2. 종료 조건은 n보다 클 때이며, n일 때 cnt + 1을 한다.


import sys

cnt = 0


def dfs(a, n):
    global cnt
    if a > n:
        return
    elif a == n:
        cnt += 1
        return
    dfs(a + 1, n)
    dfs(a + 2, n)
    dfs(a + 3, n)


def solution():
    global cnt
    for _ in range(int(input())):
        cnt = 0
        n = int(sys.stdin.readline())
        dfs(0, n)
        sys.stdout.write(str(cnt) + "\n")


solution()
