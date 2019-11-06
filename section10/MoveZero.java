package section10;

import java.util.Arrays;

public class MoveZero {
    public int[] moveZero(int[] array) {
        // Write your solution here

        //cc
        if(array.length <= 1){
            return array;
        }

        int i = 0;
        int j = array.length - 1;
        /**
         * 互斥关系只执行其中一种语句然后返回whileloop
         */
        while( i <= j){
            if( array[j] == 0 ){
                j--;
            }else if(array[i] != 0){
                i++;
            } else{
                swap(array, i++, j--);
            }





        }

        return array;


    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        MoveZero solution = new MoveZero();
        int[] array = new int[]{0,0, 1, 1, 0, 1, 0};
        int[] result = solution.moveZero(array);
        System.out.println(Arrays.toString(result));
    }
}
