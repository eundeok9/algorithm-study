# title: 최빈수 구하기
# difficulty: D2
# 시간: 10개 테스트케이스를 합쳐서 30초
# 메모리: 힙, 정적 메모리 합쳐서 256MB이내, 스택 메모리 1MB 이내

# 문제: 어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만드려고 한다.
#      이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을 의미한다.
#      다음과 같은 수 분포가 있으면,
#      10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
#      최빈수는 8이 된다.
#      최빈수를 출력하는 프로그램을 작성하여라. (단, 최빈수가 여러 개일 때는 가장 큰 점수를 출력하라.)
# 제약 사항: 학생의 수는 1000명이며, 각 학생의 점수는 0점 이상 100점 이하의 값이다.

from collections import Counter

T = int(input()) # 테스트 케이스 수

for test_case in range(1, T+1):
    n = int(input()) # 테스트 케이스 번호
    scores = list(map(int, input().split())) # 입력 받는 점수

    # 1000명의 점수에 대해 최빈값 구하기
    counting = Counter(scores).most_common() # 각 점수가 몇 번씩 있는지 count
    most_freq = counting[0][1] # 빈도수
    res = counting[0][0] # 최빈값

    for num, freq in counting:
        if num > res and most_freq == freq: # 최빈값이 여러 개일 때 가장 큰 점수 출력
            res = num

    print("#"+str(test_case)+" "+str(res))