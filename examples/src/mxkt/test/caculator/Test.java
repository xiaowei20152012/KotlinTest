package mxkt.test.caculator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Test {

    public static void main(String[] args) {

        int a = 60; /* 60 = 0011 1100 */

        int b = 13; /* 13 = 0000 1101 */

        int c;

        /*位与操作符，当且仅当两个操作数的某一位都非0时，结果位才为1*/
        /* 0000 1100 = 12 */
        c = a & b;
        System.out.println("a & b = " + c);

        /* 位或操作符，只要两个操作数的某一个位置是非0，就为1 */
        /* 0011 1101 = 1 + 4 + 8 + 16 +32 = 61 */
        c = a | b;
        System.out.println("a | b = " + c);



    }

    @interface ClickType {
        int ITEM_CLICK = 1;
        int MENU_CLICK = 2;
        int LONG_CLICK = 3;
    }





}
