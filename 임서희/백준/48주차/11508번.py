# 그리디 알고리즘
# 11508번: 2+1 세일
# 지난 주차 틀린 문제 다시 풀이
# 내림차순으로 정렬한 후, 3, 6, 9, ...번째마다 전체 합에서 빼주면 되는 풀이였음
# 무료로 지불할 가장 싼 가격이 최대한 비싼 가격일 수 있도록 해야 하기 때문에
# 내림차순으로 정렬을 하고나서 2+1 중 무료인 1에 해당하는 3의 배수를 빼주는 것

n = int(input())
l = []
for i in range(n):
    l.append(int(input()))
l.sort(reverse=True)

result = 0
for i in range(2, len(l), 3): # 인덱스가 2인 3번째 값부터 3의 배수로 result에 더해준뒤
    result += l[i]

print(sum(l)- result) # 전체 합에서 result를 빼주면 됨