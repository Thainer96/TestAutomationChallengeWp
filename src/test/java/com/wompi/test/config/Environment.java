package com.wompi.test.config;

import java.util.Map;

public class Environment {

    private static final String ENV_PREFIX = "WOMPI_";

    private Environment() {
    }

    public static String getPublicKey() {
        return getRequiredEnvVar("PUBLIC_KEY");
    }

    public static String getPrivateKey() {
        return getRequiredEnvVar("PRIVATE_KEY");
    }

    public static String getIntegrityKey() {
        return getRequiredEnvVar("INTEGRITY_KEY");
    }

    public static String getEventKey() {
        return getRequiredEnvVar("EVENT_KEY");
    }

    public static Map<String, String> getCredentials() {
        return Map.of(
                "public_key", getPublicKey(),
                "private_key", getPrivateKey(),
                "integrity", getIntegrityKey(),
                "event", getEventKey()
        );
    }

    private static String getRequiredEnvVar(String key) {
        String value = System.getenv(ENV_PREFIX + key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Variable de entorno requerida no encontrada: " + ENV_PREFIX + key
                            + ". Configúrala antes de ejecutar los tests.");
        }
        return value;
    }
}
