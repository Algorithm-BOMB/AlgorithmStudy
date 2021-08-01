# n x m 보드
# 회전, 대칭 가능
# 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력

# 풀이
# 1. N, M, 보드를 입력
# 2. 각 도형을 리스트..? 아니면 반복문으로 ??
# 3. 회전, 대칭을 구현
# - (0, 0), (1, 0), (2, 0), (2, 1)
# -> (
# 4. 최대인 값과 비교
# M, N의 보드
# 회전, 대칭이 된다.

# 풀이
# 1. n, m, board 입력
# 2. dfs로 테트로미노 구현, 길이가 4될 때 종료
# 3. ㅏ, ㅓ, ㅗ, ㅜ는 기존의 dfs로는 불가능하므로, 따로 구현
# 3-1. 회전할 수 있도록 하기, 리스트에 좌표 초기화
# 4. 최댓값과 비교

from sys import stdin


a = [(-1, 0), (1, 0), (0, 1), (0, -1)]
aa = [[(0, -1), (-1, 0), (0, 1)], [(0, -1), (1, 0), (0, 1)], [(-1, 0), (1, 0), (0, 1)], [(-1, 0), (1, 0), (0, -1)]]
answer = 0
n, m = map(int, input().split())
b = [list(map(int, stdin.readline().split())) for _ in range(n)]


def dfs(r, c, v, val):
    global answer
    if len(v) == 4:
        answer = max(answer, val)
        return
    for i in range(4):
        nr = r + a[i][0]
        nc = c + a[i][1]
        if 0 <= nr < n and 0 <= nc < m and (nr, nc) not in v:
            v.append((nr, nc))
            dfs(nr, nc, v, val + b[nr][nc])
            v.pop()


def dfs2(r, c):
    global answer
    for t in aa:
        val = b[r][c]
        for xy in t:
            nr = r + xy[0]
            nc = c + xy[1]
            if 0 <= nr < n and 0 <= nc < m:
                val += b[nr][nc]
            else:
                break
        answer = max(answer, val)


def solution():
    for r in range(n):
        for c in range(m):
            dfs(r, c, [(r, c)], b[r][c])
            dfs2(r, c)
    print(answer)


solution()

