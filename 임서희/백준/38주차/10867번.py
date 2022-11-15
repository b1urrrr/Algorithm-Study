# 정렬
# 10867번: 중복 빼고 정렬하기
n = int(input())
li = sorted(list(set(map(int,input().split()))))
for i in li:
    print(i, end=' ')
