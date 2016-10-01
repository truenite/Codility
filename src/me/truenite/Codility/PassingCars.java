package me.truenite;

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
            if (result>1000000000) {
                return -1;
            }
        }
        return result;
    }

}
