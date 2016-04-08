package example1;

/**
 * Created by Mezentsev.Y on 3/29/2016.
 */
public class Ex1App {
    public static void main(String[] args) {
        int i=0;
/////////////////////////
        FunctionalI functionalI = () -> {
            System.out.println("Hi");
            System.out.println("dev");
        };
        FunctionalI functionalI2 = () -> System.out.println("yyy");
        functionalI.doSome();
        functionalI2.doSome();
/////////////////////////
        FunctionalWithParameter functionalWithParameter = someName -> System.out.println("functionalWithParameter" + someName);
        FunctionalWithParameter functionalWithParameter2 = someName -> {
            System.out.println("functionalWithParameter2" + someName);
           // i=3;
            System.out.println("functionalWithParameter2" +i);
        };
        functionalWithParameter.doSome("hello");
        functionalWithParameter2.doSome("hello2");
        /////////////////////////

        FunctionalWithTwoParameters functionalWithTwoParameters = (s1,s2) ->{
            System.out.println(s1 + s2);
        };
        functionalWithTwoParameters.doSome("1","2");

    }
}
