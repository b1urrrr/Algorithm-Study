# 정렬, 그리디 알고리즘
# 내코드: 틀림
n = int(input())
li = sorted(list(map(int, input().split())), reverse= True)
day = li[0]-1
res = li[0] + 1

for i in range(1, len(li)):
    if day <= li[i]:
        res += abs(day-li[i])
    day -= 1
print(res)

# 예시 코드
n = int(input())
li = sorted(list(map(int, input().split())), reverse=True)

for i in range(len(li)):
    li[i] = li[i] + i # 1일씩 증가하면서 심는 일수+묘목이 자라날 일수

print(max(li)+1) # 최댓값 찾아서 이장님은 다음날 오므로 +2 한 결과 출력