# 수학, 브루트포스, 백트래킹, 조합론
# 1759번: 암호 만들기
# 다시 생각 중
a = ['a','e','i','o','u']
l, c = map(int, input().split())
li = list(map(str,input().split()))
li_a = []
li_b = []
for i in li:
    if i in a:
        li_a.append(i)
    else:
        li_b.append(i)
print(li_a)
print(li_b)
