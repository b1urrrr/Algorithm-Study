# 정렬
# 좌표 압축

# 내 코드: 답은 나오는데 시간 초과
N = int(input())
l = list(map(int, input().split()))
r = sorted(list(set(l)))
sum = [0] * N

for i in range(N):
    sum[i] = r.index(l[i])  # index 함수가 최대 O(n) 시간 복잡도가 나와서 시간 초과 발생

print(sum)

# 다른 사람 코드
# 딕셔너리를 활용하여 {dic[요소]:요소의 index}의 형태로 저장하여 
# dict[i]를 O(1)의 시간 복잡도로 가져올 수 있음
import sys

input = sys.stdin.readline

n = int(input())
l = list(map(int, input().split()))
r = sorted(list(set(l)))

# set으로 중복을 제거하고 정렬된 리스트 r의 원소를 하나씩 꺼내서 딕셔너리에 넣는다
# {r 원소값: 인덱스 번호} 형태
dic = {r[i]: i for i in range(len(r))}
for i in l: # 원래 리스트의 값 순서대로 딕셔너리에서 찾아서 index 번호 찍기
    print(dic[i], end = ' ')