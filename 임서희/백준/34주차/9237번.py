# 정렬
# 9237번: 이장님 초대
n = int(input())
li = list(map(int, input().split()))
li = sorted(li, reverse=True)
for i in range(len(li)):
    li[i] = li[i] + i + 1
print(max(li)+1)