package com.yeqian.controller.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

/**
 * 获取 公钥 和 私钥
 */
@WebServlet("/keyGeneratorServlet/*")
public class KeyGeneratorServlet extends BaseServlet {

    /**
     * 获取 密钥对
     * @param req
     * @param resp
     * @throws Exception
     */
    public void getPublicKey(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        try {
            // 生成密钥对
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // 存储私钥
            byte[] privateKeyBytes = privateKey.getEncoded();
            String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKeyBytes);
            try (FileWriter privateWriter = new FileWriter("private_key.pem")) {
                privateWriter.write("-----BEGIN PRIVATE KEY-----\n");
                privateWriter.write(privateKeyBase64);
                privateWriter.write("\n-----END PRIVATE KEY-----");
            }

            // 存储公钥
            byte[] publicKeyBytes = publicKey.getEncoded();
            String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKeyBytes);
            try (FileWriter publicWriter = new FileWriter("public_key.pem")) {
                publicWriter.write("-----BEGIN PUBLIC KEY-----\n");
                publicWriter.write(publicKeyBase64);
                publicWriter.write("\n-----END PUBLIC KEY-----");
            }
            //响应数据
            resp.setContentType("text/plain");
            resp.getWriter().write(publicKeyBase64);

            System.out.println("公钥和私钥已成功存储。");
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }



}
