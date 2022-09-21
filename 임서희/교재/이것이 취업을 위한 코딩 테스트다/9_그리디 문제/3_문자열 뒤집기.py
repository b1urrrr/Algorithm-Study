# 내 코드
n = input()
list_0 = []
list_1 = []
s = ''

for i in range(len(n)-1):
	s += n[i]
	if n[i] != n[i+1]:
		if s[0] == '0':
			list_0.append(s)
		else:
			list_1.append(s)
		s = ''

len_0 = len(list_0)
len_1 = len(list_1)

print(min(len_0,len_1))

# 답안 예시
data = input()
count0 = 0
count1 = 0

if data[0] == '1':
    count0 += 1
else:
    count1 += 1

for i in range(len(data) - 1):
    if data[i]!=data[i+1]:
        if data[i+1] == '1':
            count0 += 1
        else:
            count1 += 1
print(min(count0, count1))