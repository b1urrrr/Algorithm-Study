# 11478번: 서로 다른 부분 문자열의 개수

s = input()
result = []

res = ''
for i in range(1, len(s)+1): # 5번 횟수
    n = 0
    for j in range(i, len(s)+1): # 1~5까지 j
        res = s[n:j] # j가 1~5인 이유는 [n:j]일 경우 n~j-1까지 범위의 문자를 출력하기 때문
        result.append(res)
        n+=1

result.append(s)
result = list(set(result))
print(len(result))             