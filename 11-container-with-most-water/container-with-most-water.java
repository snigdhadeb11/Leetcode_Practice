class Solution {
    public int maxArea(int[] h) {
        int n = h.length;
        int maxA = Integer.MIN_VALUE;
        int l=0;
        int r=n-1;
        while(l<r){
            if(h[l]<h[r]){
                int a=h[l]*(r-l);
                if(maxA<a){ maxA=a; }
                l++;
            }
            else{
                int a=h[r]*(r-l);
                if(maxA<a){ maxA=a; }
                r--;
            }
        }
        return maxA;
    }
}