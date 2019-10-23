package jamal.consistentHashing;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
public class ConsistentHashRouter<T extends Node> {

    private final SortedMap<Long, VirtualNode<T>> ringTopology = new TreeMap<>();
    private final MD5CHHashFunction hashFunction;

    public ConsistentHashRouter(List<T> serverNodes, int virtualNodes) {
        this(serverNodes, virtualNodes, new MD5CHHashFunction());
    }

    public ConsistentHashRouter(List<T> serverNodes, int virtualNodes, MD5CHHashFunction md5Hash) {
        this.hashFunction = md5Hash;

        if (serverNodes != null) {
            for (T serverNode : serverNodes) {
                addNode(serverNode, virtualNodes);
            }
        }
    }

    private void addNode(T serverNode, int virtualNodes) {
        int existingReplicas = getExistingReplicas(serverNode);
        for (int i = 0; i < virtualNodes; i++) {
            VirtualNode<T> virtualNode = new VirtualNode<>(serverNode, i + existingReplicas);
            ringTopology.put(hashFunction.hash(virtualNode.getKey()), virtualNode);
        }
    }

    private int getExistingReplicas(T serverNode) {
        int replicas = 0;
        for (VirtualNode<T> virtualNode : ringTopology.values()) {
            if (virtualNode.isVirtualNodeOf(serverNode)) {
                replicas++;
            }
        }
        return replicas;
    }

    public T routeNode(String requesterIp) {
        Long hasVal = hashFunction.hash(requesterIp);
        SortedMap<Long, VirtualNode<T>> tailedMap = ringTopology.tailMap(hasVal);
        Long nodeHashVal = !tailedMap.isEmpty() ? tailedMap.firstKey() : ringTopology.lastKey();
        return ringTopology.get(nodeHashVal).getPhysicalNode();
    }
}
