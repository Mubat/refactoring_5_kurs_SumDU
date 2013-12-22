package education.sumdu.Fifth.kurs.Shopping.kernel.discount;

public class UnsupportedDiscountException extends Exception {

    public UnsupportedDiscountException() {
        super();
    }

    public UnsupportedDiscountException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UnsupportedDiscountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedDiscountException(String message) {
        super(message);
    }

    public UnsupportedDiscountException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = 1674381268614091865L;

}