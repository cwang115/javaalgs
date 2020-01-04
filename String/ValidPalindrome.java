package String;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        //cc

        //preprocessing
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

        //find a center and spread from there
        for(int i = 0; i< s.length(); i++){

        }
        return false;
    }

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
//        s = s.toLowerCase();
//        System.out.println(s);
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        System.out.println(s);
    }
}
