package dev.ag6.passwordmanager.util;

import org.mindrot.jbcrypt.BCrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public final class CryptoUtils {
    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    public static boolean checkInputVStored(String passInPlain, String storedHash) {
        return BCrypt.checkpw(passInPlain, storedHash);
    }

    public static String encryptDataAES(String toEncrypt, String password) {
        try {
            Cipher cipher = generateAESCipher(password, Cipher.ENCRYPT_MODE);

            return Base64.getEncoder().encodeToString(cipher.doFinal(toEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e);
        }
        return null;
    }

    public static String decryptDataAES(String encryptedData, String password) {
        try {
            Cipher cipher = generateAESCipher(password, Cipher.DECRYPT_MODE);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
        } catch (Exception e) {
            System.out.println("Error while decoding: " + e);
        }
        return null;
    }

    public static Cipher generateAESCipher(String password, int mode) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(password.toCharArray());
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec key = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(mode, key, ivspec);
        } catch (Exception e) {
            System.out.println("Error while generating cipher: " + e);
        }
        return null;
    }

    private CryptoUtils() {
    }
}
