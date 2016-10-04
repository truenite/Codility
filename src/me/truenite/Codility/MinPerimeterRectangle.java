/**
 * MinPerimeterRectangle.java
 * @author dgarcia
 * @dateOct 4, 2016
 *
 */
package me.truenite.Codility;

/**
 * @author dgarcia
 * 
 */
public class MinPerimeterRectangle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution(30) == 22);
        System.out.println(solution(31) == 64);
        System.out.println(solution(32) == 24);
        System.out.println(solution(4) == 8);
        System.out.println(solution(1234) == 1238);
        System.out.println(solution(982451653) == 1964903308);

    }

    public static int solution(int N) {
        int result = 2 * (N + 1);
        int div = 2;
        int lastdivisor = N;
        while (div < lastdivisor) {
            if (N % div == 0) {
                int peri = 2 * (div + (N / div));
                if (result > peri) {
                    result = peri;
                }
            }
            lastdivisor = N / div + 1;
            div++;
        }
        return result;
    }

}
