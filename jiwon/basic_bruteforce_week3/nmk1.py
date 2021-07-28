# N x M, K개를 선택, 선택한 칸에 들어 있는 수를 모두 더한 값의 최대값을 구하려고 한다.
# 단, 선택한 두 칸이 인접하면 안된다. (상하좌우)

# 풀이
# 1. n, m, k, n x m의 board 입력
# 2. dfs 구현
# - 종료 조건 : k번 선택했을 때
# - 반복 조건 : 대각선만 가능하게 (-1, -1), (1, 1), (-1, 1) (1, -1) -> 불가능.. 근처에 있는 대각선 값만 더하게 됨, 최적의 값 X
# 3. 최대인 값과 변경


# 틀렸음..
# 트

import sys

d = [(-1, 0), (1, 0), (0, 1), (0, -1)]
n, m, k = map(int, sys.stdin.readline().split())
b = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = -sys.maxsize


def can_visit(r, c, v):
    for y, x in d:
        nr = r + y
        nc = c + x
        if 0 <= nr < n and 0 <= nc < m and v[nr][nc]:
            return False
    return True


def dfs(x, y, depth, v, val):
    global answer
    if depth == k:
        answer = max(answer, val)
        return
    for r in range(y, n):
        for c in range(x if y == r else 0, m):
            if not v[r][c] and can_visit(r, c, v):
                v[r][c] = True
                dfs(c, r, depth + 1, v, val + b[r][c])
                v[r][c] = False


def solution():
    v = [[False] * m for _ in range(n)]
    dfs(0, 0, 0, v, 0)
    print(answer)


solution()
