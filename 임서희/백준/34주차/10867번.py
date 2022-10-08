# 정렬
# 10867번: 중복 빼고 정렬하기
n = int(input())
li = set(map(int, input().split()))
li = sorted(list(li))
for i in li:
    print(i, end ='')