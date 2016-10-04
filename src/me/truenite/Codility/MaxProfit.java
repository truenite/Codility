/**
 * MaxProfit.java
 * @author dgarcia
 * @dateOct 4, 2016
 *
 */
package me.truenite.Codility;

public class MaxProfit {

    public static void main(String[] args) {
        int[] arr = { 23171, 21011, 21123, 21366, 21013, 21367 };
        System.out.println(solution(arr));

    }

    public static int solution(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int result = 0;
        int smallest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < smallest) {
                smallest = A[i];
            }
            if (A[i] - smallest > result) {
                result = A[i] - smallest;
            }
        }
        return result > 0 ? result : 0;
    }

}
