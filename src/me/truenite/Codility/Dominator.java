/**
 * Dominator.java
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

public class Dominator {

    public static void main(String[] args) {
        int[] arr = { 3, 4, 3, 2, 3, -1, 3, 3, 3, 1, 1 };
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        if (A.length == 1) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int num = map.get(A[i]);
                num++;
                if ((double) num > (double) A.length / 2) {
                    return i;
                }
                map.put(A[i], num);
            } else {
                map.put(A[i], 1);
            }
        }
        return -1;
    }

}
