# 최대 공약수와 최소공배수
# 유클리드 호제법

aa, bb = map(int, input().split())
a, b = aa, bb
while b > 0:
    temp = a
    a = b
    b = temp % a
print(a, (aa * bb) // a)
