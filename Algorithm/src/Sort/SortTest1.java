package Sort;

import java.util.Arrays;

public class SortTest1 {
    public static void main(String[] args) {

        String [] str = {"1","2","3","4","5"};
        String [] result = {"A","B","C","D","E"};

        System.arraycopy(result,0,str,3,result.length-3);
        System.out.println(Arrays.toString(str));

    }
}
