package suanfageBit;

public class singleNumberII {

    public static void main(String[] args){
        int[] array = new int[]{3, 3, 0,  1};
        int res = 0;
        for(int i = 0; i < 4; i++){
            res +=1 << i;
        }

        int m = 0;
        m += 1 << 3;
        System.out.println(m);

    }
}
