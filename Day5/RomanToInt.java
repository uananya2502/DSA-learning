package Day5;
import java.util.HashMap;

public class RomanToInt {
    public static int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int num = 0;
        int prev = 0 ;
        for(int i = s.length()-1 ;i>=0; i-- ){
            int curr = map.get(s.charAt(i));
            if(curr < prev)   
                num -= curr;
            else{
                num+=curr;
            }
            prev = curr;
        }
        return num;
    }
    public static void main(String[] args) {
        String s = "IV";
        int n = romanToInt(s);
        System.out.println(n);
    }
}
