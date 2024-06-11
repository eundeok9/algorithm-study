import sys
input = sys.stdin.readline

# 상근이가 가지고 있는 숫자카드
n = int(input())
numbers1 = list(map(int, input().split()))

# 몇개 있는지 세어야 하는 카드
m = int(input())
numbers2 = list(map(int, input().split()))

answer = {}

for number in numbers1:
    if number in answer:
        answer[number] += 1
    else:
        answer[number] = 1

for number in numbers2:
    if number in answer:
        print(answer[number], end = ' ')
    else:
        print(0, end = ' ')
