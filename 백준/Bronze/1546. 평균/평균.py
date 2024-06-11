import sys
input = sys.stdin.readline

n = int(input())
scores = list(map(int, input().split()))
m = max(scores)

sum = 0

for i in range(len(scores)):
    scores[i] = scores[i] / m * 100
    sum += scores[i]

    
print(sum / n)
