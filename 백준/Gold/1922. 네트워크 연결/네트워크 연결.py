# 백준 1922. 네트워크 연결
# 시간 제한 2초 / 메모리 제한 256MB

import sys
input = sys.stdin.readline

n = int(input()) # 노드 수
m = int(input()) # 간선 수

# union-find 알고리즘
# 1. parent 배열 초기화
parent = [0] * (n+1)
for i in range(1, n+1):
    parent[i] = i

# 2. find 함수
def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

# 3. union 함수
def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a > b:
        parent[a] = b
    else:
        parent[b] = a

# 크루스칼 알고리즘
edges  = []

for _ in range(m):
    a, b, c = map(int, input().split())

    edges.append([c, a, b])

# 비용을 기준으로 정렬
edges.sort()

total_cost = 0
for i in range(m):
    c, a, b = edges[i]

    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        total_cost += c

print(total_cost)