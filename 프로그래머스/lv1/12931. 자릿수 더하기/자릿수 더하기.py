def solution(n):
    answer = 0
    length = len(str(n))
    while length != 0:
        answer += n // (10**(length-1))
        n %= (10**(length-1))
        length -= 1   

    return answer