# 그리디 알고리즘
# 마이너스 기호를 만나면 다음 마이너스까지, 마이너스가 없다면 끝까지 모든 수를 더해서 한 번에 빼주기
# → 접근 방식은 맞게 갔는데 구현을 못해서 틀렸음
# 꼭 다시 풀어보기
arr = input().split('-')
s = 0
for i in arr[0].split('+'): 
    s += int(i)
for i in arr[1:]:
    for j in i.split('+'): 
        s -= int(j)
print(s)
