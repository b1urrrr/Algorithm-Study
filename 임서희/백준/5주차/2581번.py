# 내 코드: 성공(시간 732ms)
M = int(input())
N = int(input())
min = N+1
sum = 0

for num in range(M,N+1):
    if num > 1:
        for i in range(2,num):
            if num % i == 0:
                break
        else:
            if min > num:
                min = num
            sum += num
if min == N+1:
    print(-1)
else:
    print(f'{sum}\n{min}')


# 다른 사람 코드: 시간 168ms
start_num = int(input())
last_num = int(input())

sosu_list = []
for num in range(start_num, last_num+1):
    error = 0
    if num > 1 :
        for i in range(2, num):  # 2부터 num-1까지
            if num % i == 0:
                error += 1
                break  # 2부터 num-1까지 나눈 몫이 0이면 error가 증가하고 for문을 끝냄
        if error == 0:
            sosu_list.append(num)  # error가 없으면 소수리스트에 추가
            
if len(sosu_list) > 0 :
    print(sum(sosu_list))
    print(min(sosu_list))
else:
    print(-1)