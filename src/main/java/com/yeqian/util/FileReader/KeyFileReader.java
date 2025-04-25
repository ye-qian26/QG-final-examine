package com.yeqian.util.FileReader;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class KeyFileReader {
    private static final String PRIVATE_FILE_PATH = "private_key.pem";
    private static final String PUBLIC_FILE_PATH = "public_key.pem";

    /**
     * 从文件中 读取 私钥
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String readPrivateKeyFromFile(String encryptedText) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        StringBuilder privateKeyPEM = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(PRIVATE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("-----")) {
                    privateKeyPEM.append(line);
                }
            }
        }
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPEM.toString());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //得到私钥
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        try {
            //创建 Cipher 对象，使用 RSA 算法进行解密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            //将 Base64 编码的加密文本转换为字节数组
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
            //执行解密操作
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            //将解密后的字节数组转换为字符串
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从文件中 读取 公钥
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static PublicKey readPublicKeyFromFile() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        StringBuilder publicKeyPEM = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(PUBLIC_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("-----")) {
                    publicKeyPEM.append(line);
                }
            }
        }
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyPEM.toString());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}
