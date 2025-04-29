package com.alok.blockchain;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Block {
    public String previousHash;
    public String data;
    public long timeStamp;
    public String hash;
    public int index;
    public String formattedTimeStamp;
    public double temperature;  // IoT data

    public Block(int index, String data, String previousHash, double temperature) {
        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.formattedTimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timeStamp));
        this.temperature = temperature;
        this.hash = calculateHash();  // Calculate the hash using SHA-256
    }

    // Function to calculate SHA-256 hash
    public String calculateHash() {
        String input = previousHash + Long.toString(timeStamp) + data + index + temperature;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error calculating hash: " + e.getMessage());
        }
    }
}
