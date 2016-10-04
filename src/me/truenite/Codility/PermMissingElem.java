/**
 * PermMissingElem.java
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

public class PermMissingElem {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 5, 6 };
        System.out.println(solution(arr));

    }

    public static int solution(int[] A) {
        int result = 0;
        for (int i = 1; i <= A.length; i++) {
            result += A[i - 1] - i;
        }
        return A.length + 1 - result;
    }

}
