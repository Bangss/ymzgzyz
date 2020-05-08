package com.lingnan.ymzgzyz.common.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;
import java.util.UUID;

/**
 * @author Ponking
 * @ClassName MD5Util
 * @date 2020/3/28--19:18
 **/
public class MD5Util {
    /**
     * 散列次数
     */
    private static final int count = 1024;

    /**
     * 内置salt
     */
    private static final String PUBLIC_SALT = "958AEF84DB49419689159022A74D547E";

    /**
     * md5加密工具类
     * @param source 要用共盐加密的字符串
     * @return
     */
    private static String md5_public_salt(String source) {
        return new Md5Hash(source, PUBLIC_SALT, count).toString();
    }

    /**
     *
     * @param source 原始密码
     * @param salt 私盐
     * @return
     */
    public static String md5(String source,String salt) {
        //1.先用共盐对原始密码加密 md5_public_salt(source)
        //2.再对加密的后密文用私盐加密一次
        return new Md5Hash(md5_public_salt(source), salt, count).toString();
    }

    /**
     * salt:bf1e459bfd44427b863cbf00b8a2db95
     * pwd-md5:a23c64a3da4a79dec5c22276e393e9cb
     * @param args
     */
    public static void main(String[] args) {
        String mySalt = UUID.randomUUID().toString().replace("-","").toLowerCase();
        System.out.println("salt:"+mySalt);
        String pwd = md5("123456",mySalt);
        System.out.println("pwd-md5:"+pwd);
    }
}
