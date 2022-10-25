# 해시를 사용한 집합과 맵, 정렬
# 16449번: 동일한 단어 그룹화하기
t = int(input())
li = list()
for _ in range(t):
    li.append(''.join(sorted(input())))
ha = dict()
for i in li:
    if i not in ha:
        ha[i] = 0
    else:
        ha[i] += 1
print(len(ha))