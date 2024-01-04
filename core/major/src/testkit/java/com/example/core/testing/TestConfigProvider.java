package com.example.core.testing;

import io.vertx.core.json.JsonObject;
import java.util.function.Function;

/**
 * Provides configuration to a test run.
 */
@FunctionalInterface
public interface TestConfigProvider extends Function<JsonObject, JsonObject> {
}
