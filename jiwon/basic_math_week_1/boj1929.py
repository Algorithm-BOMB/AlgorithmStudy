# 에라토스테네스의 체 활용

m, n = map(int, input().split())
limit = n + 1
p = [False] * limit
p[1] = True
for i in range(2, limit):
    if p[i]:
        continue
    for j in range(i + i, limit, i):
        p[j] = True
res_list = []
for i in range(m, limit):
    if not p[i]:
        res_list.append(str(i))
print("\n".join(res_list))
