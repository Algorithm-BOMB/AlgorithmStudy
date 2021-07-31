# 길이가 m인 수열을 모두 구하는 프로그램을 작성하시오.

# 풀이
# 1. M, N을 입력 받는다.
# 2. 사전순으로 증가하는 식으로 출력되게끔 구현하면 된다.


def dfs(a, lst):
    if a == m:
        lst = list(map(str, lst))
        print(" ".join(lst))
        return
    for j in range(n):
        if not v[j]:
            lst[a] = nums[j]
            if a == 0 or lst[a - 1] < lst[a]:
                v[j] = True
                dfs(a + 1, lst)
                v[j] = False


n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))
res = [0] * m
v = [False] * n
dfs(0, res)
