package com.example.core.testing;

import com.example.core.FutureSupplier;
import com.example.core.testing.TestConfigProvider;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

class ExampleTestConfigProvider implements TestConfigProvider {

  @Override
  public JsonObject apply(JsonObject context) {
    final var supplier = new FutureSupplier() {
      @Override
      public Future<JsonObject> get() {
        return Future.succeededFuture(new JsonObject());
      }
    };
    return new JsonObject();
  }
}
