# 일부 숫자 버튼이 고장남
# 0~9, +, -가 존재. 채널은 무한대만큼 있다
# 채널 N으로 이동하기 위해 버튼을 최소 몇 번을 눌러야하는지 구하라
# 현재 채널은 100

# 입력
# 채널 N
# 고장난 버튼의 개수 M
# 고장난 버튼 M만큼의 개수

# 풀이
# 1. 현재 있는 위치의 숫자가 고장났는지 확인
# 2-1. 고장 나지 않았다면 번호 사용
# 2-2-1. 고장났다면, 가장 가까운 번호를 사용.
# 2-2-2. 자리수만큼 차이를 덧셈
# 3. 번호를 누른 것도 버튼을 누른 것이므로 덧셈
# !! 처음 시작이 100


def check_error(nums, a):
    if a in nums:
        return True
    else:
        return False


def find_min_diff(nums, a):
    min_val = 10
    for i in range(10):
        if i in nums:
            continue
        min_val = min(min_val, abs(a - i))
    return min_val


def solution():
    n = input()
    m = int(input())
    nums = list(map(int, input().split()))
    digit = 10 ** (len(n) - 1)
    cnt = 0
    for c in n:
        if (digit == 100 and c == '1') or\
                (digit == 10 and c == '0') or\
                (digit == 1 and c == '0'):
            digit //= 10
            continue
        elif check_error(nums, int(c)):
            val = find_min_diff(nums, int(c))
            cnt += val * digit
        cnt += 1
        digit //= 10
    return cnt


print(solution())
