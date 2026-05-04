package com.wompi.test.config;

public enum WompiEndpoint {

    MERCHANTS("/merchants/{publicKey}"),
    TRANSACTIONS("/transactions");

    private final String path;

    WompiEndpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String withParam(String paramName, String value) {
        return path.replace("{" + paramName + "}", value);
    }
}
