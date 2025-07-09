public class Customer {
    String name;
    String ContactNumber;
    int id;
    String vehicleType;
    int days;

    public Customer(String name,String ContactNumber, int id, String vehicleType, int days) {
        this.name = name;
        this.ContactNumber = ContactNumber;
        this.id = id;
        this.vehicleType = vehicleType;
        this.days = days;
    }
}

class IDGenerator {
    private static int id = 1;

    public static int getId() {
        return id++;
    }
}

class Password {
    private String password = "1234";

    public String getPassword() {
        return password;
    }
}