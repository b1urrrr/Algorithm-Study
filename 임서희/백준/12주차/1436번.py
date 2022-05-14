# 브루트포스(Brute Force)
# 완전탐색 알고리즘. 즉, 가능한 모든 경우의 수를 모두 탐색하면서 요구조건에 충족되는 결과만을 가져온다.
# 영화감독 숌

# 1부터 1씩 증가해서 666이란 숫자가 나오면 cnt 증가
# 1부터 끝까지 일일이 확인해서 찾기

n = int(input())
cnt = 0
six = 666

while True:
    if '666' in str(six):
        cnt += 1
    if cnt == n: 
        print(six) # 같으면 break
        break
    six += 1