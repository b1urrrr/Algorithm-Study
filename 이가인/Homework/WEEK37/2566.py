res = 0
res_row = 0
res_column = 0

for i in range(9):
    row = list(map(int, input().split()))
    if max(row) > res:
        res = max(row)
        res_row = i + 1
        res_column = row.index(max(row)) + 1
if res == 0:
    res_row = 1
    res_column = 1
print(res)
print(res_row, res_column)
