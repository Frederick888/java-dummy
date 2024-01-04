package com.example.core;

import io.vertx.core.Future;
import java.util.function.Supplier;

@FunctionalInterface
public interface FutureSupplier<T> extends Supplier<Future<T>> {

  /**
   * Supplies a Future. Execution of the future must be side-effect free.
   *
   * @return a new {@link Future}
   */
  @Override
  Future<T> get();
}
