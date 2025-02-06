class Solution {
public:
    int countSubarrays(vector<int>& a) {
        int x=0,n=a.size();

        for(int i=0;i+2<n;i++){
            if(a[i]+a[i+2]==a[i+1]/2.0) x++;
        }
        return x;
    }
};