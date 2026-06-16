package Day15_25;

/*
LeetCode 54: Spiral Matrix

Pattern:
- Matrix Traversal + Boundary Simulation

Idea:
- Traverse the matrix layer by layer in spiral order.
- Maintain four boundaries:
  firstRow -> top boundary
  endRow   -> bottom boundary
  firstCol -> left boundary
  endCol   -> right boundary

Logic:
1. Traverse top row (left → right), then move top boundary down.
2. Traverse right column (top → bottom), then move right boundary left.
3. Traverse bottom row (right → left), then move bottom boundary up.
4. Traverse left column (bottom → top), then move left boundary right.
5. Repeat until boundaries cross.

Example:
matrix = [
 [1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]
]

Order:
Top    -> 1, 2, 3
Right  -> 6, 9
Bottom -> 8, 7
Left   -> 4
Center -> 5

Answer:
[1, 2, 3, 6, 9, 8, 7, 4, 5]

Time Complexity: O(m × n)
- Every element is visited exactly once.

Space Complexity: O(1) extra space
- Only boundary variables are used.
- Output list is not counted.

Key Insight:
Shrink the matrix boundaries after completing each direction.
Always check boundary conditions before traversing bottom
and left to avoid duplicate elements.
*/

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int firstRow = 0;
        int firstCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        List<Integer> list = new ArrayList<>();

        while (firstRow <= endRow && firstCol <= endCol) {

            // Top
            for (int j = firstCol; j <= endCol; j++) {
                list.add(matrix[firstRow][j]);
            }
            firstRow++;

            // Right
            for (int i = firstRow; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }
            endCol--;

            // Bottom
            if (firstRow <= endRow) {
                for (int j = endCol; j >= firstCol; j--) {
                    list.add(matrix[endRow][j]);
                }
                endRow--;
            }

            // Left
            if (firstCol <= endCol) {
                for (int i = endRow; i >= firstRow; i--) {
                    list.add(matrix[i][firstCol]);
                }
                firstCol++;
            }
        }

        return list;
    }
}
