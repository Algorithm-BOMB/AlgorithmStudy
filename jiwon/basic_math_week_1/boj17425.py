import sys

# 약수의 합2랑 별로 다를게 없음..
length = 1000000
f = [1] * (length + 1)
g = [0] * (length + 1)
for i in range(2, length + 1):
    for j in range(1, length + 1):
        if i * j > length:
            break
        f[i * j] += i
for i in range(1, length + 1):
    g[i] = g[i - 1] + f[i]

for _ in range(int(input())):
    n = int(sys.stdin.readline())
    sys.stdout.write(str(g[n]) + "\n")
