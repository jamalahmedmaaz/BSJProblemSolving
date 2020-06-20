package jamal.consistentHashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//default hash function
class MD5CHHashFunction implements ConsistentHashingHashFunction {

    MessageDigest instance;

    public MD5CHHashFunction() {
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
    }


    @Override
    public long hash(String key) {
        instance.reset();
        instance.update(key.getBytes());
        byte[] digest = instance.digest();

        long h = 0;
        for (int i = 0; i < 4; i++) {
            h <<= 8;
            h |= ((int) digest[i]) & 0xFF;
        }
        return h;
    }
}