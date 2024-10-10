class Solution {
    public int calculate(String s) {
        return recursion(s+"#", 0)[0];
    }

    private int[] recursion(String s, int idx) {
        int num = 0;
        int res = 0;
        boolean isPlus = true;
        do {
            char c = s.charAt(idx++);
            if (c >= 48 && c <= 57) num = num * 10 + c - 48;
            else if (c == ' ') continue;
            else {
                res = isPlus ? res + num : res - num;
                num = 0;
                if (c == '+') isPlus = true;
                else if (c == '-') isPlus = false;
                else if (c == '(') {
                    int[] _re = recursion(s, idx);
                    res = isPlus ? res + _re[0] : res - _re[0];
                    idx = _re[1];
                } else if (c == ')') {
                    return new int[]{res, idx};
                }
            }
        } while (idx < s.length());
        return new int[]{res, idx};
    }
}