# 2, 5로 나누어 떨어지지 않은 정수 n이 주어졌을 때, 1로만 이루어진 n의 배수
while True:
    try:
        n = int(input())
    except:
        break
    s = "1"
    while int(s) % n != 0:
        s += "1"
    print(len(s))
