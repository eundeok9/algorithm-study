def solution(s):
    numbers = list(map(int, s.split()))
    numbers.sort()
    answer = "{} {}".format(numbers[0], numbers[-1])
        
    return answer