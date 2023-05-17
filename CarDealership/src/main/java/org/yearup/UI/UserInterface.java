package org.yearup.UI;

import org.yearup.Vehicle.Vehicle;
import org.yearup.DealershipFileManager.FileManager;
import org.yearup.Dealership.DealershipApp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface
{
    private String filePath;

    public UserInterface() throws IOException {
        loadVehicles = loadAllVehicles();
    }

    public void FileManager(String filePath) {
        this.filePath = filePath;
    }
    FileManager fileManager = new FileManager("target\\loadVehicle.csv");
    ArrayList<Vehicle>loadVehicles;
    Scanner scanner = new Scanner(System.in);
    public void run()
    {
        displayHomeScreen();
    }
    public void displayHomeScreen()
    {
        System.out.println("Welcome to CAR DEALERS:\n");
        System.out.println("--------------------------------------------------\n");
        System.out.println("Choose an option to proceed:\n");
        System.out.println("1)Search within priceRange:\n");
        System.out.println("2)Search by Make request:\n");
        System.out.println("3)Search by model request:\n");
        System.out.println("4)All vehicle:\n");
        System.out.println("X)Exit\n");
        System.out.println("---------------------------------------------------\n");
        System.out.println("\n Enter your choice here:");

        String choice = scanner.nextLine().toUpperCase();

        switch(choice)
        {
            case "1":
                processGetByPriceRequest();
                break;
            case "2":
                processGetByMakeModelRequest();
                break;
            case "3":
                 getVehicleByModel();
                break;
            case "4":
                loadAllVehicles();
                break;
            case "X":
                System.out.println("\nThanks for visiting our web page. See you soon");
                System.out.println("\nExiting......");
                break;
            default:
                System.out.println("\nInvalid option, please try again");

        }
    }

    public void processGetByPriceRequest()
    {
        ArrayList<Vehicle>loadVehicles;
        System.out.println("Displaying according to price\n");
        System.out.println("----------------------------------------------\n");
        System.out.println("What do you want to do?\n");
        System.out.println("A)Display cars in minimum price range:\n");
        System.out.println("B)Display cars in maximum price range:\n");
        System.out.println("0)Go back to home screen\n");
        System.out.println("-----------------------------------------------\n");
        System.out.println("\n Enter your option:");
        String choice = scanner.nextLine();
        if(choice.equals("A"))
        {
            ArrayList<Vehicle>matchingPrice = getVehiclesByPrice();
        } else if (choice.equals("B"))
        {

        } else if (choice.equals("0"))
        {
            displayHomeScreen();
        }
        else {
            System.out.println("Invalid Option. please try again");
            processGetByPriceRequest();
        }
    }

    public ArrayList<Vehicle> getVehiclesByPrice()
    {
        ArrayList<Vehicle>matchingPrice = new ArrayList<>();
        System.out.println("Enter the minimum price range:\n");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter the maximum price range: \n");
        double maxPrice = scanner.nextDouble();
        System.out.println("Your vehicle suggestions: ");
        System.out.println("------------------------------------------");

        for(Vehicle vehicle :loadVehicles)
        {
            if(vehicle.getPrice() >= minPrice || vehicle.getPrice() <= maxPrice)
            {
                System.out.println(vehicle.getMake() + " " + vehicle.getModel()
                + " "+ vehicle.getYear()+ " " + vehicle.getPrice());
            }
        }
        return matchingPrice;

    }

    //request for vehicle make
    public void processGetByMakeModelRequest()
    {
        ArrayList<Vehicle>loadVehicles;
        System.out.println("Display by make model of vehicle\n");
        System.out.println("-------------------------------------\n");
        System.out.println("What do you want to do?\n");
        System.out.println("A) Display the Vehicle model:\n");
        System.out.println("B) Display the Vehicle make:\n ");
        System.out.println("0) Go back to home screen\n");
        System.out.println("--------------------------------------");
        System.out.println("Enter your option here:");
        String choice = scanner.nextLine();
        if(choice.equals("A"))
        {
            ArrayList<Vehicle>searchResults = getVehicleByModel();
        } else if (choice.equals("B"))
        {
         ArrayList<Vehicle>searchResults = getVehicleByMake();
        } else if (choice.equals("0"))
        {
            displayHomeScreen();
        }
        else {
            System.out.println("Invalid option. Please try again");
            processGetByMakeModelRequest();
        }
    }
    public ArrayList<Vehicle> getVehicleByModel()
    {
        ArrayList<Vehicle>searchResults = new ArrayList<>();
        System.out.println("Enter the vehicle model here: \n");
        scanner.nextLine();
        for(Vehicle vehicle : loadVehicles)
        {

            String model = null;
            if(vehicle.getModel().equalsIgnoreCase(model))
            {
                System.out.println(vehicle.getMake() + " "+ vehicle.getModel()+" "
                +vehicle.getYear()+ " "+ vehicle.getPrice());
                searchResults.add(vehicle);
            }
        }return searchResults;
    }
    public ArrayList<Vehicle> getVehicleByMake()
    {
        ArrayList<Vehicle>searchResults = new ArrayList<>();
        System.out.println("Enter the Vehicle Make here: \n");
        scanner.nextLine();
        for(Vehicle vehicle : loadVehicles)
        {
            String make = null;
            if(vehicle.getMake().equalsIgnoreCase(make))
            {
                System.out.println(vehicle.getMake()+ " " +vehicle.getModel()+ " "
                +vehicle.getYear() + " "+ vehicle.getPrice());
                searchResults.add(vehicle);
            }

        } return searchResults;
    }
    public ArrayList<Vehicle> loadAllVehicles()
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try(FileReader reader = new FileReader("target\\loadVehicles.csv");
            Scanner scanner = new Scanner(reader))
        {
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] columns = line.split("\\|");
                int vin = Integer.parseInt(columns[0]);
                int year = Integer.parseInt(columns[1]);
                String make = columns[2];
                String model = columns[3];
                String vehicleType = columns[4];
                String color = columns[5];
                int odometer = Integer.parseInt(columns[6]);
                double price = Double.parseDouble(columns[7]);

                Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
                vehicles.add(vehicle);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
//    public ArrayList AddAVehicle()
//    {  return vehicles;
//
//    }

}
