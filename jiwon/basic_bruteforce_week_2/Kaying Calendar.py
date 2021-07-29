# <M:N>은 그들의 달력의 마지막 해
# M = 10, N = 12면 11번째 해는 <1:11>

# 풀이
# 기존에 사용했던 달력의 문제보다 시간 복잡도가 낮아야한다. 1초 안에 풀 수 있어야 함
# 하나의 수를 먼저 찾는다.
# 언제 종료? 같은 수가 계속 나오면 종료 ? 종료
# 17 -> 7, 5
# 27 -> 7, 3
# 37 -> 7, 1
# 47 -> 7, 11
# 57 -> 7, 9
# 67 -> 7, 7
# 77 -> 7, 5
# 87 -> 7, 3
# 97 -> 7, 1
# 107 -> 7, 11

import sys


def solution():
    for _ in range(int(input())):
        m, n, x, y = map(int, sys.stdin.readline().split())
        x -= 1
        y -= 1
        num = x
        nm = n * m
        while num < nm:
            mod_num = num % n
            if mod_num == y:
                break
            num += m
        if num % n != y:
            num = -2
        sys.stdout.write(str(num + 1) + "\n")


solution()
