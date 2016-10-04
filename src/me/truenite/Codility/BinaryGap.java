/**
 * BinaryGap.java
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

public class BinaryGap {
    public static void main(String[] args) {
        int N = 1041;
        System.out.println(solution(N));

    }

    public static int solution(int N) {
        int max = 0;
        int count = 0;
        boolean started = false;
        while (N > 0) {
            if (N % 2 == 0 && started) {
                count++;
            }
            if (N % 2 == 1) {
                started = true;
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
            N = N / 2;
        }
        return max;
    }

}