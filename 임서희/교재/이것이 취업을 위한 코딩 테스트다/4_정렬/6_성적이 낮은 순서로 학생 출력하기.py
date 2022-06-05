# 정렬
# 성적이 낮은 순서로 학생 출력하기

# 내 코드: 딕셔너리 이용
n = int(input())
student = {}

for _ in range(n):
    key, value = map(str, input().split())
    student[key] = int(value)

student = sorted(student.items(), key=lambda x:x[1])

for i in range(len(student)):
    print(student[i][0], end = ' ')

# 참고: 딕셔너리 정렬
# key 기준 정렬
student = sorted(student.items())
student = sorted(student.items(), reverse=True) # 내림차순

# value 기준 정렬
# 1. lambda 이용
student = sorted(student.items(), key = lambda x : x[1])
student = sorted(student.items(), key = lambda x: x[1], reverse=True)

# 2. operator.itemgetter 이용
import operator
student = sorted(student.items(), key = operator.itemgetter(1)) # 딕셔너리 인덱스 1인 value라고 명시
student = sorted(student.items(), key = operator.itemgetter(1), reverse=True)

# value 기준으로 정렬할 때 key 값만 얻는다면
student = sorted(student, key = student.get)


# 문제 답안
n = int(input())

array = []
for i in range(n):
    input_data = input().split()
    array.append((input_data[0], int(input_data[1])))

array = sorted(array, key = lambda student: student[1])

for student in array:
    print(student[0], end = ' ')