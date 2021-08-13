def dfs(a):
    global cnt
    if a > n:
        return
    elif a == n:
        cnt += 1
        return
    else:
        for i in range(1, 4):
            dfs(a + i)


arr = [0] * 11
for _ in range(int(input())):
    n = int(input())
    cnt = 0
    if arr[n] == 0:
        dfs(0)
        arr[n] = cnt
    print(arr[n])
