package cn.edu.lingnan.rsa;

import java.math.BigInteger;
import java.util.Random;

/**
 * @PROGRAM: rsa_system
 * @PACKAGE_NAME: cn.edu.lingnan.rsa
 * @DESCRIPTION 判断素数
 * @Author wzj
 * @create: 2020-06-02 22:13
 **/
public class PrimeNum {
    /**
     * 生成一个bits长度的素数
     * @param bits
     * @return
     */
    public static BigInteger generatePrime(int bits) {
        BigInteger prime;
        //随机生成数，是素数就返回，不是则继续随机生成
        do
            //certainty 代表是素数的概率，越大是素数的概率越小  1-1/2^certainty
            //bitLength 代表bit长度
            //比如本例输入bits为31，输出为1277067929,二进制表示为1001100000111101000001010011001
            //如输入bits为5，最大为25，二进制为11001
            prime = new BigInteger(bits, 10, new Random());
        while(!PrimeNum.isPrime(prime));
        return prime;
    }

    /**
     * 判断是否素数
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        if(n == 2) return true;
        else if(n % 2 == 0) return false;

        for(int i = 3; i*i <= n; i+=2)
            if(n % i == 0) return false;
        return true;
    }

    /**
     * 判断是否素数,重载方法
     * @param n
     * @return
     */
    public static boolean isPrime(BigInteger n) {
        long aux = n.longValue();
        if(aux == 2) return true;
        else if(aux % 2 == 0) return false;

        for(int i = 3; i*i <= aux; i+=2)
            if(aux % i == 0) return false;
        return true;
    }
}
