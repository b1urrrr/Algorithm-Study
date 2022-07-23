# 그리디 알고리즘
# 1049번: 기타줄
n, m = map(int, input().split()) # n은 끊어진 기타줄 개수, m은 브랜드 개수
package_list = []
indi_list = []
for _ in range(m): # 브랜드 개수만큼 가격 비교
    package, indi = map(int, input().split()) # 6개 패키지 가격, 낱개 가격
    package_list.append(package)
    indi_list.append(indi)

pack_min = min(package_list)
indi_min = min(indi_list)

result = indi_min * n
if n%6 != 0:
    result = min(result, (n//6 + 1)*pack_min,(n//6)*pack_min+(n%6)*indi_min)
else:
    result = min(result,(n//6)*pack_min,(n//6)*pack_min+(n%6)*indi_min)

print(result)