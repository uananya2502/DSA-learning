package August;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int low = 0, high = height.length-1;
        while(low<=high){
            int brd = high-low;
            int len = Math.min(height[low], height[high]);
            max = Math.max(len*brd, max);
            if(height[low]<height[high]){
                low++;
            }else{
                high--;
            }
        }
        return max;
    }
}

