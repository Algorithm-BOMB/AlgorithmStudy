# 길이가 m인 수열을 모두 구하는 프로그램을 작성하시오.

# 풀이
# 1. M, N을 입력 받는다.
# 2. 그냥 구현하면 된다. -> 중요한 건 어떻게 중복을 걸러낼 수 있을지


def dfs(a, lst):
    if a == m:
        print(" ".join(lst))
        return
    for j in range(n):
        lst[a] = nums[j]
        dfs(a + 1, lst)


n, m = map(int, input().split())
nums = [str(i + 1) for i in range(n)]
res = [0] * m
dfs(0, res)
