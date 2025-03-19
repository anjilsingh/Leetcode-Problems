class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int l = 0;
        int len = Integer.MAX_VALUE;
        int[] arr = {-1, -1};

        HashMap<Character, Integer> mps = new HashMap<>();
        HashMap<Character, Integer> mpt = new HashMap<>();

        // Correct mpt initialization
        for (int i = 0; i < t.length(); i++) {
            mpt.put(t.charAt(i), mpt.getOrDefault(t.charAt(i), 0) + 1);
        }

        int need = mpt.size();
        int have = 0;

        for (int r = 0; r < s.length(); r++) {
            mps.put(s.charAt(r), mps.getOrDefault(s.charAt(r), 0) + 1);

            if (mpt.containsKey(s.charAt(r)) && mps.get(s.charAt(r)).intValue() == mpt.get(s.charAt(r)).intValue()) {
                have++;
            }

            while (have == need) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    arr[0] = l;
                    arr[1] = r;
                }

                mps.put(s.charAt(l), mps.get(s.charAt(l)) - 1);

                // Fix comparison here
                if (mpt.containsKey(s.charAt(l)) && mps.get(s.charAt(l)) < mpt.get(s.charAt(l))) {
                    have--;
                }
                l++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(arr[0], arr[1] + 1);
    }
}
