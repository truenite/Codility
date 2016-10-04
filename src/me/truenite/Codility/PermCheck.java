/**
 * PermCheck.java
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

public class PermCheck {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] case1 = { 1, 2, 3, 2, 5, 6, 7 };
        System.out.println(solution(case1));
        int[] case2 = { 1, 2, 3, 4, 5, 6 };
        System.out.println(solution(case2));

    }

    public static int solution(int[] A) {
        int result = 0;
        for (int i = 1; i <= A.length; i++) {
            result = result ^ A[i - 1] ^ i;
        }
        if (result == 0) {
            return 1;
        } else
            return 0;
    }

}
