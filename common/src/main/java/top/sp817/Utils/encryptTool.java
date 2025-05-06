package top.sp817.Utils;

import cn.hutool.crypto.SecureUtil;


public class encryptTool {

    public static String encodeRC4(String str, String key) {
        return SecureUtil.rc4(key).encryptBase64(str);
    }

    public static String decodeRC4(String str, String key) {
        return SecureUtil.rc4(key).decrypt(str);
    }

}
