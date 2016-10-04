/**
 * MinAvgTwoSlice.java
 * @author dgarcia
 * @dateOct 3, 2016
 * 
 * Did a BF solution and a better one.. O(N)
 * The trick with this problem is that the lowest average would have at most 3 numbers.
 * 
 * Correctness and performance both at 100% with solution.
 * BF fails most performance tests but is 100% correct.
 *
 */
package me.truenite.Codility;

public class MinAvgTwoSlice {

    public static void main(String[] args) {
        int[] case1 = { 4, 2, 2, 5, 1, 5, 8 };
        int[] case2 = { 4, 2 };
        int[] case3 = { 2, 1, -1, -10 };
        int[] case4 = { -2, 2, -4, -1 };
        int[] case5 = { -10, -20, -30, -40 };
        System.out.println("Case1BF " + solutionBF(case1));
        System.out.println("Case2BF " + solutionBF(case2));
        System.out.println("Case3BF " + solutionBF(case3));
        System.out.println("Case4BF " + solutionBF(case4));
        System.out.println("Case5BF " + solutionBF(case5));

        System.out.println("Case1 " + solution(case1));
        System.out.println("Case2 " + solution(case2));
        System.out.println("Case3 " + solution(case3));
        System.out.println("Case4 " + solution(case4));
        System.out.println("Case5 " + solution(case5));

    }

    public static int solution(int[] A) {
        int result = 0;
        double lowestAvg = 10000;
        for (int i = 0; i < A.length - 2; i++) {
            double sum = A[i] + A[i + 1];
            double avg = sum / 2;
            if (avg < lowestAvg) {
                lowestAvg = avg;
                result = i;
            }
            sum += A[i + 2];
            avg = sum / 3;
            if (avg < lowestAvg) {
                lowestAvg = avg;
                result = i;
            }
        }
        double sum = A[A.length - 2] + A[A.length - 1];
        double avg = (sum) / 2;
        if (avg < lowestAvg) {
            lowestAvg = avg;
            result = A.length - 2;
        }
        return result;
    }

    public static int solutionBF(int[] A) {
        int result = 0;
        double lowestAvg = 10000;
        for (int i = 0; i < A.length - 1; i++) {
            int sum = A[i];
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                double avg = (double) sum / ((j - i) + 1);
                if (avg < lowestAvg) {
                    lowestAvg = avg;
                    result = i;
                }

            }
        }
        return result;
    }

}
