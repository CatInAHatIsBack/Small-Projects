public class Substring {

    public static int lengthOfLongestSubstring(String s) {
        String temp = "";
        int max = 0;
        for (char c : s.toCharArray()) {
            if(temp.contains(String.valueOf(c))){
                temp = temp.substring(temp.indexOf(c)+1);
            }
            temp += c;
            if(temp.length() > max){
                max = temp.length();
            }
        }
        return max; 
    }
    public static void main(String[] args) {
        String str = "pwwkew";
        int a = lengthOfLongestSubstring(str);
        System.out.println(a);
    }

}
