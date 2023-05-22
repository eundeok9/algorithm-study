def solution(n):
    numbers = []
    for i in range(1, n+1):
        if n % i == 0:
            numbers.append(i)
    
    return sum(numbers)