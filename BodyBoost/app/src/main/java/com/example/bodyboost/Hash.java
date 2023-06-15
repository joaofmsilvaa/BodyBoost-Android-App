package com.example.bodyboost;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static String hashPassword(String password) {
        try {
            // Create an instance of the SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convert the password string to bytes
            byte[] passwordBytes = password.getBytes();

            // Compute the hash of the password bytes
            byte[] hashedBytes = digest.digest(passwordBytes);

            // Convert the hashed bytes to a hexadecimal representation
            StringBuilder builder = new StringBuilder();
            for (byte b : hashedBytes) {
                builder.append(String.format("%02x", b));
            }

            // Return the hashed password as a string
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null; // Return null if an error occurs
    }
}
