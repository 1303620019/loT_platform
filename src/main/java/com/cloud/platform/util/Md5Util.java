package com.cloud.platform.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
* 功能描述: <br>  MD5加密网站：https://www.zxgj.cn/g/md5
 * 解密网站：https://www.somd5.com/
* 〈Md5工具类〉
* @Param:
* @Return:
* @Author: byl
* @Date:
*/
public class Md5Util {
    /**
     * 16进制字符
     */
    static String[] chars = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * 将普通字符串用md5加密，并转化为16进制字符串
     * @param str
     * @return
     */
    public static String StringInMd5(String str) {

        // 消息签名（摘要）
        MessageDigest md5 = null;
        try {
            // 参数代表的是算法名称
            md5 = MessageDigest.getInstance("md5");
            byte[] result = md5.digest(str.getBytes());

            StringBuilder sb = new StringBuilder(32);
            // 将结果转为16进制字符  0~9 A~F
            for (int i = 0; i < result.length; i++) {
                // 一个字节对应两个字符
                byte x = result[i];
                // 取得高位
                int h = 0x0f & (x >>> 4);
                // 取得低位
                int l = 0x0f & x;
                sb.append(chars[h]).append(chars[l]);
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int max=100,min=1;
        long randomNum = System.currentTimeMillis();
        int ran3 = (int) (randomNum%(max-min)+min);

        String str = Md5Util.StringInMd5(ran3+"");
        System.out.println(str);
    }
}

