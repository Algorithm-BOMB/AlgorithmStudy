# 홀수의 합은 짝수로 나타낼 수 있다. 또한, 소수이다. 모든 짝수에 대해서 골드바흐 추축을 검증하라
# n = a + b 형태로 출력 // a, b는 홀수이고 소수

# 풀이
# 1. n 보다 작은 수 중 소수이면서 홀수를 찾는다.
# 2. 소수이면서 홀수인 수 중 정렬을 시켜서 가장 작은 수랑 큰 수를 더한다.
# 2.1 n보다 큰 경우
# 가장 큰 수보다 인덱스가 하나 적은 것을 더해본다
# 2.2 n보다 작으면서 값이 맞지 않은 경우
# 작은 수 더한 인덱스를 +1해서 더해본다
# 방법이 여러 가지라면 b - a가 제일 큰 것을 출력한다.
# !! 나타낼 수 없는 경우는 Goldbach's conjecture is wrong. 을 출력

import sys


def get_input_data():
    input_list = []
    while True:
        n = int(sys.stdin.readline())
        if n == 0:
            break
        input_list.append(n)
    return input_list


def get_odd_plist(input_list):
    limit = max(input_list)
    p = [False] * limit
    odd_plist = []
    for i in range(2, limit):
        if p[i]:
            continue
        if i % 2 == 1:
            odd_plist.append(i)
        for j in range(i + i, limit, i):
            p[j] = True
    return odd_plist


def goldbach_conjecture(p_list, n):
    i = 0
    j = len(p_list) - 1
    while True:
        a = p_list[i] + p_list[j]
        if i > j:
            sys.stdout.write("Goldbach's conjecture is wrong.\n")
            return
        # 2.1 n보다 큰 경우
        if a > n:
            j -= 1
        elif a == n:
            sys.stdout.write(str(n) + " = " + str(p_list[i]) + " + " + str(p_list[j]) + "\n")
            break
        # 2.2 n보다 작은 경우
        else:
            i += 1


def solution():
    input_list = get_input_data()
    odd_plist = get_odd_plist(input_list)
    for n in input_list:
        p_list = []
        for i in odd_plist:
            if i > n:
                break
            p_list.append(i)
        goldbach_conjecture(p_list, n)


solution()
