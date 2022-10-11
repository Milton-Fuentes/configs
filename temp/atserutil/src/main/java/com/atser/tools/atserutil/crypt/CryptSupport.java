/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.crypt;

import com.atser.tools.atserutil.date.DateSupport;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author droldan
 */
public class CryptSupport {

    private static final String JWT_ALGORITHM = "AES";

    private static final int SALT_SIZE = 32;
    private static final int KEY_LENGTH = 512;
    private static final int ITERATIONS = 1000;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

    public static String cryptHMACSHA256(String msg, String key) {
        Mac sha256_HMAC;
        try {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(msg.getBytes()));
            return hash;
        } catch (NoSuchAlgorithmException | InvalidKeyException ex) {
            Logger.getLogger(CryptSupport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static String cryptData(String userid, String sessionid, String pkey) {
        String message = userid + "." + sessionid;
        String roll1 = cryptHMACSHA256(message, pkey);
        String roll2 = cryptHMACSHA256(roll1 + "." + DateSupport.FORMAT_CRYPTTIME.format(new Date()), "secret");
        return roll2;
    }

    /**
     * This method will hash the password and salt combination. Be careful, this
     * method will erase the password after hashed it. You must be sure that you
     * do not need it after using this method.
     *
     * @param password the password who needs to be hashed
     * @param salt some list of <code>byte</code> which will be included in the
     * password
     * @return a hash of the password and salting combination.
     */
    public static byte[] hash(char[] password, byte[] salt) {
        final PBEKeySpec spec = new PBEKeySpec(password, salt, CryptSupport.ITERATIONS, CryptSupport.KEY_LENGTH);

        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(CryptSupport.ALGORITHM);
            SecretKey key = secretKeyFactory.generateSecret(spec);
            return key.getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new SecurityException(e);
        } finally {
            // erase the password in the char array in order to not retrieve it in the java memory
            spec.clearPassword();
        }
    }

    /**
     * @return a random salt
     */
    public static byte[] generateSalt() {
        final Random r = new SecureRandom();
        byte[] salt = new byte[CryptSupport.SALT_SIZE];
        r.nextBytes(salt);
        return salt;
    }

    /**
     * @return a random key with 256 characters
     */
    public static byte[] generateSecret() {
        KeyGenerator keyGenerator;
        try {
            keyGenerator = KeyGenerator.getInstance(JWT_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            return new byte[]{};
        }
        keyGenerator.init(256);
        return keyGenerator.generateKey().getEncoded();
    }

    /**
     * This method will check the given password and compare it with the one
     * stored in the database. Be careful, this method will erase the password
     * passed in parameter, after tested it. You must be sure that you do not
     * need it after using this method.
     *
     * @param password the password to be tested
     * @param salt the salt previously retrieve in the database
     * @param expectedHash the password expected after applying the
     * {@link SecurityUtils#hash(char[], byte[]) hashing method}
     * @return <code>true</code> if the password passed in parameter matched the
     * hashing password stored in the database. <code>false</code> if not.
     */
    public static boolean isExpectedPassword(char[] password, byte[] salt, byte[] expectedHash) {
        if (password == null) {
            return false;
        }
        final byte[] pwdHash = CryptSupport.hash(password, salt);
        final int length = pwdHash.length;

        // erase the password in the char array in order to not retrieve it in the java memory
        Arrays.fill(password, Character.MIN_VALUE);

        if (length != expectedHash.length) {
            return false;
        }

        int i = 0;
        boolean result = true;

        while ((i < length) && result) {
            result = pwdHash[i] == expectedHash[i];
            i++;
        }

        return result;
    }
}
