package org.yearup.Dealership;

import org.yearup.Vehicle.Vehicle;
import org.yearup.DealershipFileManager.FileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class DealershipApp
{
    private String filePath;

    public DealershipApp() throws IOException {
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
        System.out.println("4)Show all vehicles:\n");
        System.out.println("5)All a vehicle:\n");
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
                getAllVehicles();
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
        ArrayList<Vehicle>loadVehicle;
        System.out.println("Displaying according to price\n");
        System.out.println("----------------------------------------------\n");
        System.out.println("What do you want to do?\n");
        System.out.println("A)Display cars in minimum price range:\n");
        System.out.println("B)Display cars in maximum price range:\n");
        System.out.println("0)Go back to home screen\n");
        System.out.println("-----------------------------------------------\n");
        System.out.println("\n Enter your option:");

        String choice = scanner.nextLine().toUpperCase();
        switch(choice)
        {
            case "A":
                getVehiclesByPrice();
                break;
            case "B":

        }
    }

    private void getVehiclesByPrice() {
    }

    //request for vehicle make
    public ArrayList<Vehicle> processGetByMakeModelRequest()
    {
        ArrayList<Vehicle>matchingVehicle = new ArrayList<>();
        for(Vehicle Vehicle : loadVehicles)
        {
            String make= null;
            String model = null;
            if (Vehicle.getMake().equalsIgnoreCase(make) || Vehicle.getModel().equalsIgnoreCase(model))
            {
                matchingVehicle.add(Vehicle);
            }
        }return matchingVehicle;
    }

    public ArrayList<Vehicle>getAllVehicles()
    {
        return loadVehicles;
    }


    public ArrayList<Vehicle> loadAllVehicles()
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try(FileReader reader = new FileReader(this.filePath);
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
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return vehicles;



    }


}
