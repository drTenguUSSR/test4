package mil.teng.jmh;

/**
 * @author DrTengu, 2024/06
 */
public class LongFormat {
    public static void main(String[] args) {
        checkLong(0xFFFFFFFF);
        checkLong(0xAFFFFFFF);
        checkLong(0x80000000);
        checkLong(0x7FFFFFFF);
        checkLong(0x1FFFFFFF);
        checkLong(0x0FFFFFFF);
    }

    private static void checkLong(long datA) {
        String strA = Long.toString(datA, 16).toUpperCase();
        xlog("checkLong: datA="+datA+" strA="+strA);
    }

    private static void xlog(String... msg) {
        System.out.println(String.join("", msg));
    }
}
