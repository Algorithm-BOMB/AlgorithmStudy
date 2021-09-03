def is_right(s):
    a = []
    for c in s:
        if a and c == ")":
            a.pop()
        elif c == "(":
            a.append(c)
        else:
            return False
    if a:
        return False
    return True


def get_balanced(p):
    if not p:
        return
    e = 0
    u = ""
    while True:
        u = p[0:e]
        v = p[e:]
        if u.count('(') != u.count(')'):
            break
        e += 2
    return u, v


def reverse_braket(p):



def solution(p):
    answer = ''
    if not p or is_right(p):
        return p
    else:
        u, v = get_balanced(p)
        if is_right(u):
            answer = u * solution(v)
        else:
            answer = "(" + solution(v) + ")" + u[1:-1]
    return answer