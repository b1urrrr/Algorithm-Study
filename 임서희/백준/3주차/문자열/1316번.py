N = int(input())
cnt = N  # 결과는 N개

for i in range(N):
    word = input()
    for j in range(0, len(word)-1):
        if word[j] == word[j+1]:  # 현재 원소가 다음 원소와 같을 때(연속)
            pass
        elif word[j] in word[j+1:]:  # 현재 원소가 다음 원소 뒤에 또 존재할 때(불연속)
            cnt -= 1
            break

print(cnt)
