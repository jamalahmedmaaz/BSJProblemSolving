package jamal.consistentHashing;

import java.util.HashMap;
import java.util.Map;
public class ServerNode implements Node {
    final Map<String, DataElement> set = new HashMap<>();
    private String serverName;
    private String ipAddress;
    private int port;

    public ServerNode(String serverName, String ipAddress, int port) {
        this.serverName = serverName;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public String getKey() {
        return serverName + "-" + ipAddress + ":" + port;
    }

    @Override
    public void addData(DataElement data) {
        set.put(data.id, data);
    }

    @Override
    public DataElement getData(String id) {
        return set.get(id);
    }
}
