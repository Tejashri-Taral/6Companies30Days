class Solution {
    
    public void rec(int i,String str,String curr,ArrayList<String>ans,int n,ArrayList<String>mp)
    {
        if(i==n)
        {
            ans.add(curr);
            return;
        }
        
        int val=str.charAt(i)-'2';
        String pad=mp.get(val);
        for(int j=0;j<pad.length();j++)
        {
            rec(i+1,str,curr+pad.charAt(j),ans,n,mp);
        }
        
    }
    public List<String> letterCombinations(String digit) {
        ArrayList<String>ans=new ArrayList<>();
        if(digit.isEmpty()) {
            return ans;
        }
        String curr="";
        int n=digit.length();
        ArrayList<String>mp=new ArrayList<>(8);
        mp.add("abc");//1
        mp.add("def");//2
        mp.add("ghi");
        mp.add("jkl");
        mp.add("mno");
        mp.add("pqrs");
        mp.add("tuv");
        mp.add("wxyz");
        
        int i=0;
        
        rec(i,digit,curr,ans,n,mp);
        return ans;
    }
}
