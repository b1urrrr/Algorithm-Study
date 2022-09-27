n = input()
l = len(n)

left = 0
right = 0
for i in range(0, len(n)//2):
	left += int(n[i])
for i in range(len(n)//2, len(n)):
	right += int(n[i])

if left == right:
	print('LUCKY')
else:
	print('READY')
