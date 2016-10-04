/**
 * CountFactors.java
 * @author dgarcia
 * @dateOct 4, 2016
 *
 */
package me.truenite.Codility;

/**
 * @author dgarcia
 * 
 */
public class CountFactors {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution(24));
        System.out.println(solution(36));
        System.out.println(solution(16));
        System.out.println(solution(10));
        System.out.println(solution(3));
        System.out.println(solution(2));
        System.out.println(solution(1));

    }

    public static int solution(int N) {
        if (N == 1)
            return 1;
        int result = 0;
        int div = 1;
        int lastdivisor = N;
        while (div < lastdivisor) {
            if (N % div == 0) {
                if (div * div == N) {
                    result++;
                } else {
                    result += 2;
                }

            }
            lastdivisor = N / div;
            div++;
        }
        return result;
    }

}
