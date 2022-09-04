ans = ""
def NGE(arr, i):
    stack = arr[i-1:]
    if arr[i-1]>= stack.max():
        ans[i-1] = -1
    elif arr[i-1] < arr[i]:
        

N = int(input())
arr = map(int, input().split())
NGE(arr, N)

