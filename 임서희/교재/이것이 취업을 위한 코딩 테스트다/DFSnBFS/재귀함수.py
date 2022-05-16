# 재귀 함수: recursive Function
# 자기 자신을 다시 호출하는 함수

def recursive_function(i):
    if i == 100:
        return
    print(i, '번째 함수에서', i+1, '번째 재귀 함수를 호출합니다')
    recursive_function(i + 1)

recursive_function(1)

# 종료 조건이 없을 경우, RecursionError 발생
# 무한히 자기 자신을 계속해서 불러오다가 '재귀의 최대 깊이를 초과'하면서 오류 메시지 출력