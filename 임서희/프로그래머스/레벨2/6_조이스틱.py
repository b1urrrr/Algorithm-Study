# 탐욕법
# 레벨2: 조이스틱
# 22점: 다시 풀기

def solution(name):
    alpha = {'A':0,'B':1,'C':2,'D':3,'E':4,'F':5,'G':6,'H':7,'I':8,'J':9,'K':10,'L':11,'M':12,
             'N':13,'O':14,'P':15,'Q':16,'R':17,'S':18,'T':19,'U':20,'V':21,'W':22,'X':23,'Y':24,'Z':25}
    count = 0
    now = 'A'
    for i in name:
        print(min(abs(alpha[now]-alpha[i]),abs(alpha['Z']-alpha[i])+1,abs(alpha['A']-alpha[i])+1))
        print(i, min(abs(alpha[now]-alpha[i]),abs(alpha['Z']-alpha[i])+1,abs(alpha['A']-alpha[i])+1))
        count += min(abs(alpha[now]-alpha[i]),abs(alpha['Z']-alpha[i])+1,abs(alpha['A']-alpha[i])+1)
        now = i
    return count

def solution(name):

	# 조이스틱 조작 횟수 
    answer = 0
    
    # 기본 최소 좌우이동 횟수는 길이 - 1
    min_move = len(name) - 1
    
    for i, char in enumerate(name):
    	# 해당 알파벳 변경 최솟값 추가
        answer += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)
        
        # 해당 알파벳 다음부터 연속된 A 문자열 찾기
        next = i + 1
        while next < len(name) and name[next] == 'A':
            next += 1
            
        # 기존, 연속된 A의 왼쪽시작 방식, 연속된 A의 오른쪽시작 방식 비교 및 갱신
        min_move = min([min_move, 2 *i + len(name) - next, i + 2 * (len(name) -next)])
        
    # 알파벳 변경(상하이동) 횟수에 좌우이동 횟수 추가
    answer += min_move
    return answer