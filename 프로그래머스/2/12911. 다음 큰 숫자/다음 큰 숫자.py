def solution(n):
    newNumber = n + 1
    
    while True:
        if bin(newNumber).count('1') == bin(n).count('1'):
            return newNumber
        newNumber += 1
