from collections import Counter

def solution(array):
    counting = Counter(array).most_common()
    most_freq = counting[0][1]
    res = counting[0][0]
    
    for num, freq in counting:
        if res != num and most_freq == freq:
            res = -1
    return res