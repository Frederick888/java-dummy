package com.example.starter;

import java.util.Optional;
import java.util.function.Function;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }

  public Future<String> mockServiceOne(Long accountId) {
    return Future.succeededFuture("{\"name\":\"mock account\"}");
  }

  public Future<String> mockServiceTwo(Long accountId) {
    return Future.succeededFuture("{\"active\":true}");
  }

  public Future<Void> handle(String stringAccountId) {
    try {
      final var accountId = Optional.ofNullable(stringAccountId).map(Long::parseLong).orElseThrow();

      final Function<String, Future<Void>> callback = (accountName) -> {
        return mockServiceTwo(accountId)
            .compose(accountStat -> {
              System.out.println(String.format("Status of Account %d is %s", accountId, accountStat));
              return Future.succeededFuture((Void) null);
            });
      };

      return mockServiceOne(accountId)
          .compose(accountName -> {
            return mockServiceTwo(accountId)
                .compose(accountStat -> {
                  System.out.println(String.format("Status of Account %d is %s", accountId, accountStat));
                  return Future.succeededFuture((Void) null);
                });
          });
    } catch (Exception e) {
      return Future.failedFuture(e);
    }
  }
}
