package vn.fis.finaltestaphuoc.exception;

public class EvidenceNotFoundException extends RuntimeException{
    private String message;
    public EvidenceNotFoundException(String evidence, String message, Long id) {
        super(message);
        this.message = message;
    }
}
