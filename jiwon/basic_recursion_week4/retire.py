# N + 1에 퇴사, N일동안 최대한 많이 상담
# N + 1은 상담 X
# 최대 수익을 구하는 프로그램을 작성

# 풀이
# 1. 모든 상담날짜 별로 시도해본다.
# 2. 시도한 날짜들의 합과 최종 결과의 합을 비교하여 큰 것을 답으로 한다.
# 3. N을 까지는 가능하지만 N + 1일 때 종료시켜야한다.

from sys import stdin


def dfs(a, total):
    global result
    if a <= n:
        result = max(total, result)
    for i in range(a, n):
        if a + w[i][0] <= n:
            dfs(i + w[i][0], total + w[i][1])


n = int(stdin.readline())
w = [(0, 0)]
result = 0
for _ in range(n):
    t, p = map(int, stdin.readline().split())
    w.append((t, p))
n += 1
dfs(1, 0)
print(result)
