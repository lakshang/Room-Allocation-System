/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 2014286
 */
class readWriteFile {

    public static void writeFile(String hotelArray[], int roomNum) {
        try {
            File f = new File(System.getProperty("user.home") + "/Desktop");//gets to the users desktop
            File f2 = new File(f, "Hotel007 Room Data.txt");//creates a text file on the desktop
            f2.createNewFile();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f2))) {//uses buffered writer to write data line by line
                bw.write(" Welcome to Hotel 007 ");
                bw.newLine();
                bw.write("----------------------");
                bw.newLine();
                for (int x = 0; x < 10; x++) {
                    if (hotelArray[x].equals("empty")) {
                        bw.write("room " + (x + 1) + " is empty");
                        bw.newLine();
                    } else {
                        bw.write("room " + (x + 1) + " is occupied by " + hotelArray[x]);
                        bw.newLine();
                    }
                }
                bw.flush();
                bw.close();
                File filedesktop = new File(f, "Hotel007 Room Data.txt");
                Desktop file = Desktop.getDesktop();
                file.open(filedesktop);//opens the file from the desktop
            }

        } catch (Exception e) {
            System.out.println("!! File Error ");
        }

    }

    public static String[] readFile(String hotelArray[]) {

        //String ar[] = new String[11];//creates a new array to load
        try {
            File f = new File(System.getProperty("user.home") + "/Desktop/Hotel007 Room Data.txt");//gets the stored file from the desktop

            BufferedReader br = new BufferedReader(new FileReader(f));//uses buffered reader

            String line;
            int i = 0;

            while ((line = br.readLine()) != null) {//reads until not null

                if (line.contains("room")) {//checks whther it contains keyword "room"

                    if (line.contains("empty")) {//if empty array is set to empty
                        hotelArray[i] = "empty";
                    } else {

                        hotelArray[i] = line.split("by")[1].trim();//or sets the customer name
                    }
                    i++;
                }

            }
            br.close();
            System.out.println("Load Completed");
            System.out.println("--------------");
        } catch (IOException e) {
            System.out.println(" File not Found ");
        }

        return hotelArray;//returns the loaded array
    }

}
