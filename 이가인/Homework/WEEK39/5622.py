words = input()
nums = []
time = 0
for i in range(len(words)):
    if (words[i] == 'A') or (words[i] == 'B') or (words[i] == 'C'):
        nums.append(2)
    elif (words[i] == 'D') or (words[i] == 'E') or (words[i] == 'F'):
        nums.append(3)
    elif (words[i] == 'G') or (words[i] == 'H') or (words[i] == 'I'):
        nums.append(4)
    elif (words[i] == 'J') or (words[i] == 'K') or (words[i] == 'L'):
        nums.append(5)
    elif (words[i] == 'M') or (words[i] == 'N') or (words[i] == 'O'):
        nums.append(6)
    elif (words[i] == 'P') or (words[i] == 'Q') or (words[i] == 'R') or (words[i] == 'S'):
        nums.append(7)
    elif (words[i] == 'T') or (words[i] == 'U') or (words[i] == 'V'):
        nums.append(8)
    elif (words[i] == 'W') or (words[i] == 'X') or (words[i] == 'Y') or (words[i] == 'Z'):
        nums.append(9)

for i in range(len(nums)):
    time += nums[i]

print(time + len(words) )
