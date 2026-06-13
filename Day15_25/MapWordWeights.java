package Day15_25;
// 3838. Weighted Word Mapping
/*
LeetCode 3838: Weighted Word Mapping

Pattern:
- String Traversal + Character Mapping + Modulo

Idea:
- Calculate a weight for each word based on its characters.
- Each character has a reverse alphabetical value:
  'a' = 25, 'b' = 24, ..., 'z' = 0.
- Add all character weights to get the word's total weight.
- Use (totalWeight % 26) to get the index in the weights array.
- Append the corresponding mapped value to the answer.

Logic:
1. For each word:
   - Initialize sum = 0.
   - Traverse each character.
   - Convert character to its reverse alphabet weight.
   - Add it to the sum.
2. Find index = sum % 26.
3. Append weights[index] to the result.

Example:
word = "abc"

a -> 25
b -> 24
c -> 23

sum = 72
index = 72 % 26 = 20

Answer uses weights[20]

Time Complexity: O(total characters in all words)
- Each character is processed once.

Space Complexity: O(1)
- Ignoring the output string.

Key Insight:
Convert characters into reverse alphabetical weights,
find the total word weight, and use modulo 26 to map it
to the corresponding output value.
*/

public class MapWordWeights {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            int sum = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                sum += weights[ch - 'a'];
            }
            char mapped = (char) ('z' - (sum % 26));
            ans.append(mapped);
        }
        return ans.toString();
    }
}
