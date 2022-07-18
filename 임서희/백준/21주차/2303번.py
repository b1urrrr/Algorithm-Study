# 브루트포스
# 2303번: 숫자 게임
# 다시 풀기
n = int(input())  # 사람의 수 입력
score = []        # 높은 점수 담는 리스트
for _ in range(n):
  card = list(map(int, input().split())) # 카드 입력
  max_digit = 0 # 가장 큰 일의 자리 수
  for i in range(5):
    for j in range(i + 1, 5):
      for k in range(j + 1, 5):
        digit = (card[i] + card[j] + card[k]) % 10 # 일의 자리 수 구하기
        if digit >= max_digit: # 제일 큰 수 구하기
          max_digit = digit
  score.append(max_digit)

for i in range(n - 1, -1, -1): # 두 명 이상일 경우 번호가 가장 큰 사람의 번호를 구하기 위해
  if score[i] == max(score):  # 제일 높은 점수 찾기
    print(i + 1)
    break
