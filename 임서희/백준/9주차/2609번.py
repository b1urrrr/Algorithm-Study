a, b = map(int, input().split())
min_num = -1
if a >= b:
    min_num = b
else:
    min_num = a
    
min_list = []
for i in range(1,min_num+1):
    if min_num%i == 0:
        min_list.append(i)

min_list.pop(0)
min_res = 1
max_res = 1

for num in min_list[::-1]:
    if a%num == 0 and b%num == 0:
        min_res *= num
        a = a//num
        b = b//num
        
max_res = max_res*min_res*a*b

print(f'{min_res}\n{max_res}')