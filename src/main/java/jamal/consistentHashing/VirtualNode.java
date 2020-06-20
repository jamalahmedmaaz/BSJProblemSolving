package jamal.consistentHashing;

import java.util.HashMap;
import java.util.Map;
public class VirtualNode<T extends Node> implements Node {
    final T physicalNode;
    final int virtualNodeIndex;
    final Map<String, DataElement> set = new HashMap<>();

    public VirtualNode(T physicalNode, int replicaIndex) {
        this.virtualNodeIndex = replicaIndex;
        this.physicalNode = physicalNode;
    }

    @Override
    public String getKey() {
        return physicalNode.getKey() + "-" + virtualNodeIndex;
    }

    @Override
    public void addData(DataElement data) {
        set.put(data.id, data);
    }

    @Override
    public DataElement getData(String id) {
        return set.get(id);
    }

    public boolean isVirtualNodeOf(T pNode) {
        return physicalNode.getKey().equals(pNode.getKey());
    }

    public T getPhysicalNode() {
        return physicalNode;
    }
}