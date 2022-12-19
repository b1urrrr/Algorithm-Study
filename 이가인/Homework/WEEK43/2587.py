nums = []
for i in range(5):
    nums.append(int(input()))
    nums.sort()

print(int(sum(nums)/5))
print(nums[2])

