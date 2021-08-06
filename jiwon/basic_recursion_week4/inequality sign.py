# 주어진 부등호를 만족하는
# 연속된 숫자 중 가장 큰 숫자와 가장 작은 숫자

# 풀이
# 1. 정답리스트를 만들어 정답리스트를 sort시킨 다음 맨 마지막과 처음을 출력
# 2. dfs에서 부등호 조건을 맞춰야한다.
# 3. 처음에는 아무 수나 와도 되고, 그 다음에는 이전과 비교해서 부등호 조건을
# 만족하는 경우를 진행, 방문했는 지의 여부도 생각해야한다.

n = int(input())
sign_list = list(input().split())
answer_list = []
v = [False] * 10


def dfs(d, nums):
    if d == n + 1:
        answer_list.append(nums)
        return
    for i in range(10):
        c = str(i)
        if d == 0:
            v[i] = True
            dfs(d + 1, nums + c)
            v[i] = False
        elif sign_list[d - 1] == ">":
            if not v[i] and nums[d - 1] > c:
                v[i] = True
                dfs(d + 1, nums + c)
                v[i] = False
        elif sign_list[d - 1] == "<":
            if not v[i] and nums[d - 1] < c:
                v[i] = True
                dfs(d + 1, nums + c)
                v[i] = False


dfs(0, "")
answer_list.sort()
print(answer_list[-1] + "\n" + answer_list[0])
