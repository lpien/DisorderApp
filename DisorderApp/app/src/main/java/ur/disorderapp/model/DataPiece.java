package ur.disorderapp.model;


public class DataPiece
{
    int key;
    String data_value;

    public DataPiece(int key, String data_value) {
        this.key = key;
        this.data_value = data_value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getData_value() {
        return data_value;
    }

    public void setData_value(String data_value) {
        this.data_value = data_value;
    }
}
