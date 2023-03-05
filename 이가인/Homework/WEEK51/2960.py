k, n= map(int, input().split())

cnt = 0

nums = [True] * (n+1)
for i in range(2, n+1):
    if nums[i] == True:
        for j in range(i, n+1, i):
            if nums[j] == True:
                nums[j] = False
                cnt = cnt + 1
                if cnt == k:
                    print(j)
# ..? 뭐가 문제지
N, K = map(int, input().split())

cnt = 0

nums = [True] * (N + 1)
for i in range(2, len(nums) + 1):
    for j in range(i, N+1, i):
        if nums[j] == True:
            nums[j] = False
            cnt = cnt + 1
            if cnt == K:
                print(j)
                break