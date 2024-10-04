class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int left = 0, right = skill.length - 1;
        int teamSkill = skill[left] + skill[right];
        long totalChemistry = 0;

        while (left < right) {
            if (teamSkill != skill[left] + skill[right]) {
                return -1;
            }
            totalChemistry += (long) skill[left] * skill[right];
            left++;
            right--;
        }

        return totalChemistry;
    }
}