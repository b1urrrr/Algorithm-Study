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
