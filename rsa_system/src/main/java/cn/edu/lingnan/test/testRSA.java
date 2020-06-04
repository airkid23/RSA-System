package cn.edu.lingnan.test;

import cn.edu.lingnan.rsa.GenerateRSAKeys;
import cn.edu.lingnan.rsa.RSA;

import java.math.BigInteger;

/**
 * @PROGRAM: rsa_system
 * @PACKAGE_NAME: cn.edu.lingnan.test
 * @DESCRIPTION testRsa
 * @Author wzj
 * @create: 2020-06-03 11:38
 **/
public class testRSA {
    public static void main(String[] args) {
        //数字签名
        String message = "china0asfadsfaf";
//        GenerateRSAKeys Claves = new GenerateRSAKeys(30);
//        BigInteger e = Claves.getE();
//        BigInteger d = Claves.getD();
//        BigInteger n = Claves.getN();
//        System.out.println("e=\t"+e);
//        System.out.println("d=\t"+d);
//        System.out.println("n=\t"+n);
//        String encryptString = RSA.encryptString(message, e, n);
//        String decryptString = RSA.decryptString(encryptString, d, n);
//        System.out.println("明文 : " + message);
//        System.out.println("密文: " + encryptString );
//        System.out.println("密文解密 : " + decryptString);

        BigInteger e, d, n;
        e = new BigInteger("57190979");
        d = new BigInteger("203665264207907435");
        n = new BigInteger("367019959004588231");
        String eneryptString  = RSA.encryptString(message,d,n);
        System.out.println(eneryptString);
        String deeryptString = RSA.decryptString(eneryptString,e,n);
        System.out.println(deeryptString);
    }

}
