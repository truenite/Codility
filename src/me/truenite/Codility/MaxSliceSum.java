/**
 * MaxSliceSum.java
 * @author dgarcia
 * @dateOct 4, 2016
 *
 */
package me.truenite.Codility;

/**
 * @author dgarcia
 *
 */
public class MaxSliceSum {

    public static void main(String[] args) {
        int[] arr = {3,2,-6,4,0};
        int sol1 = solution(arr);
        System.out.println(sol1==5?true:sol1);
        
        int[] arr2 = {0,-1,1,1,-3,4,-1,5,-1,8,0,1,2,-10,22};
        int sol2 = solution(arr2);
        System.out.println(sol2);
        
        
        int[] arr3 = {-10,-1,-1,-4,-10,-1};
        int sol3 = solution(arr3);
        System.out.println(sol3);
    }
    
    public static int solution(int[] A) {
        if(A.length <= 1) {
            return 0;
        }
        int max = -2147483;
        int maxLast = -2147483;
        for(int i : A) {
            if(i>maxLast + i) {
                maxLast = i;
            }else {
                maxLast +=i;
            }
            if(maxLast > max) {
                max = maxLast;
            }
        }
        return max;
    }

}
