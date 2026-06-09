package Day12;
//169. Majority Element
/*
    we need to find majority element of the given array which is greater than half of its length.
    The optimal approch is using Moore's algorithm 
    Moore's Algorithm:
        Take a count variable increase it if element int iteration is same, decrease if element is different.
        If count is equal to zero change element into new element and do the same.
        The element that survive at the last will the max element.
        Make sure to double check because is there will be no element, it can give wrong answer.
*/

public class MajorityElement {
    public static int majorityElement(int [] nums){
        int c =0;
        int ele =0;
        for(int x: nums){
            if(c==0){
                ele = x;
                c++;
            }
            else if(ele==x)
                c++;
            else
                c--;
        }
        c=0;
        for(int x: nums){
            if(ele == x)
                c++;
        }
        if(c>nums.length)
            return ele;
        return -1;
    }
}
