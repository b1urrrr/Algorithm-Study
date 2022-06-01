# 레벨 1: 모의고사
# 걸린 시간: 26분
def solution(answers):
    answer = []
    length = len(answers)
    
    s_num, s2_num, s3_num = 0, 0, 0
    
    su1 = [1,2,3,4,5]
    su2 = [2,1,2,3,2,4,2,5]
    su3 = [3,3,1,1,2,2,4,4,5,5]
    
    
    for i in range(length):
        if answers[i] == su1[i%5]:
            s_num += 1
        if answers[i] == su2[i%8]:
            s2_num += 1
        if answers[i] == su3[i%10]:
            s3_num += 1
    
    a = [s_num, s2_num, s3_num]
    # global max_result
    max_result = max(a)
    res_list = list(filter(lambda x: a[x] == max_result, range(len(a))))
    for i in range(len(res_list)):
        answer.append(res_list[i]+1)
    return answer

# 참고
# 파이썬 리스트 인덱스 여러 개 찾기

# 1. filter 이용하기
# map, filter, reduce는 한 세트로 알기 (reduce는 코드가 복잡하면 한눈에 알아보기가 어려워서 파이썬3부터 내장함수로 제외됨)
# filter(조건 함수, 순회 가능한 데이터)
# lambda 매개변수들: 식
# filter를 사용하고 list를 감싸줘야 우리가 원하는 형태를 얻을 수 있으며, lambda와 같이 사용하면 더욱 유용하다
test_list = [1,3,4,3,6,7]
print('원래 리스트: ' + str(test_list)) # 원래 리스트: [1,3,4,3,6,7]
res_list = list(filter(lambda x: test_list[x] == 3, range(len(test_list))))
print('3과 같은 인덱스만 가져온 리스트: ' + str(res_list)) # 3과 같은 인덱스만 가져온 리스트: [1, 3]

a = [8, 3, 2, 10, 15, 7, 1, 9, 0, 11]
list(filter(lambda x: x > 5 and x < 10, a))

# 2. enumerate
# value와 index를 같이 반환하는 내장 함수
test_list = [1,3,4,3,6,7]
res_list = [i for i, value in enumerate(test_list) if value == 3]