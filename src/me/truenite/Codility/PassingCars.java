/**
 * PassingCars.java
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

public class PassingCars {

    public static void main(String[] args) {
        int[] A = { 0, 1, 0, 1, 1 };
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int result = 0;
        int mult = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                mult++;
            } else {
                result += mult;
            }
            // This if can go inside or outside the loop for codility's
            // performance tests it doesn't matter.
            if (result > 1000000000) {
                return -1;
            }
        }
        return result;
    }

}
