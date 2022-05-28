# 내 코드
N = int(input())
m = 0
s=0
h=0
cnt = 0
while h <= N:
    if s > 59:
        m += 1
        s=0
    if m > 59:
        h+=1
        m = 0
    if '3' in str(s) or '3' in str(m) or '3' in str(h):
        cnt += 1
    s += 1

print(cnt)

# 답안 예시
h = int(input())
count = 0

for i in range(h+1): 
    for j in range(60):
        for k in range(60):
            if '3' in str(i) + str(j) + str(k):
                count += 1
print(count)