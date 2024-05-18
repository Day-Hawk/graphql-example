package dev.dotspace.dayhawk.exception;

public abstract class AbstractDataException extends Exception {

  public AbstractDataException() {
  }

  public AbstractDataException(String message) {
    super(message);
  }

  public AbstractDataException(String message, Throwable cause) {
    super(message, cause);
  }

  public AbstractDataException(Throwable cause) {
    super(cause);
  }

  public AbstractDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
