# 소수 찾기
# 에라토스테네스의 체


p = [False] * 1001
limit = 1001
p[1] = True
for i in range(2, limit):
    if p[i]:
        continue
    for j in range(i + i, limit, i):
        p[j] = True
n = int(input())
nums = list(map(int, input().split()))
cnt = 0
for num in nums:
    if not p[num]:
        cnt += 1
print(cnt)
