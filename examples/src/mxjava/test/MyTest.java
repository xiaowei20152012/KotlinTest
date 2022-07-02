package mxjava.test;

import java.util.zip.ZipOutputStream;

public class MyTest {
    public static void main(String[] args) {
        String name = "apkguar";
//        String variantName = name.indexOf("apkguard");
        int index = name.indexOf("apkguard") + 8;
        if (index != 8) {
            return;
        }
        String variantName = name.substring(index);
        variantName.equalsIgnoreCase("hello");
        System.out.println(variantName);

        for ( int i = 0 ;i < 10 ; i++) {
            if (i == 1) {
                break;
            }
            if (i == 2) {
                continue;
            }
        }
//        mx guard task init output apkguardNeon_market_v8Press, buildTypeName = press, currentName = neon_market_v8-press


    }
}
