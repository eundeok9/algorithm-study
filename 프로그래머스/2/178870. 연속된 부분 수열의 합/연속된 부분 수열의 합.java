public class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;

        int n = sequence.length;
        int bestLen = n + 1; // sequence 길이보다 커질 수가 없음
        int answerL = 0;
        int answerR = 0;

        while (right < n) {
            sum += sequence[right];

            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                int len = right - left + 1;
                if (len < bestLen) {  // 가장 짧은 구간을 저장
                    bestLen = len;
                    answerL = left;
                    answerR = right;
                }
            }

            right++;
        }

        return new int[]{answerL, answerR};
    }
}
