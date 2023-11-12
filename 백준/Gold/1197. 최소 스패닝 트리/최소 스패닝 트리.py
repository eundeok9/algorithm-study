# 백준 1197. 최소 스패닝 트리
# 시간 제한 1초 / 메모리 제한 128MB
# 크루스칼 알고리즘 사용

import sys
input = sys.stdin.readline


v, e = map(int, input().split()) # 정점, 간선 개수

parent = [0] * (v+1)
for i in range(1, v+1):
    parent[i] = i

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

edges = []
total_cost = 0

for _ in range(e):
    a, b, weight = map(int, input().split())
    edges.append((weight, a, b))

edges.sort()



for i in range(e):
    weight, a, b = edges[i]

    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        total_cost += weight

print(total_cost)
