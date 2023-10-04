n = int(input())
m = int(input())
matrix = []
for i in range(n):
    matrix.append(list(map(int, input().strip().split())))
row = int(input())
col = int(input())

ans = []

if row>0:
    ans.append(matrix[row-1][col])
if col>0:
    ans.append(matrix[row][col-1])
if row<n-1:
    ans.append(matrix[row+1][col])
if col<m-1:
    ans.append(matrix[row][col+1])
ans.sort()
print(*ans)