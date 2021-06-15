public class  MonthCheckingException extends Exception {
    public MonthCheckingException(String message) {
        super(message);
    }
    @Override
    public  String getMessage(){
        return "Lỗi nhập vào 1 tháng: " + super.getMessage();
    }
}