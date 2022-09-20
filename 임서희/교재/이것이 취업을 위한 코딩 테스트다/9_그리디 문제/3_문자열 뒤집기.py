# 내 코드
n = input()
list_0 = []
list_1 = []
s = ''

for i in range(len(n)-1):
	s += i
	if n[i] != n[i+1]:
		if s[0] == '0':
			list_0.append(s)
		else:
			list_1.append(s)
		s = ''

len_0 = len(list_0)
len_1 = len(list_1)

print(min(len_0,len_1))