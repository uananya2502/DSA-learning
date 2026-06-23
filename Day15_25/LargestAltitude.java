package Day15_25;

public class LargestAltitude {
    public int largestAltitude(int[] gain) {
        int al1 =0;
        int max =0;
        for(int num: gain){
            int al2 = num + al1;
            max = Math.max(al2, max);
            al1 = al2;
        }
        return max;
    }
}
