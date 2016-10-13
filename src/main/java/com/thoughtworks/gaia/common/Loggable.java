package com.thoughtworks.gaia.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Loggable {
    default Logger getLogger() {
        return LoggerFactory.getLogger(this.getClass());
    }

    default void trace(String message, Throwable throwable) {
        getLogger().trace(message, throwable);
    }

    default void trace(String message) {
        getLogger().trace(message);
    }

    default void debug(String message, Throwable throwable) {
        getLogger().debug(message, throwable);
    }

    default void debug(String message) {
        getLogger().debug(message);
    }

    default void info(String message, Throwable throwable) {
        getLogger().info(message, throwable);
    }

    default void info(String message) {
        getLogger().info(message);
    }

    default void warn(String message, Throwable throwable) {
        getLogger().warn(message, throwable);
    }

    default void warn(String message) {
        getLogger().warn(message);
    }

    default void error(String message, Throwable throwable) {
        getLogger().error(message, throwable);
    }

    default void error(String message) {
        getLogger().error(message);
    }
}
