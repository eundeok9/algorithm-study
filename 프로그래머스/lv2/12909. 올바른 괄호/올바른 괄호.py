def solution(s):
    answer = True
    arr = list(s)
    stack = []

    for i in range(len(arr)):
        if arr[i] == '(':
            stack.append('(')
        if arr[i] == ')':
            if len(stack) == 0:
                return False
            elif stack[-1] == '(':
                stack.pop()

    if len(stack) != 0:
        return False
    return True