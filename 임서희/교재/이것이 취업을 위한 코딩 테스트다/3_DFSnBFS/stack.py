# 스택 : First In Last Out
stack = []

stack.append(5)
stack.append(2)
stack.append(3)
stack.append(7)
stack.pop() # 7 pop (마지막에 들어온거 pop)
stack.append(1)
stack.append(4)
stack.pop() # 4 pop

print(stack) # [5,2,3,1]
print(stack[::-1]) # [1,3,2,5] 최상단 원소부터 출력