def getMyDivisor(n):
    divisorsList = []
    for i in range(3, int(n**(1/2)) + 1):
        if (n % i == 0):
            divisorsList.append(i) 
            if ( (i**2) != n) : 
                divisorsList.append(n // i)
                
    divisorsList.sort(reverse=True)
    
    return divisorsList

def solution(brown, yellow):
    answer = getMyDivisor(brown+yellow)
    width, height = 0, 0
    if len(answer)%2 == 0:
        length = len(answer)//2
    else:
        length = len(answer)//2+1

    for i in range(0, length):
        if brown == (answer[i]*2 + answer[len(answer)-1-i]*2-4):
            width, height = answer[i], answer[len(answer)-1-i]
            break

    return [width, height]