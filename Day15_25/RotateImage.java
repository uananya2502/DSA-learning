package Day15_25;
/*
LeetCode 48: Rotate Image

Pattern:
- Matrix + In-place Transformation + Transpose + Reverse

Idea:
- Rotate the matrix 90° clockwise without using extra space.
- First transpose the matrix (swap rows and columns).
- Then reverse every row.

Logic:
1. Transpose:
   matrix[i][j] <-> matrix[j][i]

2. Reverse each row:
   [1, 2, 3] -> [3, 2, 1]

Example:
matrix = [
 [1,2,3],
 [4,5,6],
 [7,8,9]
]

After transpose:
[
 [1,4,7],
 [2,5,8],
 [3,6,9]
]

After reversing rows:
[
 [7,4,1],
 [8,5,2],
 [9,6,3]
]

Time Complexity: O(n²)
- Every element is visited once during transpose and reverse.

Space Complexity: O(1)
- Rotation is done in-place.

Key Insight:
90° clockwise rotation = Transpose the matrix + Reverse each row.
*/
public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);

        int left = 0, right = matrix[0].length - 1;

        while (left < right) {
            for (int row = 0; row < matrix.length; row++) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
            }
            left++;
            right--;
        }
    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
