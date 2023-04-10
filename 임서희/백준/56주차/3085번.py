# 브루트포스 알고리즘
# 3085번: 사탕 게임

# 다시 풀어보기
def check(arr):
    n = len(arr)
    answer = 1
    for i in range(n):
        cnt = 1
        for j in range(1, n):
            if arr[i][j] == arr[i][j - 1]:
                cnt += 1
            else:
                cnt = 1
            if cnt > answer:
                answer = cnt

        cnt = 1
        for j in range(1, n):
            if arr[j][i] == arr[j - 1][i]:
                cnt += 1
            else:
                cnt = 1
            if cnt > answer:
                answer = cnt

    return answer


n = int(input())
arr = [list(input()) for _ in range(n)]
answer = 0

for i in range(n):
    for j in range(n):
        if j + 1 < n:
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
            temp = check(arr)
            if temp > answer:
                answer = temp
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]

        if i + 1 < n:
            arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]
            temp = check(arr)
            if temp > answer:
                answer = temp
            arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]
print(answer)