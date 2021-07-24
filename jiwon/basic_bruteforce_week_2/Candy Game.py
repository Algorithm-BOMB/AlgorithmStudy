# N x N
# 인접한 두 칸의 사탕을 골라 사탕을 서로 교환
# 모두 같은 색으로 이루어진 가장 긴 연속 부분을 고른 다음 사탕을 모두 먹는다.
# 상근이가 먹을 수 있는 사탕의 최대 개수를 구하라

# 풀이
# 1. n을 입력 받고 나머지 n만큼의 정사각형 입력 받기
# 2. 상하좌우로 이동시켜서 확인하기, 확인 할 때 가로 세로 O 대각선 X

dx = [0, 1]
dy = [1, 0]


def check(b, n):
    r_res = 0
    c_res = 0
    for r in range(n):
        r_cnt = 1
        c_cnt = 1
        for i in range(1, n):
            if b[i][r] == b[i - 1][r]:
                r_cnt += 1
            else:
                r_res = max(r_cnt, r_res)
                r_cnt = 1
            if b[r][i] == b[r][i - 1]:
                c_cnt += 1
            else:
                c_res = max(c_cnt, c_res)
                c_cnt = 1
        c_res = max(c_cnt, c_res)
        r_res = max(r_cnt, r_res)
    return max(c_res, r_res)


def solution():
    n = int(input())
    b = [list(input()) for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            for k in range(2):
                x = j + dx[k]
                y = i + dy[k]
                tmp = check(b, n)
                cnt = max(cnt, tmp)
                if x < n and y < n:
                    b[i][j], b[y][x] = b[y][x], b[i][j]
                    tmp = check(b, n)
                    b[i][j], b[y][x] = b[y][x], b[i][j]
                    cnt = max(cnt, tmp)
    print(cnt)


solution()
