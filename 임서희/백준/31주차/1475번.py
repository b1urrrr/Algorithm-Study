# 구현
# 1475번: 방 번호
# 내 코드: 틀림 (맞는거 같은데 왜 틀렸을까... 생각해보기.)
n = str(input())
li = [0] * 10

for i in n:
    li[int(i)] += 1

max_in = -1
res = -1
for i in range(10):
    if li[i] > max_in:
        res = li[i]
        max_in = i

if max_in == 6 or max_in == 9:
    if res % 2 == 0:
        print(res//2)
    else:
        print(res//2 + 1)
else:
    print(res)

# 같은 방식으로 접근한 다른 사람 코드
word = input()
ans = [0] * 10
for i in range(len(word)):
    num = int(word[i])
    if num == 6 or num == 9:
        if ans[6] <= ans[9]:
            ans[6] += 1
        else:
            ans[9] += 1
    else:
        ans[num] += 1
 
print(max(ans))