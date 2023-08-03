import sys
input = sys.stdin.readline

textList = list(input().rstrip()) # 텍스트 입력 받기
popList = []

n = int(input())
line = [] # 명령어

def move(inputLine):
    if inputLine[0]=='L':
        if textList:
            popList.append(textList.pop())

    elif inputLine[0] == 'D':
        if popList:
            textList.append(popList.pop())

    elif inputLine[0] == 'P':
        textList.append(inputLine[1])

    elif inputLine[0] == 'B':
        if textList:
            textList.pop()


for _ in range(n):
    line = list(map(str, input().rstrip().split(" ")))
    move(line)

textList.extend(reversed(popList))
print("".join(textList))