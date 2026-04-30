package com.wompi.test.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Environment {

    private static final String ENV_PREFIX = "WOMPI_";
    private static final Map<String, String> dotEnvProperties = new HashMap<>();

    static {
        loadDotEnv();
    }

    private Environment() {
    }

    public static String getPublicKey() {
        return getRequiredVar("PUBLIC_KEY");
    }

    public static String getPrivateKey() {
        return getRequiredVar("PRIVATE_KEY");
    }

    public static String getIntegrityKey() {
        return getRequiredVar("INTEGRITY_KEY");
    }

    public static String getEventKey() {
        return getRequiredVar("EVENT_KEY");
    }

    public static Map<String, String> getCredentials() {
        return Map.of(
                "public_key", getPublicKey(),
                "private_key", getPrivateKey(),
                "integrity", getIntegrityKey(),
                "event", getEventKey()
        );
    }

    private static String getRequiredVar(String key) {
        String fullKey = ENV_PREFIX + key;
        String value = System.getenv(fullKey);
        if (value == null || value.isBlank()) {
            value = dotEnvProperties.get(fullKey);
        }
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Variable requerida no encontrada: " + fullKey
                            + ". Configúrala como variable de entorno o en el archivo .env");
        }
        return value;
    }

    private static void loadDotEnv() {
        Path envFile = Path.of(".env");
        if (!Files.exists(envFile)) {
            return;
        }
        try {
            Files.readAllLines(envFile).stream()
                    .filter(line -> !line.isBlank() && !line.startsWith("#") && line.contains("="))
                    .forEach(line -> {
                        int separator = line.indexOf('=');
                        String envKey = line.substring(0, separator).trim();
                        String envValue = line.substring(separator + 1).trim();
                        dotEnvProperties.put(envKey, envValue);
                    });
        } catch (IOException e) {
            throw new IllegalStateException("Error leyendo archivo .env", e);
        }
    }
}
