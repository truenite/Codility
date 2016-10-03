/**
 * GenomicRangeQuery.java
 * @author dgarcia
 * @dateOct 3, 2016
 * 
 * There's three solutions in this file. BruteForce, Saving an object Rage in a 
 * List and saving the last seen of the number in an array.
 * 
 * BF performance fails every test.
 * LinkedList performance fails large_random test (87% overall score)
 * Last seen gets 100%
 *
 */
package me.truenite.Codility;
import java.util.*;

public class GenomicRangeQuery {


    public static void main(String[] args) {
        int[] P = { 0, 5, 0 };
        int[] Q = { 0, 5, 6 };
        int[] res = solution("CAGCCTA", P, Q);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
    
    public static int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        
        int[] lastSeenA = new int[S.length()];
        int[] lastSeenC = new int[S.length()];
        int[] lastSeenG = new int[S.length()];
        int[] lastSeenT = new int[S.length()];
        lastSeenA[0] = -1;
        lastSeenC[0] = -1;
        lastSeenG[0] = -1;
        lastSeenT[0] = -1;
        
        char[] carr = S.toCharArray();
        for(int i = 0; i < carr.length; i++) {
            saveLastSeen(lastSeenA, carr[i] == 'A', i);
            saveLastSeen(lastSeenC, carr[i] == 'C', i);
            saveLastSeen(lastSeenG, carr[i] == 'G', i);
            saveLastSeen(lastSeenT, carr[i] == 'T', i);
        }
        for(int i = 0; i < P.length; i++) {
            if(lastSeenA[Q[i]] >= P[i] ) {
                result[i] = 1;
                continue;
            }
            if(lastSeenC[Q[i]] >= P[i] ) {
                result[i] = 2;
                continue;
            }
            if(lastSeenG[Q[i]] >= P[i] ) {
                result[i] = 3;
                continue;
            }
            if(lastSeenT[Q[i]] >= P[i] ) {
                result[i] = 4;
                continue;
            }
        }
        
        return result;
    }
    
    private static void saveLastSeen(int[] array, boolean last_seen, int index) {
        if(last_seen) {
            array[index] = index;
        } else {
            if(index > 0)
                array[index] = array[index-1];
        }
        
    }

    public static int[] solutionBF(String S, int[] P, int[] Q) {
        int cases = P.length;
        int[] result = new int[cases];
        
        char[] carr = S.toCharArray();
        for(int i = 0; i < cases; i++) {
            result[i] = 4;
            
            for(int j = P[i]; j <= Q[i]; j++){
                int val = charVal(carr[j]);
                if(val == 1) {
                    result[i] = 1;
                    break;
                }
                if(val < result[i]) {
                    result[i] = val;
                }
            }
        }
        return result;
    }
    
    public static int[] solutionSavingRangesInList(String S, int[] P, int[] Q) {
        int cases = P.length;
        int[] result = new int[cases];
        
        char[] carr = S.toCharArray();
        LinkedList<Range> ranges = new LinkedList<Range>();
        int begRange = 0;
        int valPast = charVal(carr[0]);
        int minValue = 4;
        for(int i = 1; i < carr.length; i++) {
            int val = charVal(carr[i]);
            if(val < minValue) {
                minValue = val;
            }
            if(val!=valPast) {
                ranges.add(new Range(begRange,i-1,valPast));
                begRange = i;
                valPast = charVal(carr[i]);
            }
            
        }
        ranges.add(new Range(begRange,carr.length-1,valPast));
        for(int i = 0; i < cases; i++) {
            result[i] = 4;
            Iterator<Range> ite = ranges.iterator();
            while(ite.hasNext()){
                Range curr = ite.next();
                if(curr.beg<=Q[i] && curr.end>=P[i] && curr.val < result[i]) {
                    result[i] = curr.val;
                    if(curr.val == minValue) {
                        break;
                    }
                } else{
                    if(curr.beg>Q[i]) {
                        break;
                    }
                }
            }
        }
        
        return result;
    }
    
    private static int charVal(char c) {
        switch(c) {
            case 'A': 
                return 1;
            case 'C': 
                return 2;
            case 'G': 
                return 3;
            default: 
                return 4;
        }
    }

}

class Range{
    int beg = 0;
    int end = 0;
    int val = 0;
    
    public Range(int beg, int end, int val){
        this.beg = beg;
        this.end = end;
        this.val = val;
    }
    public String toString() {
        return val+" ["+beg+"-"+end+"] ";
    }
    
}
