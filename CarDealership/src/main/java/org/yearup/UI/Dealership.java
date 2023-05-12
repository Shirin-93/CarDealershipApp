package org.yearup.UI;

import org.yearup.Vehicle.Vehicle;

import java.util.ArrayList;

public class Dealership
{
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle>loadVehicles;

    public Dealership(String name,String address,String phoneNumber)
    {
        this.name = name;
        this.address =address;
        this.phoneNumber =phoneNumber;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name= name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public
}
