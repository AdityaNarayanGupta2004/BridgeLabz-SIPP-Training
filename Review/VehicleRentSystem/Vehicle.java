abstract class Vehicle {
    public int getCharge() {
        return 0;
    }

    public void setCharge(int charge) {}

    public String getType() {
        return "Vehicle";
    }
}

class Bike extends Vehicle {
    private static int charge = 100;

    @Override
    public int getCharge() {
        return charge;
    }

    @Override
    public void setCharge(int c) {
        charge = c;
    }

    @Override
    public String getType() {
        return "Bike";
    }
}

class Car extends Vehicle {
    private static int charge = 200;

    @Override
    public int getCharge() {
        return charge;
    }

    @Override
    public void setCharge(int c) {
        charge = c;
    }

    @Override
    public String getType() {
        return "Car";
    }
}

class Truck extends Vehicle {
    private static int charge = 300;

    @Override
    public int getCharge() {
        return charge;
    }

    @Override
    public void setCharge(int c) {
        charge = c;
    }

    @Override
    public String getType() {
        return "Truck";
    }
}
