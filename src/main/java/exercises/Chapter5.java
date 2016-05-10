package exercises;

/**
 * Created by Mezentsev.Y on 5/4/2016.
 */
public class Chapter5 {
    public static void main(String[] args) {
        /*1*/
        int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        int s = sum(nums,n-> n>0);
        s = sum(nums,n->ExpressionHelper.isPositive(n));
        s = sum(nums,ExpressionHelper::isPositive);

        /*2*/
        UserBuilder userBuilder = name -> new User(name);
        User user1 = userBuilder.create("user1");

        UserBuilder userBuilder2 = User::new;
        User user2 = userBuilder2.create("user1");


    }




    private static int sum (int[] numbers, Expression func)
    {
        int result = 0;
        for(int i : numbers)
        {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }
}


class ExpressionHelper{

    static boolean isEven(int n){
        return n%2 == 0;
    }

    static boolean isPositive(int n){
        return n > 0;
    }
}

interface Expression{
    boolean isEqual(int n);
}