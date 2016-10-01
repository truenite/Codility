package me.truenite.Codility;

/**
 * CountDiv.java
 * @author dgarcia
 * @date Sep 30, 2016
 *
 */
import java.util.*;

public class CountDiv {

    public static void main(String[] args) throws Exception {
        System.out.println("Case1: " + solution(6, 11, 2));
        System.out.println("Case2: " + solution(-1, 2, 4));
        System.out.println("Case3: " + solution(-5, 5, 3));
        System.out.println("Case4: " + solution(3, 3, 3));
    }

    public static int solution(int A, int B, int K) {
        if (K > B) {
            if (A <= 0 && B >= 0)
                return 1;
            return 0;
        }
        int count = 0;
        while (B >= A) {
            if (B % K == 0)
                return 1 + ((B - A) / K);
            B--;
        }
        return count;
    }

}
