package com.example.demo.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Zhengyn
 * @description
 * @create 21/6/17 22:11
 */
public class RandomTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        for (int i = 0; i < 20; i++) {
            System.err.println("第" + i + "个随机数------" + SecureRandom());
        }

    }

    public static int random() {
        final Random random = new Random();
        return random.nextInt(100);
    }

    public static int ThreadLocalRandom() {
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(100);
    }

    public static int SecureRandom() throws NoSuchAlgorithmException {
        final SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        return random.nextInt(100);
    }

    //还有一个Math
}
