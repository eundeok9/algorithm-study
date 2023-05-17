# title: 중간값 찾기
# difficulty: D1
# 시간: 1개 테스트 케이스 합쳐서 30초
# 메모리: 힙, 정적 메모리 합쳐서 256MB이내, 스택 메모리 1MB 이내

N = int(input())
scores = list(map(int,input().split()))
scores.sort()
print("{}".format(scores[N//2]))