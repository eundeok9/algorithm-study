import sys
import heapq

pq = [] #절댓값을 저장하는 min-heap

N = int(sys.stdin.readline())
for _ in range(N):
    x = int(sys.stdin.readline())
    if(x != 0):
        heapq.heappush(pq,[abs(x),x])
    elif(x == 0):
        if(len(pq)==0): print(0)
        else:
           print(heapq.heappop(pq)[1])

