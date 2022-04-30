# 시간 초과
N = int(input())
num = []

for _ in range(N):
    a = int(input())
    num.append(a)

num_list = [0] * 100
res = []
for i in range(2,num[N-1]+1):
    k = 0
    bo = True
    for n in num:
        num_list[k] = n%i
        k+=1
    for j in range(1, N):
        if num_list[j] != num_list[j-1]:
            bo = False
            break
    if bo:
        res.append(i)

for i in res:
    print(i, end=' ')

# 다른 사람 코드
N = int(input())
num = sorted([int(input()) for _ in range(N)])
re_num = []

# B-A, C-B, D-C... 쭉 구해서 새 리스트에 추가
for i in range(1, N):
    re_num.append(num[i] - num[i-1])

# 두 수의 최대공약수를 구해주는 함수(유클리드 호제법)
def findGCD(a, b):
    num = b
    div = a
    rest = num % div
    while rest != 0:
        num = div
        div = rest
        rest = num % div
    return div

# re_num의 모든 수들의 최대공약수를 구하고 그 것의 1을 제외한 모든 약수가 구하는 M이다.
GCD = re_num[0]
for idx in range(1, len(re_num)):
    GCD = findGCD(GCD, re_num[idx])

# 왜 수의 제곱근까지만 약수를 구해주고, 각 단계에서 약수를 두개 저장하는 건 또 뭔가 싶을 것이다.
# 예를 들어 36의 약수는 1을 제외하고 1, 2, 3, 4, 6, 9, 12, 18, 36인데, 2 * 18 = 36, 3 * 12, ..., 6 * 6 = 36
# 이와 같이, 제곱근의 경우 그 자신을 제곱하면 원래 수가 되고, 그 이전의 모든 수는 제곱 수보다 큰 어떤 약수와 매칭돼서
# 원래 수를 이루게 된다. 그래서, 제곱근 이전의 모든 약수의 개수 * 2와, 제곱근 약수 하나를 더한 것이 전체 약수의 개수가 된다.

# 그런데 지금 경우는 1은 제외하므로, 2부터 제곱근까지 for를 돌고, 제곱근일 때는 제곱근이 두 개 저장되므로 중복을 피하기
# 위해 set에 저장한다. 그리고 1일 때를 제외했으므로, 마지막 자기 자신인 GCD가 포함되지 않았으므로 따로 추가해준다.
result = set()
for i in range(2, int(GCD**0.5) + 1):
    if GCD % i == 0:
        result.add(i)
        result.add(GCD // i)
result.add(GCD)
print(*sorted(list(result)))


# 다시 풀기