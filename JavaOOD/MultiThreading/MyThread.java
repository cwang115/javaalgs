package JavaOOD.MultiThreading;

public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("haha");
    }


    public static void main(String[] args) {
        //for loop
        for(int i = 0; i <10; i++){
            Thread myThread = new MyThread();
            myThread.start();
            System.out.println("xixi");
        }

    }
}
