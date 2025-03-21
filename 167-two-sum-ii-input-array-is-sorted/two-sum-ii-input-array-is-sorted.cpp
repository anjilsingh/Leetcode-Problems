class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int l=0;
        int r=numbers.size()-1;

        vector<int>ans;
        while(l<r){
            int sum=numbers[l]+numbers[r];
            if(sum==target){
                ans.push_back(l+1);
                ans.push_back(r+1);
                return  ans;
            }

            else if(sum<target){
                l++;
            }
            
            else{
                r--;
            }
        }
        return ans;
    }
};