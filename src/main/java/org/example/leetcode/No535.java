package org.example.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-08-07 14:47
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 *
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/encode-and-decode-tinyurl
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No535 {
}

class Codec {

    private static final String MOMO = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    private static final String PREFIX = "http://tinyurl.com/";

    private Map<String, String> map;

    private Random random;

    public Codec() {
        map = new HashMap<>();
        random = new Random(System.currentTimeMillis());
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tiny = genTinyUrl(6);
        while (map.containsKey(tiny)) {
            tiny = genTinyUrl(6);
        }
        String res = PREFIX + tiny;
        map.put(res, longUrl);
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    private String genTinyUrl(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            sb.append(MOMO.charAt(random.nextInt(MOMO.length())));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));