class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    void combination(List<List<Integer>> ans, List<Integer> combo, int k, int start, int n) {
        if (combo.size() == k && n == 0) {
            List<Integer> list = new ArrayList<>(combo);
            ans.add(list);
            return;
        }
        for (int i = start; i <= 9; i++) {
            combo.add(i);
            combination(ans, combo, k, i + 1, n - i);
            combo.remove(combo.size() - 1);
        }
    }
}
