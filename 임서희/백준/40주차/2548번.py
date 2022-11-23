# 2548번
# 지난주차에 푼 내 코드를 수정해도 자꾸 시간 초과나서 다른 사람 코드 참고
# 중앙값 이용하기
N = int(input())
arr = sorted(list(map(int, input().split())))
q, r = divmod(N, 2)
print(arr[q+r-1])