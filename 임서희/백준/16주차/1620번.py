# 집합과 맵
# 1620번: 나는야 포켓몬 마스터 이다솜

# 틀린 내 코드
# 딕셔너리를 2개 이용하려 했는데 isalpa()일 때 적용이 안됨
n, m = map(int, input().split())
l = dict()
for i in range(n):
    value = input()
    l[i] = value
lalpa = {v: k for k,v in l.items()}

for i in range(m):
    find = input()
    if find.isalnum():
        print(l.get(find))
    else:
        print(lalpa.get(find))

# 다른 맞는 코드
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
l = dict()

for i in range(1, n+1):
    a = input().rstrip() # rstrip은 필수
    l[i] = a # 딕셔너리 한개로 value,key와 key,value를 두번 저장
    l[a] = i

for i in range(m):
    find = input().rstrip()
    if find.isdigit():
        print(l[int(find)])
    else:
        print(l[find])