package org.yearup.DealershipFileManager;

import org.yearup.UI.UserInterface;
import org.yearup.Vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    private String filePath;

    public FileManager(String filePath) throws FileNotFoundException, IOException {
        this.filePath = filePath;
    }
    private static final String FileName = "loadVehicles.csv";
//    private static final String delimiter = "\\|";
//    {
//        try(BufferedReader reader = new BufferedReader(new FileReader(FileName)))
//        {
//            String line;
//            String[] details;
//            UserInterface dealership = null;
//            while((line = reader.readLine()) != null)
//            {
//                details = line.split(delimiter);
//                if (dealership ==null)
//                {
//                    dealership = new UserInterface(details[0],details[1],details[2]);
//
//                }
//                else
//                {
//                    dealership.processAddVehicleRequest(new Vehicle(Integer.parseInt(details[0]),Integer.parseInt(details[1]),details[2],details[3],details[4],Double.parseDouble(details[5])));
//                }
//
//            }
//        }
//    }
}

