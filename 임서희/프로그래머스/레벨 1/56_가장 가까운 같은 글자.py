# 연습 문제
# 레벨1: 가장 가까운 같은 글자
def solution(s):
    dic = dict()
    res = []
    for i in range(len(s)):
        if s[i] not in dic:
            dic[s[i]] = i
            res.append(-1)
        else:
            res.append(i-dic[s[i]])
            dic[s[i]] = i
    return res