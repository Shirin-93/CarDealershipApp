package org.yearup.Dealership;

import org.yearup.UI.Dealership;
import org.yearup.Vehicle.Vehicle;
import org.yearup.DealershipFileManager.FileManager;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
public class DealershipApp
{
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
                processGetByMakeRequest();
                break;
            case "3":
                processGetByModelRequest();
                break;
            case "4":
                processGetAllVehiclesRequest();
                break;
            case "5":
                processAddVehicleRequest();
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

    public void processGetByMakeRequest() {
    }

    public void processGetByModelRequest() {
    }

    public void processGetAllVehiclesRequest() {
    }

    public void processAddVehicleRequest() {
    }


}
