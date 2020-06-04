package cn.edu.lingnan.controller;

import cn.edu.lingnan.rsa.GenerateRSAKeys;
import cn.edu.lingnan.rsa.RSA;
import cn.edu.lingnan.utils.FileIO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @PROGRAM: rsa_system
 * @PACKAGE_NAME: cn.edu.lingnan.controller
 * @DESCRIPTION rsa
 * @Author wzj
 * @create: 2020-06-03 10:32
 **/
@RestController
public class RSAController {
    @RequestMapping("/encrypt/{message}")
    public String encrypt(@PathVariable String message) throws IOException {
        GenerateRSAKeys Claves = new GenerateRSAKeys(30);
        BigInteger e = Claves.getE();
        BigInteger d = Claves.getD();
        BigInteger n = Claves.getN();
        System.out.println("e=\t"+e);
        System.out.println("d=\t"+d);
        System.out.println("n=\t"+n);
        String encryptString = RSA.encryptString(message, e, n);
        System.out.println("明文 : " + message);
        System.out.println("密文: " + encryptString );
        String str = "d="+d+"\n"+"n="+n+"\n"+"密文="+encryptString;
        new FileIO().writeFile(str);
        return encryptString;
    }
    @RequestMapping("/decrypt/{message}/{n}/{d}")
    public String decrypt(@PathVariable String message,@PathVariable BigInteger n, @PathVariable BigInteger d){
        String decryptString = RSA.decryptString(message, d, n);
        System.out.println("密文解密 : " + decryptString);
        return decryptString;
    }

}
