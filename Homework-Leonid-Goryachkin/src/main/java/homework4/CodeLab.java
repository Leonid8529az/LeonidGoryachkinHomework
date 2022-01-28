package homework4;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class CodeLab {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int k = 0;
        int temp = 0;
        for (k = 0; k<a.length; k++) {
            temp = a[k];
            a[k] = a[a.length-1-k];
            a[a.length-1-k] = temp;

        }
        for (int i = 0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
