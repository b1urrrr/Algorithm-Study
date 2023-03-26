# 그리디 알고리즘
# 14487번: 욱제는 효도쟁이야
n = int(input())
nums = list(map(int, input().split()))
print(sum(nums) - max(nums))