# title: 홀수만 더하기
# difficulty: D1
# 시간: 3개 테스트케이스를 합쳐서 30초
# 메모리: 힙, 정적 메모리 합쳐서 256MB이내, 스택 메모리 1MB 이내

# 문제: 10개의 수를 입력 받아, 그 중에서 홀수만 더한 값을 출력하는 프로그램을 작성하라.
# 제약 사항: 각 수는 0 이상 10000 이하의 정수이다.

T = int(input()) # 입력 받을 테스트 케이스 수

for i in range(T):
    numbers = list(map(int, input().split()))
    odd_nums = [num for num in numbers if num % 2 == 1]
    print("#{} {}".format(i+1, sum(odd_nums)))


