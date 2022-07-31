# 수학
# 1402번: 아무래도 이 문제는 A번 난이도인 것 같다
# 다시 풀기

T = int(input())

# 약수 구하기(시간 복잡도 줄여서)
def getMyDivisor(n):
    divisorsList = []

    for i in range(1, int(n**(1/2)) + 1):
        if (n % i == 0):
            divisorsList.append(i) 
            if ( (i**2) != n) : 
                divisorsList.append(n // i)

    divisorsList.sort()
    return divisorsList

for _ in range(T):
    a,b = map(int, input().split())
