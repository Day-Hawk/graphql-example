package dev.dotspace.dayhawk.graphql;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import dev.dotspace.dayhawk.exception.DataAlreadyPresentException;
import dev.dotspace.dayhawk.exception.NoDataPresentException;
import org.jetbrains.annotations.NotNull;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public final class ErrorController {

  @GraphQlExceptionHandler(NoDataPresentException.class)
  private GraphQLError cryptExceptionHandler(@NotNull final NoDataPresentException exception,
                                             @NotNull final DataFetchingEnvironment dataFetchingEnvironment) {
    return this.error(exception.getMessage(), ErrorType.BAD_REQUEST, dataFetchingEnvironment);
  }

  @GraphQlExceptionHandler(DataAlreadyPresentException.class)
  private GraphQLError cryptExceptionHandler(@NotNull final DataAlreadyPresentException exception,
                                             @NotNull final DataFetchingEnvironment dataFetchingEnvironment) {
    return this.error(exception.getMessage(), ErrorType.NOT_FOUND, dataFetchingEnvironment);
  }

  private @NotNull GraphQLError error(@NotNull final String message,
                                      @NotNull final ErrorClassification errorType,
                                      @NotNull final DataFetchingEnvironment dataFetchingEnvironment) {
    return GraphqlErrorBuilder.newError()
        .errorType(errorType)
        .message(message)
        .path(dataFetchingEnvironment.getExecutionStepInfo().getPath())
        .location(dataFetchingEnvironment.getField().getSourceLocation())
        .build();
  }


}
