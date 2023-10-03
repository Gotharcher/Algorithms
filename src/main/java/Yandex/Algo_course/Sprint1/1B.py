inp = list(map(int, input().strip().split()))
oddEven = inp[0]%2
res = "WIN"
for n in range(1, len(inp)):
    if inp[n]%2 != oddEven:
        res = "FAIL"
        break

print(res)