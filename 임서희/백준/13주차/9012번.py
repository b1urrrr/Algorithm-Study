# 스택
# 9012번: 괄호
# 다른 사람 코드 참조

T = int(input())

for i in range(T):
    stack = []
    a=input()
    for j in a:
        if j == '(': # ( 이면 스택에 추가
            stack.append(j)
        elif j == ')': # )이면 스택에서 pop
            if stack:
                stack.pop()
            else: # 스택에 괄호가 없을경우 NO
                print("NO")
                break
    else: # break문으로 끊기지 않고 수행됬을경우 수행한다
        if not stack: # break문으로 안끊기고 스택이 비어있다면 괄호가 다 맞는거다.
            print("YES")
        else: # break안 걸렸더라도 스택에 괄호가 들어있다면 NO이다.
            print("NO")