package org.yearup.DealershipFileManager;

import org.yearup.UI.Dealership;
import org.yearup.Vehicle.Vehicle;
import org.yearup.Dealership.DealershipApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    private String filePath;

    public FileManager(String filePath) throws FileNotFoundException, IOException {
        this.filePath = filePath;
    }
    private static final String FileName = "loadVehicle.csv";
    private static final String delimeter = "\\|";
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(FileName)))
        {
            String line;
            String[] details;
            Dealership dealership = null;
            while((line = reader.readLine()) != null)
            {
                details = line.split(delimeter);
                if (dealership ==null)
                {
                    dealership = new Dealership(details[0],details[1],details[2]);

                }
                else
                {
                    dealership.processAddVehicleRequest(new Vehicle(Integer.parseInt(details[0]),Integer.parseInt(details[1]),details[2],details[3],details[4],Double.parseDouble(details[5])))
                }

            }


        }return dealership;
    }
}

