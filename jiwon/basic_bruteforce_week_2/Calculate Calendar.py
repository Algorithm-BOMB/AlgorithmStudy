# 지구 E 1 <= E <= 15, 태양 1 <= S <= 28, 달 1 <= M <= 19

# 풀이
# 1. 1부터 시작해서 E, S, M이 다 맞는 지 확인하기


def check(a, esm):
    e = a % 15
    s = a % 28
    m = a % 19
    if e == esm[0] - 1 and s == esm[1] - 1 and m == esm[2] - 1:
        return False
    else:
        return True


def solution():
    i = 0
    esm = list(map(int, input().split()))
    while check(i, esm):
        i += 1
    print(i + 1)


solution()
