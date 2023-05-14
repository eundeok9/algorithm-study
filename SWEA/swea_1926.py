# title: 간단한 369 게임
# difficulty: D2
# 시간: 1개 테스트 케이스 합쳐서 4초
# 메모리: 힙, 정적 메모리 합쳐서 256MB이내, 스택 메모리 1MB 이내

N = int(input())

numbers = []

for i in range(N):
    numbers.append(i+1)

for i in range(len(numbers)):
    num = numbers[i]
    if '3' in str(num) or '6' in str(num) or '9' in str(num):
        numbers[i] = "-"
        if num % 3 == 0 and len(str(num)) >= 2 and num % 10 != 0:
            numbers[i] = "--"

print(*numbers)