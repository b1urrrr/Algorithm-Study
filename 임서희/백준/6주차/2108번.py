from collections import Counter
N = int(input())
a = []
for i in range(N):
    s = int(input())
    a.append(s)
a.sort()

print(round(sum(a)/N))
print(a[N//2])
cnt = Counter(a).most_common(2) # 빈도수가 높은 숫자 2개 가져오기
if len(a)>1:
    if cnt[0][1] == cnt[1][1]: # 2개의 빈도수가 같으면
        print(cnt[1][0]) # 2번째로 작은 값 출력
    else:
        print(cnt[0][0])
else:
    print(cnt[0][0])
    
print(max(a)-min(a))