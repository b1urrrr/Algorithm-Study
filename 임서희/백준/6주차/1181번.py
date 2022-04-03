# 틀린 코드
N = int(input())
a = []

for _ in range(N):
    s = input()
    a.append(s)
    
a.sort(key = lambda x: (len(x),x))

for i in range(len(a)):
    if a[i-1] == a[i]:
        continue
    print(a[i])


# 고친 코드
N = int(input())
a = []

for _ in range(N):
    s = input()
    a.append(s)

a = list(set(a))    # 중복을 없앨 때 set 사용하기
a.sort(key = lambda x: (len(x),x))

for i in range(len(a)):
    print(a[i])