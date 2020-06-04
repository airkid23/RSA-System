package cn.edu.lingnan.rsa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Random;

/**
 * @PROGRAM: rsa_system
 * @PACKAGE_NAME: cn.edu.lingnan.rsa
 * @DESCRIPTION 获取公私钥
 * @Author wzj
 * @create: 2020-06-02 21:22
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateRSAKeys {
    public BigInteger p, q; // 素数p q
    public BigInteger n, f; // n = p*q ; f = φ(n) = (p-1)(q-1)
    public BigInteger e, d; // gdc(e,f) = 1 ; d = e^-1 mod φ(n).

    /**
     * 根据bits长度生成p q n e f d
     * @param bits
     */
    public GenerateRSAKeys(int bits) {
        this.p = PrimeNum.generatePrime(bits);
        // 保证 p != q
        do
            this.q = PrimeNum.generatePrime(bits);
        while(this.q.compareTo(this.p) == 0);

        this.n = this.p.multiply(this.q);
        //f = φ(n) = (p-1)(q-1)
        this.f = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));

        do
            this.e = new BigInteger(bits-3, new Random());
        //e 大于1 且和φ(n) 是互质的
        while(this.e.compareTo(this.f) != -1 || this.e.gcd(this.f).compareTo(BigInteger.ONE) != 0);
        // d = e ^(-1) mod φ(n)
        this.d = e.modInverse(this.f);
    }

    /**
     * 根据传入 p q 生成key
     * @param p
     * @param q
     */
    public GenerateRSAKeys(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        this.n = this.p.multiply(this.q);
        this.f = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));
        do
            this.e = new BigInteger(15, new Random());
        while(this.e.compareTo(this.f) != -1 || this.e.gcd(this.f).compareTo(BigInteger.ONE) != 0);
        this.d = e.modInverse(this.f);
    }

    /**
     * p q e 方法重载
     * @param p
     * @param q
     * @param e
     */
    public GenerateRSAKeys(BigInteger p, BigInteger q, BigInteger e) {
        this.p = p;
        this.q = q;
        this.e = e;
        this.n = this.p.multiply(this.q);
        this.f = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));
        this.d = e.modInverse(this.f);
    }

}
