import sys
input = sys.stdin.readline

k = int(input())
traversal = list(map(int, input().split()))

tree = [[] for _ in range(k)]

def inorder(traversal, depth):
    # 트리의 root
    mid = (len(traversal) // 2)

    tree[depth].append(traversal[mid]) # 루트에 해당하는 값 추가

    if len(traversal) == 1:
        return

    inorder(traversal[:mid], depth+1) # 왼쪽부터 순회
    inorder(traversal[mid+1:], depth+1) # 오른쪽 순회

inorder(traversal, 0)

for i in tree:
    print(*i)