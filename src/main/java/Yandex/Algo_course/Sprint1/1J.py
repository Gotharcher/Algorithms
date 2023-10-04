a = int(input())
ans = []

def find_divider(val):
    n = 2
    while n * n <= a:
        if val%n == 0:
            return n, val//n
        n = n+1
    return val, 1

while(a>1):
    k, a = find_divider(a)
    if(k>1):
        ans.append(k)

print(*ans)