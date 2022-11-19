# 정렬
# 15819번: 너의 핸들은
n,m = map(int, input().split())
li = []
for _ in range(n):
    li.append(input())
li.sort()
print(li[m-1])