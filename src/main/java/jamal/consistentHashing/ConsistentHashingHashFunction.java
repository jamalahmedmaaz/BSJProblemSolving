package jamal.consistentHashing;

public interface ConsistentHashingHashFunction {
    long hash(String key);
}
