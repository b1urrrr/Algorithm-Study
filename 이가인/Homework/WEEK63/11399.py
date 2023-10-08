n = int(input())
times = list(map(int, input().split()))
sum = 0

# times를 오름차순으로 정렬
times.sort()

for i in range(n):
    # i번째 사람의 대기시간을 sum에 더해줌
    sum += times[i] * (n - i)

print(sum)
