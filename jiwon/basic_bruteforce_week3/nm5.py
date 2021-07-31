# 길이가 m인 수열을 모두 구하는 프로그램을 작성하시오.

# 풀이
# 1. M, N을 입력 받는다.
# 2. 사전순으로 증가하는 식으로 출력되게끔 구현하면 된다.


def dfs(a):
    if a == m:
        print(" ".join(res))
        return
    for j in range(n):
        if not v[j]:
            res[a] = nums[j]
            v[j] = True
            dfs(a + 1)
            v[j] = False


n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))
nums = list(map(str, nums))
res = [0] * m
v = [False] * n
dfs(0)
