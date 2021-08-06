# 규현이는 -10~10까지(0 포함) 알고, 덧셈을 배움
# 구간의 합을 할 수 있다.
# s[i][j] -> a[i] ~ a[j]까지 합이 0보다 크면 +, 작으면 -, 0이면 0
# i <= j 항상
# S 배열이 주어졌을 때, N개의 수 A를 구해서 출력해야 한다.
# A도 -10부터 10까지의 정수로만 이루어져 있어야 한다.

# 풀이
# N = 4
# -+0+ / +++ / -- / +
# 1. 배열 -10 ~ 10까지 가지고 있는 것 생성
# 2. -10 ~ 10까지 뽑는 수 dfs 생성
# 3. 조건이 해당되는지 보는 것도 dfs 생성
# 4. 아마 중복된 수는 되지 않을 것


def dfs(d, lst):
    if d == n:
        if check(lst):
            exit(0)
        return
    for i in range(-10, 11):
        if idx_list[d] == '+' and i <= 0:
            continue
        elif idx_list[d] == '-' and i >= 0:
            continue
        elif idx_list[d] == '0' and i != 0:
            continue
        if not v[i + 10]:
            v[i + 10] = True
            lst.append(i)
            dfs(d + 1, lst)
            lst.pop()
            v[i + 10] = False


def check(c):
    idx = 0
    for i in range(n):
        for j in range(i + 1, n + 1):
            val = sum(c[i:j])
            if sign[idx] == '-' and val >= 0:
                return False
            elif sign[idx] == '+' and val <= 0:
                return False
            elif sign[idx] == '0' and val != 0:
                return False
            idx += 1
    c = list(map(str, c))
    print(" ".join(c))
    return True


n = int(input())
sign = input()
v = [False] * 21
a = 0
idx_list = []
adder = n
while a < len(sign):
    idx_list.append(sign[a])
    a += adder
    adder -= 1
dfs(0, [])
