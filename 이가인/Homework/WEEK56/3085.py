n = int(input())

arr = []
for _ in range(n):
    colors = list(map(str, input()))
    arr.append(colors)

maxCount = 0

def width():
    for k in range(n):
        global maxCount

        countRow = 1
        for l in range(n - 1):
            if arr[l][k] == arr[k][l+1]:
                countRow += 1
                maxCount = max(maxCount, countRow)
            else:
                countRow

def height():
    for k in range(n):
        global maxCount
        
        countColumn = 1 #초기 개수를 1로 초기화
        for l in range(n - 1):
            if arr[l][k] == arr[l + 1][k]: #만약 같은 행의 사탕의 색이 같다면
                countColumn += 1 #사탕 개수를 1개씩 증가
                maxCount = max(maxCount,countColumn) #증가시킨 값과 최대 사탕개수를 비교하여 큰값을 대입
            else: #만약 같은 행의 색이 다르다면
                countColumn = 1 #개수를 1로 초기화


for i in range(n):
    for j in range(n - 1):
        # 만약 입력 받은 배열의 행의 원소가 다르다면
        if arr[i][j] != arr[i][j + 1]:
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
            width()
            height()
            arr[i][j + 1], arr[i][j] = arr[i][j], arr[i][j + 1]
        # 만약 입력 받은 배열의 열의 원소가 다르다면
        if arr[j][i] != arr[j + 1][i]:
            arr[j][i], arr[j + 1][i] = arr[j + 1][i], arr[j][i]
            width()
            height()
            arr[j + 1][i], arr[j][i] = arr[j][i], arr[j + 1][i]

print(maxCount) #색이 같은 사탕개수 최대값을 출력
            