package com.example.demo.common;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 加盐加密类
 */
public class SecurityUtil {

    /**
     * 加盐加密
     *
     * @param password
     * @return
     */
    public static String encrypt(String password) {
        // 每次生成内容不同的，但长度固定 32 位的盐值
        String salt = UUID.randomUUID().toString().replace("-", "");
        // 最终密码=md5(盐值+原始密码)
        String finalPassword = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        return salt + finalPassword;
    }


    /**
     * 密码验证
     *
     * @param password      待验证密码
     * @param finalPassword 最终正确的密码（数据库中加盐的密码）
     * @return
     */
    public static boolean decrypt(String password, String finalPassword) {
        // 非空效验
        if (!StringUtils.hasLength(password) || !StringUtils.hasLength(finalPassword)) {
            return false;
        }
        if (finalPassword.length() != 64) { // 最终密码不正确
            return false;
        }
        // 盐值
        String salt = finalPassword.substring(0, 32);
        // 使用盐值+待确认的密码生成一个最终密码
        String securityPassword =
                DigestUtils.md5DigestAsHex((salt + password).getBytes());
        // 使用盐值+最终的密码和数据库的真实密码进行对比
        return (salt + securityPassword).equals(finalPassword);
    }

    public static void main(String[] args) {
        String password = "123";
//        System.out.println(SecurityUtil.encrypt(password));
//        System.out.println(SecurityUtil.encrypt(password));
//        System.out.println(SecurityUtil.encrypt(password));

        System.out.println(SecurityUtil.decrypt(password, "a91d727d525541ad9eeeb81bb3a4e16605b01437722ea2e2bf7820f57a140e32"));
        System.out.println(SecurityUtil.decrypt(password, "cce66d765fd546a1934e3351959cc77c2aba7d7e158d57e0a8bd548097acf890"));
        System.out.println(SecurityUtil.decrypt(password, "05dd4fc0c02442eca56c0b064ad25ec50ceff9d989e3a6eb10cc51e6bcbcab10"));

    }

}
