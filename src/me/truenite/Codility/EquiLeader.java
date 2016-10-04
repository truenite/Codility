/**
 * EquiLeader.java
 * Oct 4, 2016
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

public class EquiLeader {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 4, 4, 4, 2 };
        System.out.println(solution(arr) == 2);
        int[] arr2 = { 4, 4, 2, 5, 3, 4, 4 };
        System.out.println(solution(arr2) == 0);
        int[] arr3 = { 1, 2, 1, 1, 2, 1 };
        System.out.println(solution(arr3) == 3);
        int[] arr4 = { 1, 2, 3, 4, 5 };
        System.out.println(solution(arr4) == 0);
        int[] arr5 = { 0, 0 };
        System.out.println(solution(arr5) == 1);

    }
    /* 
     * There's probably a cleaner way to do this. But this passes all the tests.
     */
    public static int solution(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        int[] equiLeft = new int[A.length];
        int[] equiRight = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            equiLeft[i] = 1000000001;
            equiRight[i] = 1000000001;
        }
        equiLeft[0] = A[0];
        equiRight[A.length - 1] = A[A.length - 1];
        int max = 0;
        int reps = 0;

        for (int i = 0; i < A.length; i++) {
            if (count.containsKey(A[i])) {
                int num = count.get(A[i]);
                num++;
                if (num > reps) {
                    reps = num;
                    max = A[i];
                }
                count.put(A[i], num);

            } else {
                count.put(A[i], 1);
            }

            if (reps > ((i + 1) / 2)) {
                equiLeft[i] = max;
            }
        }
        reps = 0;
        max = 0;
        count = new HashMap<Integer, Integer>();
        for (int i = A.length - 1; i >= 0; i--) {
            if (count.containsKey(A[i])) {
                int num = count.get(A[i]);
                num++;
                if (num > reps) {
                    reps = num;
                    max = A[i];
                }
                count.put(A[i], num);
            } else {
                count.put(A[i], 1);
            }

            int idx = A.length - i;
            if (reps > (idx / 2)) {
                equiRight[i] = max;
            }
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (equiRight[i + 1] == equiLeft[i] && equiLeft[i] != 1000000001) {
                res++;
            }
        }
        return res;
    }

}
