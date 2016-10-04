/**
 * Brackets.java
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

public class Brackets {

    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("([)()]"));

    }

    public static int solution(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stack.push(arr[i]);
            } else {
                try {
                    char cr = stack.pop();
                    if (arr[i] == ')' && cr != '(')
                        return 0;
                    if (arr[i] == ']' && cr != '[')
                        return 0;
                    if (arr[i] == '}' && cr != '{')
                        return 0;
                } catch (EmptyStackException e) {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

}
