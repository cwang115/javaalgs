package section11;

public class ChangeTest {

    public static void main(String[] args){
//        Simple originalSimple = new Simple(5);
//        changeSimpleValue1(originalSimple);
//        System.out.println(originalSimple.value);

//        Simple originalSimple = new Simple(5);
//        changeSimpleValue2(originalSimple);
//        System.out.println(originalSimple.value);

        Simple originalSimple = new Simple(5);
        originalSimple = changeSimpleValue3(originalSimple);
        System.out.println(originalSimple.value);





    }

    private static void changeIntValue(int x){
        x = 10;
    }

    private static void changeSimpleValue1(Simple simple){
        Simple newSimple = new Simple(10);
        simple = newSimple;
    }

    private static Simple changeSimpleValue3(Simple simple){
        Simple newSimple = new Simple(10);
        return newSimple;
    }

    private static void changeSimpleValue2(Simple simple){
        simple.value = 10;
    }
}
