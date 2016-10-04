/**
 * Fish.java
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

public class Fish {

    public static void main(String[] args) {
        int[] A = { 4, 3, 6, 1, 5 };
        int[] B = { 0, 1, 1, 0, 0 };
        System.out.println(solution(A, B));

        int[] C = { 0, 1 };
        int[] D = { 1, 1 };
        System.out.println(solution(C, D));

    }

    public static int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<Integer>();
        int downwards = -1;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0 && downwards == -1) {
                count++;
                continue;
            }
            if (B[i] == 1) {
                if (downwards != -1) {
                    stack.push(downwards);
                }
                downwards = A[i];
                continue;
            }
            while (downwards != -1) {
                if (A[i] > downwards) {
                    if (stack.size() > 0) {
                        downwards = stack.pop();
                    } else {
                        count++;
                        downwards = -1;
                    }
                } else {
                    break;
                }
            }
        }
        if (downwards != -1) {
            count++;
        }
        count += stack.size();
        return count;
    }

}
