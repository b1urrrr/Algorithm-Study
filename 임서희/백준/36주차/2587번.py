# 정렬
# 2587번: 대표값2
li = []
for _ in range(5):
    li.append(int(input()))
li.sort()
print(sum(li)//5)
print(li[2])