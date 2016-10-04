/**
 * StoneWall.java
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

public class StoneWall {

    public static void main(String[] args) {
        int[] arr = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
        System.out.println(solution(arr));
    }

    public static int solution(int[] H) {
        int count = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(H[0]);
        for (int i = 1; i < H.length; i++) {
            if (H[i] == H[i - 1]) {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(H[i]);
                continue;
            }
            if (H[i] > H[i - 1]) {
                stack.push(H[i] - H[i - 1]);
            }
            if (H[i] < H[i - 1]) {
                int curr = H[i - 1];
                while (curr > H[i]) {
                    curr -= stack.pop();
                    count++;
                }
                if (curr == H[i]) {
                    continue;
                } else {
                    stack.push(H[i] - curr);
                }
            }
        }
        return count + stack.size();
    }

}
