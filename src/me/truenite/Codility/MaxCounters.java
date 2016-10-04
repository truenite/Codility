/**
 * MaxCounters.java
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

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MaxCounters {

    public static void main(String[] args) {
        int[] arr = { 3, 4, 4, 6, 1, 4, 4 };
        int[] result = solution(5, arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;
        int trueMax = 0;
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                counters[A[i] - 1]++;
                if (counters[A[i] - 1] > max) {
                    max = counters[A[i] - 1];
                }
                set.add(A[i] - 1);
            }
            if (A[i] == N + 1) {
                Iterator<Integer> ite = set.iterator();
                while (ite.hasNext()) {
                    counters[ite.next()] = 0;
                }
                set = new TreeSet<Integer>();
                trueMax += max;
                max = 0;
            }
        }
        for (int i = 0; i < counters.length; i++) {
            counters[i] += trueMax;
        }
        return counters;
    }
}
