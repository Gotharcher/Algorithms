import math

a = int(input())
ans = []

def find_divider(val):
    for n in range(2, math.isqrt(a)+1):
        if val%n == 0:
            return n, val//n
    return val, 1

while(a>1):
    n, a = find_divider(a)
    if(n>1):
        ans.append(n)

print(*ans)