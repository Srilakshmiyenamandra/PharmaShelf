package com.microservices.demo.exception;

/**
 * Exception thrown for Configuration and System Setup issues.
 * Examples: Invalid system configuration, missing required settings,
 * invalid storage location setup, etc.
 */
public class ConfigurationException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public ConfigurationException(String configName, String reason) {
        super("CONFIG_ERR", "Configuration error for " + configName + ": " + reason);
    }

    public ConfigurationException(String message) {
        super("CONFIG_ERR", message);
    }
}
