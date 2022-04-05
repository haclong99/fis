package vn.fis.finaltestaphuoc.exception;

public class DetectiveNotFoundException extends RuntimeException{
    private String message;
    public DetectiveNotFoundException(String detective, String message, Long id) {
        super(message);
        this.message = message;
    }
}
