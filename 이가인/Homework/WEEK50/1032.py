n = int(input())
word = list(input())
word_len = len(word)

for i in range(n-1):
    other_words = list(input())
    for j in range(word_len):
        if word[j] != other_words[j]:
            word[j] = "?"

print(''.join(word))