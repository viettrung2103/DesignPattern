package org.example;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;


// The Tiny Encryption Algorithm (TEA) operates on 64-bit (8-byte) blocks of data, not 32 bytes.
// This means that the input data must be a multiple of 8 bytes for the encryption and decryption processes to work correctly.
// If the input data is not a multiple of 8 bytes, padding is required to ensure the data conforms to the block size.
public class TinyEncryptionAlgorithm {
    private static final int DELTA = 0x9E3779B9;
    private static final int SUM_INIT = 0xC6EF3720;

    public static void encrypt(int[] v, int[] k) {
        int v0 = v[0], v1 = v[1], sum = 0;
        int k0 = k[0], k1 = k[1], k2 = k[2], k3 = k[3];
        for (int i = 0; i < 32; i++) {
            sum += DELTA;
            v0 += ((v1 << 4) + k0) ^ (v1 + sum) ^ ((v1 >> 5) + k1);
            v1 += ((v0 << 4) + k2) ^ (v0 + sum) ^ ((v0 >> 5) + k3);
        }
        v[0] = v0;
        v[1] = v1;
    }

    public static void decrypt(int[] v, int[] k) {
        int v0 = v[0], v1 = v[1], sum = SUM_INIT;
        int k0 = k[0], k1 = k[1], k2 = k[2], k3 = k[3];
        for (int i = 0; i < 32; i++) {
            v1 -= ((v0 << 4) + k2) ^ (v0 + sum) ^ ((v0 >> 5) + k3);
            v0 -= ((v1 << 4) + k0) ^ (v1 + sum) ^ ((v1 >> 5) + k1);
            sum -= DELTA;
        }
        v[0] = v0;
        v[1] = v1;
    }

    public static int[] stringToIntArray(String input) {
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        int length = (bytes.length + 7) / 8;
        int[] result = new int[length * 2];
        ByteBuffer buffer = ByteBuffer.allocate(8);
        for (int i = 0; i < length; i++) {
            buffer.clear();
            buffer.put(Arrays.copyOfRange(bytes, i * 8, Math.min((i + 1) * 8, bytes.length)));
            buffer.flip();
            result[i * 2] = buffer.getInt();
            result[i * 2 + 1] = buffer.remaining() >= 4 ? buffer.getInt() : 0;
        }
        return result;
    }

    public static String intArrayToString(int[] input) {
        ByteBuffer buffer = ByteBuffer.allocate(input.length * 4);
        for (int value : input) buffer.putInt(value);
        return new String(buffer.array(), StandardCharsets.UTF_8).trim();
    }

    public static String padString(String input) {
        int paddingLength = 8 - (input.length() % 8);
        char paddingChar = (char) paddingLength;
        return input + String.valueOf(paddingChar).repeat(paddingLength);
    }

    public static String unpadString(String input) {
        if (input == null || input.isEmpty()) return input;
        int paddingLength = input.charAt(input.length() - 1);
        if (paddingLength < 1 || paddingLength > 8) throw new IllegalArgumentException("Invalid padding length");
        return input.substring(0, input.length() - paddingLength);
    }

    public static byte[] intArrayToByteArray(int[] input) {
        ByteBuffer buffer = ByteBuffer.allocate(input.length * 4);
        for (int i : input) {
            buffer.putInt(i);
        }
        return buffer.array();
    }

    public static int[] byteArrayToIntArray(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        int[] result = new int[bytes.length / 4];
        for (int i = 0; i < result.length; i++) {
            result[i] = buffer.getInt();
        }
        return result;
    }

    public static String encodeToBase64(int[] input) {
        ByteBuffer buffer = ByteBuffer.allocate(input.length * 4);
        for (int value : input) buffer.putInt(value);
        return Base64.getEncoder().encodeToString(buffer.array());
    }

    public static int[] decodeFromBase64(String base64) {
        byte[] bytes = Base64.getDecoder().decode(base64);
        int[] result = new int[bytes.length / 4];
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        for (int i = 0; i < result.length; i++) result[i] = buffer.getInt();
        return result;
    }
}