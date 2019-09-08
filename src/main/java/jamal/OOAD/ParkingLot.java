package jamal.OOAD;

import java.util.Stack;

/**
 * Enum and constants required for the system.
 */
enum VehicleType {
    CAR, TRUCK, MINIVAN, ELECTRIC, MOTORBIKE
}

enum SpotType {
    HANDICAP, COMPACT, BIKE, LARGE
}

enum AccountStatus {
    ACTIVE, INACTIVE, COMPROMISED, DEACTIVE
}

enum ParkingTicketStatus {
    ACTIVE, PAID, LOST
}

class Address {
    private String streetAddress;
    private String pinCode;
    private String city;
    private String state;
    private String country;
}


class Person {
    private Address address;
    private String personName;
    private String personEmail;
    private String personPhoneNumber;
}

/**
 * Enum and constants END
 */


abstract class Account {
    private String username;
    private String password;
    private Person person;
    private String displayName;
    private AccountStatus accountStatus;

    public void resetPassword() {
        /**
         * Common Reset logic
         */
    }
}

class Admin extends Account {
    public void addFloor(ParkingFloor parkingFloor) {

    }

    public void addParkingSpot(ParkingSpot parkingSpot, String floorName) {

    }

    public void addDisplayBoard(DisplayBoard displayBoard, String floorName) {

    }

    public void addCustomerInfoPanel(CustomerInfoPanel customerInfoPanel, String floorName) {

    }

    public boolean addEntrancePanel(EntrancePanel entrancePanel) {
        return false;
    }

    public boolean addExitPanel(ExitPanel exitPanel) {
        return false;
    }

    public void addAttendy() {

    }

    public void removeFloor() {

    }

    public void removeAttendy() {

    }

    public void modifyHourlyPrice() {
    }

}

class ParkingAttendy extends Account {

    public boolean processTicketPayment(String ticketNumber) {

        return false;
    }
}

class ParkingFloor {

}

class ParkingSpot {

}

class DisplayBoard {

}

class CustomerInfoPanel {

}

class EntrancePanel {

}

class ExitPanel {

}

public class ParkingLot {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(12);
        stack.push(235);
        stack.push(435);
        stack.removeElement(12);
    }
}
