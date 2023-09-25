# 정렬
# 레벨 2: H-index
# 12점

def solution(citations):
    citations = sorted(citations, reverse=True)
    h_index = []
    for i in range(len(citations)):
        if i+1 >= citations[i] and len(citations)-(i+1) <= citations[i]:
            h_index.append(citations[i])
    return max(h_index)
# 다시 풀기

# 다른 사람 코드
def solution(citations):
    citations.sort(reverse=True)
    for idx , citation in enumerate(citations):
        if idx >= citation:
            return idx
    return len(citations)