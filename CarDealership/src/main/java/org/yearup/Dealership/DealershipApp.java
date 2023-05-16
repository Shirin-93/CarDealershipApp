package org.yearup.Dealership;


import org.yearup.Vehicle.Vehicle;

import java.util.ArrayList;

public class DealershipApp
{
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle>loadVehicles;

    public DealershipApp(String name, String address, String phoneNumber)
    {
        loadVehicles = new ArrayList<Vehicle>();
        this.name = name;
        this.address =address;
        this.phoneNumber =phoneNumber;
    }
    //    public void run() {
//    }
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
    public ArrayList<Vehicle> getVehiclesByPrice()
    {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        double minPrice =Double.MIN_VALUE;
        double maxPrice = Double.MAX_VALUE;

        for(Vehicle vehicle : loadVehicles)
        {
            double price = vehicle.getPrice();
            if (price < minPrice)
            {
                minPrice = price;
            }
            if(price > maxPrice)
            {
                maxPrice = price;
            }
            else
            {
                System.out.println("there was an error loading file");
            }
        }
        System.out.println("Price ranges:");
        System.out.println("---------------------------------------");
        System.out.println( " Minimum price range of car:" + minPrice);
        System.out.println(" Maximum price range of car:"+ maxPrice);
        System.out.println("----------------------------------------");
        return searchResults;
    }
    public ArrayList<Vehicle> getVehicleByMake()
    {
        ArrayList<Vehicle>searchResults = new ArrayList<>();
        for(Vehicle vehicle: loadVehicles)
        {
            if(vehicle.getMake().equals(getVehicleByMake()))
            {
                return searchResults;
            }
        }
        return searchResults;
    }
    public ArrayList<Vehicle> getVehicleByModel()
    {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        for(Vehicle vehicle: loadVehicles)
        {
            if(vehicle.getModel().equals(getVehicleByModel()))
            {
                return searchResults;
            }
        }
        return searchResults;
    }


//

//    public Vehicle addVehicle(vehicle);
//    {
//        return null;
//    }





//    public Vehicle getVehicleByYear()
//    {
//        return null;
//    }
//    public Vehicle getVehicleByColor()
//    {
//        return null;
//    }
//    public Vehicle getVehiclesByMileage()
//    {
//        return null;
//    }
//    public Vehicle getVehiclesByType()
//    {
//        return null;
//    }

//
//    public Vehicle removeVehicle()
//    {
//
//    }








}
