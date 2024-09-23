class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       Set<Integer>set=new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l=0;
        int m=0;
        while(l<nums1.length && m<nums2.length){
             if(nums1[l]==nums2[m]){
                 set.add(nums1[l]);
                 l++;
                 m++;
             }
            else if(nums1[l]<nums2[m]){
                l++;
            }
            else{
                m++;
            }
        }
int[] ans = new int[set.size()];
int i = 0;
for (int it : set) {
    ans[i++] = it;  // Copy each element from the set into the array
}
return ans;

    }
}