package parallelism;

import java.util.Arrays;

/**
 * Created by Mezentsev.Y on 5/10/2016.
 */
public class ArraysDemo {
    public static void main(String[] args) {
        imperativeInitialize(10);
        parallelInitialize(10);
        parallelPrefixDemo();
    }

    /*1*/
    public static double[] imperativeInitialize(int size) {
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++)
            values[i] = i;
        return values;
    }

    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    /*2*/
    public static void parallelPrefixDemo(){
        int[] values = {1,2,3,4,5,6,7,8,9};
        Arrays.parallelPrefix(values, (fst, sec)-> fst + sec);
    }

}
