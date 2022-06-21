# 연습 문제
# 자연수 뒤집어 배열로 만들기
# 내 코드
def solution(n):
    n = str(n)
    answer= []
    for i in range(1, len(n)+1):
        answer.append(int(n[-i]))
    return answer

# 처음에 reverse=True를 써서 sort 하였는데, 실패
# 생각해보니 단순히 뒤집는게 아니라 sort(reverse=True)의 경우 값을 내림차순으로 정렬하는 것
# 헷갈리지 말기!

# 다른 사람 코드 1
def digit_reverse(n):
    return list(map(int, reversed(str(n))))

# 다른 사람 코드 2
def digit_reverse(n):
    return [int(i) for i in str(n)][::-1]