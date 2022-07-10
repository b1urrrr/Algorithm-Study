# 찾아라 프로그래밍 마에스터
# 레벨1: 폰켓몬
# 걸린 시간: 10분
def solution(nums):
    nums_set = set(nums)
    if len(nums_set) >= len(nums)//2:
        return len(nums)//2
    else:
        return len(nums_set)
    
# 다른 사람 코드
def solution(ls):
    return min(len(ls)/2, len(set(ls)))