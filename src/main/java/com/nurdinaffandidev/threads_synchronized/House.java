package com.nurdinaffandidev.threads_synchronized;

public class House {
    // Attributes
    private int houseNumber;

    // Constructor
    public House(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    // Getter Setter
    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    // Methods
    public void build() {
        System.out.print("Build house number " + houseNumber + ".");
    }

    public void blown() {
        System.out.print("Blow house number " + houseNumber + ".");
    }

    public void fallen() {
        System.out.println("House number " + houseNumber + " was blown down..");
    }

    public void remainStanding() {
        System.out.println("House number " + houseNumber + " remained standing.");
    }

    public void incrementHouseNumber() {
        houseNumber++;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseNumber=" + houseNumber +
                '}';
    }
}
