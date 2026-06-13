package Day15_25;

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
