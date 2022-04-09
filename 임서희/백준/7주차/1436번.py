# 하나씩 일일이 값을 증가해서 666이란 숫자가 들어간 횟수만 세면 됨
n = int(input())
cnt = 0
six_n = 666
while True:
    if '666' in str(six_n): # 그냥 숫자를 1씩 증가해서 666이란 숫자가 나오면 cnt 증가
        cnt += 1
    if cnt == n: # 666이란 숫자가 들어갔던 횟수인 cnt가 n과 같으면 break
        print(six_n)
        break
    six_n += 1


# 내가 시도하려던 코드(실패)
# 666이란 문자를 고정시키고 i의 일의 자리가 6이면 k값을 증가시키려고 했음
# 근데 666 위치가 계속 바뀌었어야 해서 실패

# 나중에 다시 해보기

#N = int(input())
#result = '666'
#i = 0
#k = -1
#for _ in range(N):
#    if '6' in str(i%10):
#        k += 1
#        if k == 10:
#            i += 1
#            k = -1
#    else:
#        i += 1
#        
#if 0 <= k <= 9:
#    result = str(i) + '66'