def solution(s):
    numbers = list(map(int, s.split()))
    min, max = numbers[0], numbers[0]
    for i in numbers:
        if min > i:
            min = i
        elif max < i:
            max = i
    answer = "{} {}".format(min, max)
        
    return answer