# col[열]=행

# check 함수로 퀸이 자리에 올 수 있는지 확인
# 1. 같은 행이면 X: col[i] == col[x]
# 2. 대각선이면 X: abs(col[i] - col[x]) == x - i
def check(x):
    for i in range(x): # 지금까지 놓인 퀸들의 위치와 모두 확인
        if col[i] == col[x] or abs(col[i]-col[x]) == x-i:
            return False
    return True

n = int(input())
res = 0 # 경우의 수
col = [0] * 15 # 최대 15X15인 체스판

def dfs(x):
    global res
    if x == n: # 탐색 완료
        res += 1
        return
    for i in range(n):
        col[x] = i # i번쨰 행, x번째 열
        # 4X4인 체스판일 때 (0,0)에서 첫 번쨰로 check 함수에서 허용
        # (0,1)로 넘어가서 2번째 퀸을 놓을 자리를 찾음
        # (0,1)은 check 함수에서 False라서 i값 증가 (1,1), (2,1)에서 check함수 True
        # 지금까지 첫 번째 퀸은 (0,0), 두 번째 퀸은 (2,1)
        # 현재 x값이 1인데, dfs(x+1)이므로 dfs(2) 함수가 실행됨
        # 세 번째 퀸 값을 찾지만 for문을 전부 돌아도 안돼서 함수를 종료하고 스택에서 꺼냄
        # 두 번째 퀸 놓았던 함수로 돌아와서 for문을 다시 돌고 i값이 증가 되어 (3,1)에 배치
        # 이후엔 똑같이 반복해서 실패
        # 두 번째 퀸 있는 함수도 종료해서 첫 번째 퀸 있는 함수로 돌아옴
        # 스택에 쌓인 첫 번째 함수에서 i 값 증가해서 (1,0)으로 다시 시작
        # 이후 반복하다가 x가 n이랑 값이 같아지는 순간 탐색 완료이므로 경우의 수인 res값 증가
        if check(x):
            dfs(x+1)

dfs(0)
print(res)
