# 정렬, 우선순위큐, 그리디 알고리즘
# 다시 생각해보기
# 내코드
t = int(input())
li = []
for _ in range(t):
    li.append(list(map(int, input().split())))
li = sorted(li, key=lambda x:x[1], reverse=True)
print(li)
sum = 0
k = 1 
j = 0
for i in range(len(li)):
    i = i + j
    if k <= li[i][0]:
        if i < len(li):
            if k == li[i+1][0]:
                sum += li[i+1][1]
                li[i+1][0], li[i+1][1] = 0,0
                j = -1
            else:
                sum += li[i][1]
                li[i][0], li[i][1] = 0,0
                j = 0
            print(sum)
        else:
            if k <= li[i][0]:
                sum += li[i][1]
                li[i][0], li[i][1] = 0,0
                j = 0
            print(sum)
        k += 1
    print(k, li)
print(sum)
# 우선순위큐를 이용하는 방법을 생각해보기
# 3번째 원소까지는 잘 더하는데 그 이후를 우선순위큐를 사용 안하다보니, 거기서 끝이남
# k가 날짜비교였는데, i+1 원소랑 비교할때 다시 한칸 앞으로 돌아가다보니 날짜 횟수가 아니라
# 반복문 횟수가 되어버려서 6일째가 더해지지 않음.