package vn.fis.finaltestaphuoc.exception;

public class CriminalCaseNotFoundException extends RuntimeException{
    private String message;
    public CriminalCaseNotFoundException(String criminalCase,String message, Long id) {
        super(message);
        this.message = message;
    }
}
