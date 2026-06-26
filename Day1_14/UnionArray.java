package Day1_14;

import java.util.ArrayList;

public class UnionArray {
    public static ArrayList<Integer> unionArray(int[] n1, int[] n2){
        ArrayList<Integer> a = new ArrayList<>();
        int i=0, j=0;
        while(i<n1.length && j<n2.length){
            if(n1[i]<n2[j]){
                if (a.isEmpty() || a.get(a.size() - 1) != n1[i]){
                    a.add(n1[i]);
                }
                i++;
            }
            else{
                if (a.isEmpty() || a.get(a.size() - 1) != n1[j]){
                    a.add(n1[j]);
                }
                j++;
            }
        }
        while(i< n1.length){
            if (a.isEmpty() || a.get(a.size() - 1) != n1[i]){
                    a.add(n1[i]);
                }
            i++;
        }
        while(j< n2.length){
            if (a.isEmpty() || a.get(a.size() - 1) != n2[j]){
                    a.add(n1[j]);
                }
            j++;
        }

        return a;
    }
}
