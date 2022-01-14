package com.cloud.platform.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
 
import org.apache.commons.codec.binary.Hex;
 
public class ImoocRSA {
    public static  RSAPublicKey rsaPublicKey;
    public static  RSAPrivateKey rsaPrivateKey;

    public static void main(String[] args) {
        ImoocRSA imoocRSA=new ImoocRSA();
        String s = imoocRSA.privateInit();
        Boolean aBoolean = imoocRSA.publicInit(s);
    }
    public ImoocRSA()  {
        try {
            //1.初始化密钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static  String privateInit(){
        try {
            int max = 100, min = 1;
            long randomNum = System.currentTimeMillis();
            int ran3 = (int) (randomNum % (max - min) + min);
            String src = ran3 + "";
            File file = new File("D:\\loT_platform\\src\\main\\resources\\static\\testFile_sign.txt");
            FileOutputStream fop= new FileOutputStream(file);
            //2.执行签名
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(privateKey);
            signature.update(src.getBytes());
            byte[] result = signature.sign();
            return  Hex.encodeHexString(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    public static Boolean publicInit(String privateKey) {
        try {
            //3.验证签名
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(publicKey);
            signature.update(privateKey.getBytes());
            boolean bool = signature.verify(signature.sign());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }
 
}