package org.yearup;

import org.yearup.UI.Dealership;

import java.io.IOException;

public class Program
{
    public static void main(String[] args)
    {
        Dealership dealership = new Dealership();
        dealership.getVehiclesByPrice();
    }
}