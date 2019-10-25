package section9;

public class toHex {
   public String toHex(int n){

     char[] hexSymbol = new char[]{'0', '1', '2', '3', '4', '5', '6','7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
     String result = "";
     while(n != 0){
         result += hexSymbol[n % 16];
         n = n / 16;
     }

     result = reverse(result);
     return  result;

   };

   private String reverse(String s){

       String result = "";
       for(int i = s.length() - 1; i>= 0; i++){
           result += s.charAt(i);
       }

       return result;
   }
}
