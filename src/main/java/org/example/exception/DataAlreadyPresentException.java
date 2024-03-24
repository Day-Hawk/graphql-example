package org.example.exception;

public final class DataAlreadyPresentException extends AbstractDataException {
  public DataAlreadyPresentException() {
  }

  public DataAlreadyPresentException(String message) {
    super(message);
  }

  public DataAlreadyPresentException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataAlreadyPresentException(Throwable cause) {
    super(cause);
  }

  public DataAlreadyPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
