/**
 * MaxProductOfThree.java
 * Oct 3, 2016
 * @author Diego Garcia
 * 
 * Copyright (C) 2016 Diego Garcia
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package me.truenite.Codility;

import java.util.*;

public class MaxProductOfThree {

    public static void main(String[] args) {
        int[] arr1 = { -3, 1, 2, -2, 5, 6 };
        System.out.println("Case1: " + solution(arr1));
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 3, 100, 100 };
        System.out.println("Case2: " + solution(arr2));
        int[] arr3 = { -1, -4, -5, -6, 0 };
        System.out.println("Case3: " + solution(arr3));
        int[] arr4 = { 30, 50, 40, 1, 2, 3, 7, 9, 8, 6, 5, 4, 3, 10, 12, 14 };
        System.out.println("Case4: " + solution(arr4));
        int[] arr5 = new int[2001];
        int num = -1000;
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = num;
            num++;
        }
        System.out.println("Case5: " + solution(arr5));
        int[] arr6 = { 3, 8, 9, 6, 7, 7, 6, 8, 8, 8, 1, 2, 4 };
        System.out.println("Case6: " + solution(arr6));
        int[] arr7 = { 10, 10, 10 };
        System.out.println("Case7: " + solution(arr7));

    }

    public static int solution(int[] A) {
        // We only care about the biggest three and the
        // smallest 2 (in case they're both big negatives)
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            int limit = res.size() > 3 ? 3 : res.size();
            boolean added = false;
            for (int j = 0; j < limit; j++) {
                if (A[i] >= res.get(j)) {
                    res.add(j, A[i]);
                    added = true;
                    break;
                }
            }
            if (!added) {
                limit = res.size() >= 2 ? res.size() - 2 : 0;
                for (int j = res.size() - 1; j >= limit; j--) {
                    if (A[i] < res.get(j)) {
                        res.add(j + 1, A[i]);
                        break;
                    }
                }
            }
        }
        int res1 = res.get(0) * res.get(1) * res.get(2);
        int res2 = res.get(0) * res.get(res.size() - 1)
                * res.get(res.size() - 2);

        return res1 > res2 ? res1 : res2;
    }

}
