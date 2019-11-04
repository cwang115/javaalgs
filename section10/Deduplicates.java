package section10;

/**
 * sb.length()
 *
 *
 */


public class Deduplicates {
    public String removeDuplicates(String S){
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char ch : S.toCharArray()){
            if(sbLength !=0 && ch == sb.charAt(sbLength - 1)){
                sb.deleteCharAt(sb.length() -1);
                sbLength--;
            }else{
                sb.append(ch);
                sbLength++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
       Deduplicates solution = new Deduplicates();
       String s = "abbacddce";
       String result = solution.removeDuplicates(s);
       System.out.printf(result);
    }
}
