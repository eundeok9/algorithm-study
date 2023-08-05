import sys
from collections import deque
input = sys.stdin.readline

string = deque(list(input().rstrip())) # 개행문자 제외하고 입력 받기

stack = []
answer = []

while string:
    something = string.popleft() # 앞에서부터 pop
    if something == '(':
        stack.append(something) # 여는 괄호를 만나면 stack에 넣어준다.
        continue
    elif something == ')':
        while stack and stack[-1] != '(':
            answer.append(stack.pop()) # 닫히는 괄호를 만나면 연산자를 answer에 넣어준다.
        stack.pop() # 여는 괄호를 닫아준다.
        continue
    elif something == '*' or something == '/':
        while stack and (stack[-1] == '*' or stack[-1] == '/'):
            answer.append(stack.pop())
        stack.append(something)
        continue
    elif something == '+' or something == '-':
        while stack and stack[-1] != '(':
            answer.append(stack.pop())
        stack.append(something)
        continue
    answer.append(something) # 모든 조건에 해당하지 않는 알파벳은 answer에 바로 넣어준다.


while stack:
    answer.append(stack.pop())

print("".join(answer))
