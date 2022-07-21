# 월간 코드 챌린지 시즌1
# 레벨1: 두 개 뽑아서 더하기
# 걸린 시간: 5분
def solution(numbers):
    answer = set()
    for i in range(len(numbers)-1):
        for j in range(i+1,len(numbers)):
            res = numbers[i]+numbers[j]
            answer.add(res)
    return sorted(list(answer))
# 테스트 4,5번 실패했었는데 오름차순 정렬을 안해서 틀렸던 것 주의