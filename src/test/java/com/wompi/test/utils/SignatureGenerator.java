package com.wompi.test.utils;

import com.wompi.test.config.Environment;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class SignatureGenerator {

    private SignatureGenerator() {
    }

    public static String generate(Map<String, String> data) {
        String reference = data.getOrDefault("reference", "");
        String amountInCents = data.getOrDefault("amount_in_cents", "");
        String currency = data.getOrDefault("currency", "");
        String integrity = Environment.getIntegrityKey();

        String input = reference + amountInCents + currency + integrity;
        return sha256(input);
    }

    private static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
