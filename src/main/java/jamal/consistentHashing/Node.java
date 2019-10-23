package jamal.consistentHashing;

public interface Node {

    public String getKey();

    public void addData(DataElement data);

    public DataElement getData(String id);
}
