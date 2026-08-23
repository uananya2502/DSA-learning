package August.String;
/*
1. Start from the end

2. Skip unwanted spaces

3. Mark the end of the word

4. Move left until you hit a space
   ↓
   Now you found the whole word

5. Add the word

6. Repeat
*/
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        int end = s.length()-1;
        while(end>=0){
            while(end>=0 && s.charAt(end) == ' '){
                end--;
            }
            int start = end;
            while(start>=0 && s.charAt(start)!=' '){
                start--;
            }
            ans.append(s.substring(start+1, end+1));

            ans.append(" ");
            end = start;
        }
        return ans.toString().trim();
    }
}
