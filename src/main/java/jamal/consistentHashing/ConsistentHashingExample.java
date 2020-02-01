
package jamal.consistentHashing;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
public class ConsistentHashingExample {

    public static void main(String[] args) {
        ServerNode serverNode1 = new ServerNode("server1", "127.0.0.1", 8080);
        ServerNode serverNode2 = new ServerNode("server2", "127.0.0.1", 8081);
        ServerNode serverNode3 = new ServerNode("server3", "127.0.0.1", 8082);

        ConsistentHashRouter consistentHashRouter = new ConsistentHashRouter<>(Arrays.asList(serverNode1, serverNode2, serverNode3), 0);//10 virtual node

        //we have 5 requester ip, we are trying them to route to one service node
        String requestIP1 = "192.168.0.1";
        String requestIP2 = "192.168.0.2";
        String requestIP3 = "192.168.0.3";
        String requestIP4 = "192.168.0.4";
        String requestIP5 = "192.168.0.5";

        List<String> records = Arrays.asList("jamal", "madan", "kumar");

        for (String record : records) {
            Node node = consistentHashRouter.routeNode(record);
            node.addData(new DataElement(record, record + "___" + UUID.randomUUID().toString()));
        }

        for (String record : records) {
            Node node = consistentHashRouter.routeNode(record);
            System.out.println("Data is on node " + node.getKey() + " data retrieved is " + consistentHashRouter.routeNode(record).getData(record).name);
        }

//        findRouting(consistentHashRouter, requestIP1, requestIP2, requestIP3, requestIP4, requestIP5);

    }

    private static void findRouting(ConsistentHashRouter consistentHashRouter, String... requesterIps) {
        for (String requesterIp : requesterIps) {
            System.out.println(consistentHashRouter.routeNode(requesterIp).getKey());
        }
    }
}
