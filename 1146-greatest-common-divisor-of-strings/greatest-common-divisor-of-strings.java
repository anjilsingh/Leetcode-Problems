class Solution {
      public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2))
            return str1;

        String strMin = str1, strMax = str2;
        if (str1.length() > str2.length()) {
            strMin = str2; strMax = str1;
        }
        if (strMax.indexOf(strMin) != 0) return "";
        return gcdOfStrings(strMin, strMax.substring(strMin.length()));
}
}