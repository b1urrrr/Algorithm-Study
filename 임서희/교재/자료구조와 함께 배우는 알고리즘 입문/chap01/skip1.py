# 1~12까지 8을 건너뛰고 출력하기 1

# 건너뛰는 판단하는 비용이 많이 들기 때문에 비효율
for i in range(1,13):
    if i == 8:
        continue
    print(i, end=' ')
    
print()