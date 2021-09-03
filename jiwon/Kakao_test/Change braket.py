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
        e += 2
        u = p[:e]
        v = p[e:]
        if e >= len(p) or u.count('(') == u.count(')'):
            break
    return u, v


def reverse_braket(p):
    new_p = ""
    for c in p:
        new_p += "(" if c == ")" else ")"
    return new_p


def solution(p):
    if not p or is_right(p):
        return p
    else:
        u, v = get_balanced(p)
        if is_right(u):
            answer = u + solution(v)
        else:
            u = reverse_braket(u[1:-1])
            answer = "(" + solution(v) + ")" + u
    return answer
