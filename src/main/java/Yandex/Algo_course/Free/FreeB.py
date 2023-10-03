# Cards counter

ans = 0
leftSum = 0

size = int(input())
touches = int(input())
arr = list(map(int, input().strip().split()))
for i in range(0, touches):
    leftSum += arr[i]
ans = leftSum
for k in range(1, touches+1):
    leftSum = leftSum + arr[-k] - arr[touches - k]
    ans = max(ans, leftSum)
print(ans)
