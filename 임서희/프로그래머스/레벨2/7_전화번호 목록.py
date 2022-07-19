# 해시
# 레벨2: 전화번호 목록
# 정확성 70.8/효율성 8.3 -> 합계 79.2/100.0
# 정확성 8,9,19 / 효율성 3,4(시간초과) 실패
def solution(phone_book):
    for i in range(len(phone_book)-1):
        for j in range(i+1, len(phone_book)):
            if phone_book[j].startswith(phone_book[i]):
                return False
    else:
        return True
    
# 다른 풀이
def solution(phoneBook):
    phoneBook = sorted(phoneBook)

    for p1, p2 in zip(phoneBook, phoneBook[1:]):
        if p2.startswith(p1):
            return False
    return True