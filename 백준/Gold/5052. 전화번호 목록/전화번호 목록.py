import sys
input = sys.stdin.readline

class Node(object):
    def __init__(self, key, data=None):
        self.key = key
        self.data = data
        self.children = {}

class Trie(object):
    def __init__(self):
        self.head = Node(None)

    def insert(self, string):
        cur_node = self.head

        for char in string:
            if char not in cur_node.children:
                cur_node.children[char] = Node(char)
            cur_node = cur_node.children[char]

        cur_node.data = string

    def search_prefix(self, string):
        cur_node = self.head

        for char in string:
            cur_node = cur_node.children[char]

        if cur_node.children:
            return False
        else:
            return True

t = int(input())


for _ in range(t):
    n = int(input())
    trie = Trie()
    nums = []
    for _ in range(n):
        num = input().rstrip()
        nums.append(num)
        trie.insert(num)

    isPossible = True
    for num in nums:
        if not trie.search_prefix(num):
            isPossible = False
            break

    if isPossible:
        print('YES')
    else:
        print('NO')
