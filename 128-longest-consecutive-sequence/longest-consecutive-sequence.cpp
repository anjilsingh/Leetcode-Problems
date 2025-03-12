class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int>seen;
        for(int num:nums){
            seen.insert(num);
        }
        int ans=0;
        for(int num:seen){
            if(seen.count(num-1)){
                continue;
            }
            else{
                int l=1;
                while(seen.count(num+l)){
                    l++;
                }
                   if(l>ans){
            ans=l;
         }
            }
      

        }
        return ans;
    }
};