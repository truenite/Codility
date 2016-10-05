/**
 * Flags.java
 * @author dgarcia
 * @dateOct 4, 2016
 *
 */
package me.truenite.Codility;
import java.util.*;
/**
 * @author dgarcia
 *
 */
public class Flags {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,3,4,1,2,3,4,6,2};
        System.out.println(solution(arr));
        /*int[] arr2 = {1,2,1};
        System.out.println(solution(arr2));
        int[] arr3 = {1,5,3,3,3,4,3,5,3,4,1,2,3,4,6,2};
        System.out.println(solution(arr3));
        int[] arr4 = {1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1};
        System.out.println(solution(arr4));*/

    }
    
    public static  int solution(int[] A) {
        if(A.length <= 2) {
            return 0;
        }
        ArrayList<Integer> peaks = new ArrayList<Integer>();
        for(int i = 1; i < A.length-1; i++){
            if(A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks.add(i);
            }
        }
        int result = peaks.size();
        System.out.println(peaks);
        if(result > 1 ) {
            int flags = result;
            while(flags > 0) {
                System.out.println("RES "+result);
                for(int i = 0; i < peaks.size()-1; i++){
                    System.out.println(peaks.get(i));
                    System.out.println(peaks.get(i+1));
                    if(peaks.get(i+1) - result >= peaks.get(i)) {
                        System.out.println("SI");
                        flags--;
                    }else {
                        System.out.println("NEL");
                    }
                }
                System.out.println("FLags end: "+flags);
                if(flags > 0) {
                    System.out.println("resultnel: "+result);
                    result--;
                    flags = result;
                }
            }
        }
        
        return result;
    }

}
