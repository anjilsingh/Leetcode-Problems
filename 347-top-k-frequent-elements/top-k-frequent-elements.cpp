class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int>mp;
        for(int num:nums){
            mp[num]++;
        }
        vector<pair<int,int>>res;

        for(const auto& pair:mp){
            res.push_back({pair.second,pair.first});
        }
        sort(res.rbegin(),res.rend());
        vector<int>ans;
        for(int i=0;i<k;i++){
            ans.push_back(res[i].second);
        }
        return ans;
        
    }
};