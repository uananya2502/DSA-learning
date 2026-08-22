package August.String;
/* 
For the largest odd number, find the rightmost odd digit and return everything before it (including it).

Time Complexity: O(n)
Space Complexity: O(1)
*/


public class LargestOddNumber {
    public String largestOddNumber(String num) {
        int high = num.length()-1;
        while(high>=0){
            int n1 = num.charAt(high) - '0';
            if(n1%2!=0){
                return num.substring(0, high+1);
            }else{
                high--;
            }
        }
        return "";
    }
}

