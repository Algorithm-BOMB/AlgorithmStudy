# 길이가 m인 수열을 모두 구하는 프로그램을 작성하시오.

# 풀이
# 1. M, N을 입력 받는다.
# 2. 조합 처럼 구현하면 된다.


def dfs(a, lst):
    if a == m:
        print(" ".join(lst))
        return
    for j in range(a, n):
        lst[a] = nums[j]
        if not v[j]:
            if a == 0 or (a > 0 and lst[a - 1] < lst[a]):
                v[j] = True
                dfs(a + 1, lst)
                v[j] = False


n, m = map(int, input().split())
nums = [str(i + 1) for i in range(n)]
res = [0] * m
v = [False] * n
dfs(0, res)
