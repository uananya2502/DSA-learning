package Recurrsion;
//import java.util.*;
public class UpperToLower {
    public static String upperToLower(String s){
        if(s.length()== 0){
            return "";
        }
        char ch = Character.toLowerCase(s.charAt(0));
        String chhotaString =upperToLower(s.substring(1));
        return ch + chhotaString;
        
    }
    public static String upperToLowerr(String s, int i){
        if(s.length()== i){
            return "";
        }
        char ch = Character.toLowerCase(s.charAt(i));
        return ch + upperToLowerr(s, i+1);
        
    }
    public static void main(String [] args){
        System.out.println(upperToLower("HELLO"));   
        System.out.println(upperToLowerr("HELLO", 0));
    }
}
