import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws MonthCheckingException {
        String str = "You Only Live Once. But if You do it right. once is Enough";
        NoOfUpperCase(str); //bài 1.a
        System.out.println(capitalize(str)); //Bài 1.b
        InputPassWord(); //bài 2
        //bài 3
       {
            System.out.println("Bài 3.");
            System.out.println("Nhập tháng: ");
            try {
                int t = (new Scanner(System.in)).nextInt();
                bai3 check = new bai3();
                check.CheckMonth(t);
                if (t<1 || 12<t) throw new ArithmeticException("Không phải tháng.");
            }catch(InputMismatchException ex1){
                throw new MonthCheckingException("Tháng phải nhập số vào. ");
            }
        }

    }


    public static void NoOfUpperCase(String str){

        char ch;
        int chuthuong=0,chuhoa=0;
        for(int i=0;i<str.length();i++)
        {
            ch = str.charAt(i);
            int asciivalue = (int)ch;
            if(asciivalue >=65 && asciivalue <=90){
                chuhoa++;
            }
            else if(asciivalue >=97 && asciivalue <=122){
                chuthuong++;
            }
        }
        System.out.println("Số chữ cái thường : " + chuthuong);
        System.out.println("Số chữ cái hoa : " + chuhoa);
    }
    public static String capitalize(String string) {
        final int sl = string.length();
        final StringBuilder sb = new StringBuilder(sl);
        boolean lod = false;
        for(int s = 0; s < sl; s++) {
            final int cp = string.codePointAt(s);
            sb.appendCodePoint(lod ? Character.toLowerCase(cp) : Character.toUpperCase(cp));
            lod = Character.isLetterOrDigit(cp);
            if(!Character.isBmpCodePoint(cp)) s++;
        }
        return sb.toString();
    }
    public static void InputPassWord(){
        Scanner scanner = new Scanner(System.in);
        String password = "";
        boolean check = false;
        Pattern letter = Pattern.compile("[A-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        while (check == false) {
            System.out.print("Nhập mật khẩu muốn tạo: ");
            password = scanner.nextLine();
            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);
            if (password.length() < 10) {
                System.out.println("Mật khẩu yếu, vui lòng tạo mật khẩu khác");
            } else if (hasLetter.find() == false || hasDigit.find() == false || hasSpecial.find() == false) {
                System.out.println("Mật khẩu chưa đủ đủ mạnh, vui lòng tạo mật khẩu khác");
            } else check = true;
        }
        System.out.println("Tạo mật khẩu thành công!");
    }





}
