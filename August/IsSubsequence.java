package August;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int si = 0;
        int ti =0;
        while(t.length()>ti && s.length()>si ){
            if(s.charAt(si)==t.charAt(ti)){
                si++;
            }
            ti++;
        }
        if(s.length()==si){
            return true;
        }
        return false;
    }
}
