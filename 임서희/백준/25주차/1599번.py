# 파싱, 문자열
# 1599번: 민식어

# 다시 풀기
n = int(input())
word = list()
for _ in range(n):
    word.append(input())
minsik = {"a": "A", "b": "B", "k":"C",
"d": "D", "e":"E", "g":"F", "h":"G", "i":"H", "l":"I",
"m":"J", "n":"K","o":"M", "p":"N", "r":"O",
"s":"P", "t":"Q", "u":"R","w":"S","y":"T"}

ch_word = list()
for i in range(n):
    w = word[i].replace('ng','z')
    ch_w = ''
    for c in w:
        ch_w += minsik[c]
    ch_word.append([ch_w, i])
ch_word.sort(key=lambda x:x[0])
for i,j in ch_word:
    print(word[j])