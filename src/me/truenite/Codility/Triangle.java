/**
 * Triangle.java
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
import java.util.*;
import java.lang.Math;

public class Triangle {

    /**
     * 
     */
    public static void main(String[] args) {
        int[] arr = {10,2,5,1,8,20};
        System.out.println(solution(arr));
    }
    
    public static int solution(int[] A) {
        ArrayList<Integer> alist = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++){
            alist.add(A[i]);
        }
        Collections.sort(alist);
        for(int i = 0; i < A.length-2; i++) {
            if(Math.abs(alist.get(i)-alist.get(i+1)) < alist.get(i+2)
                    && Math.abs(alist.get(i)-alist.get(i+2)) < alist.get(i+1)
                    && Math.abs(alist.get(i+2)-alist.get(i+1)) < alist.get(i))
                return 1;
        }
        return 0;
    }

}
