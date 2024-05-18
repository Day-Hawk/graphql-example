package dev.dotspace.dayhawk.exception;

public final class NoDataPresentException extends AbstractDataException {
  public NoDataPresentException() {
  }

  public NoDataPresentException(String message) {
    super(message);
  }

  public NoDataPresentException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoDataPresentException(Throwable cause) {
    super(cause);
  }

  public NoDataPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
