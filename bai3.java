public class bai3 {
    static void CheckMonth(int t) {
        if (t == 1 || t == 3 || t == 5 || t == 7 || t == 8 || t == 10 || t == 12) {
            System.out.println("31 ngày");
        } else if (t == 4 || t == 6 || t == 9 || t == 11) {
            System.out.println("30 ngày");
        } else if (t == 2) {
            System.out.println("28 hoặc 29 ngày");
        }
    }
}