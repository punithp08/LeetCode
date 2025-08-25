class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
       int n = tops.length;
        int rotations1 = countRotations(tops[0], tops, bottoms);
        int rotations2 = countRotations(bottoms[0], tops, bottoms);
        
        if (rotations1 != -1 && rotations2 != -1) {
            return Math.min(rotations1, rotations2);
        } else if (rotations1 != -1) {
            return rotations1;
        } else {
            return rotations2;
        }
    }

    private int countRotations(int x, int[] tops, int[] bottoms) {
        int topRotations = 0;
        int bottomRotations = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != x && bottoms[i] != x) {
                return -1;
            } else if (tops[i] != x) {
                topRotations++;
            } else if (bottoms[i] != x) {
                bottomRotations++;
            }
        }
        return Math.min(topRotations, bottomRotations); 
    }
}