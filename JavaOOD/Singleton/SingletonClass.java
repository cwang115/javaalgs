package JavaOOD.Singleton;

public class SingletonClass {
    private static SingletonClass instance;
    private SingletonClass(){


    }

    public static SingletonClass getInstance(){
        //vvery very important lazy initialization
    
            if(instance == null){
                instance = new SingletonClass();
            }

            return instance;


    }
//field and method only apply to class level
    //can't initialize twice

    //

}


