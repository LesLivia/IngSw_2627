package warm_up;

import java.util.ArrayList;
import java.util.List;

public class Step2 {
    public static void main(String[] args) {
        int[] numeri = {1, 2, 3, 4, 5};
        int[] numeri2;
        numeri2 = new int[5];
        for (int i = 0; i < numeri.length; i++)
            System.out.println(numeri[i]);

        List<Integer> numeri3 = new ArrayList<>();
        for (int i = 0; i < numeri.length; i++)
            numeri3.add(numeri[i]);

        for (int n: numeri)
            System.out.println(n);
    }
}
