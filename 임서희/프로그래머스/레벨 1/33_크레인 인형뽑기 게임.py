# 2019 카카오 개발자 겨울 인턴십
# 레벨1: 크레인 인형뽑기 게임
# 걸린 시간: 24분

def solution(board, moves):
    result = 0 # 인형 총 개수
    n = len(board) # 게인 화면 NXN일 때 N의 값
    stack = [] # 바구니 (나중에 들어온게 바로 앞에 들어왔던 거랑 비교해서 같으면 pop되어야 하므로)
    for m in moves: # moves 리스트에서 이동되는 것을 하나씩 꺼내옴
        for i in range(n):
            if board[i][m-1] != 0: # 이동은 좌우로 움직이므로 열의 위치가 바뀜.
                stack.append(board[i][m-1]) #  이때 배열은 인덱스가 0부터 시작하므로 m-1인데, 이 값이 0이 아니면 인형이 있는 것.
                board[i][m-1] = 0 # 그때의 값을 스택에 append 해주고 해당 값은 인형이 꺼내졌으므로 0으로 초기화
                break # 인형을 꺼냈으므로 break
        length = len(stack)
        if length > 1: # 스택의 길이가 1 초과이면 2개가 쌓였으므로 같은 인형인지 비교
            if stack[length-1] == stack[length-2]: # 스택 길이-1(지금 넣는 인형)와 스택 길이-2(직전에 넣은 인형)이 같으면
                stack.pop() # 두 개 모두 터뜨려지므로 스택에서 pop
                stack.pop()
                result += 2 # 인형 개수를 세는 것이므로 없어진 2개만큼 result에 추가
    return result
        