# title: 자릿수 더하기
# difficulty: D1

N = int(input())
length = len(str(N))

answer = 0

while length != 0:
    answer += N // (10**(length-1))
    N %= (10**(length-1))
    length -= 1

print(answer)