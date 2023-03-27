# 백준 25206
rating = ['A+', 'A0', 'B+', 'B0', 'C+', 'C0', 'D+', 'D0', 'F']
grade = [4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0]

total = 0
res = 0

for i in range(20):
    class_name, time, score = input().split()
    time = float(time)
    if score != 'P':
        total += time
        res += time * grade[rating.index(score)] 

print('%.6f' %(res/total))

