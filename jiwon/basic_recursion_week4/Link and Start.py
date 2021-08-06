# i, j가 같은 팀일 때 정해지는 능력치
# 스타트 팀과 링크 팀의 능력치 차이를 최소로 만들어라

# 풀이
# 1. A가 선택하는 경우, B가 선택하는 경우
# 2. 종료 조건 3개를 선택했을 때 <- 이 조건을 맞추는 것이 가능한가 ?
# a == 3, b == 3이여야 한다.
# 3. 모든 경우를 어떻게 재귀 시키는가.

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
res = int(1e9)
n2 = n // 2
v = [False] * n


def dfs(d, a, a_lst):
    global res
    if res == 0:
        return
    if d > 0:
        b_lst = [x for x in range(n) if x not in a_lst]
        a_val = sum_lst(a_lst)
        b_val = sum_lst(b_lst)
        res = min(abs(a_val - b_val), res)
    for i in range(a, n):
        if not v[i]:
            v[i] = True
            a_lst.append(i)
            dfs(d + 1, i + 1, a_lst)
            a_lst.pop()
            v[i] = False


def sum_lst(lst):
    val = 0
    for i, value in enumerate(lst):
        for j in range(i + 1, len(lst)):
            val += board[value][lst[j]]
            val += board[lst[j]][value]
    return val


dfs(0, 0, [])
print(res)
