# 그리디 알고리즘, 정렬
# 13164번: 행복 유치원
# 차가 큰 애들은 아예 혼자 있게 해서 없애기. 즉 k-1의 합만 구하기

# 틀렸다고 나와서 다시 생각해보기
# 참고: https://yuna0125.tistory.com/46
n, k = map(int, input().split())
li = sorted(list(map(int, input().split())))

li_cha = []
#print(li)
for i in range(1, n-1):
    li_cha.append(abs(li[i]-li[i+1]))

li_cha.sort()
#print(li_cha)
print(sum(li_cha[:k-1]))

# 수정한 코드
n, k = map(int, input().split())
li = list(map(int, input().split()))

array = []
for i in range(1, n):
    array.append(li[i] - li[i-1])

array.sort(reverse=True)
print(sum(array[k-1:]))