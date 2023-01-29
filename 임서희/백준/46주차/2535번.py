# 정렬
# 2535번: 아시아 정보올림피아드
n = int(input())
arr = []
cnt = 0
for _ in range(n):
    arr.append(list(map(int, input().split())))
 
arr = sorted(arr, key = lambda x : -x[2])
print(arr[0][0], arr[0][1])
print(arr[1][0], arr[1][1])
if arr[0][0] == arr[1][0]: cnt = 1
 
for i in range(2, n):
    if cnt == 0: 
        print(arr[i][0], arr[i][1])
        break
    else:
        if arr[1][0] != arr[i][0]:
            print(arr[i][0], arr[i][1])
            break