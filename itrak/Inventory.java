package softwaredesign.itrak;

public class Inventory
{
    private int id;
    private String item_name;
    private String item_serial;
    private String item_location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_serial() {
        return item_serial;
    }

    public void setItem_serial(String item_serial) {
        this.item_serial = item_serial;
    }

    public String getItem_location() {
        return item_location;
    }

    public void setItem_location(String item_location) {
        this.item_location = item_location;
    }

}
