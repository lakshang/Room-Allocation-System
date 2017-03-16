/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author 2014286
 */
public class menu {

    public static void mainMenu(String hotelArray[], Scanner sc, int roomNum, String customerName) {

        String input = null;
        boolean token = true;

        while (token) {
            displayMenu();//displays the menu
            System.out.println("");
            System.out.print("  Press to proceed : ");
            input = sc.next().toUpperCase();//gets the input
            switch (input) {
                //views the menus' accordingly
                case "V":
                    System.out.println("    View ");
                    System.out.println("-------------------");
                    hotelSys.viewCustomer(hotelArray, roomNum);
                    System.out.println("-------------------");
                    break;
                    
                case "A":
                    System.out.println(" Add Customer ");
                    System.out.println("--------------");
                    hotelSys.addCustomer(hotelArray, roomNum, customerName,sc);
                    System.out.println("-------------------");
                    break;
                case "E":
                    System.out.println("  Display Empty Rooms ");
                    System.out.println("--------------------");
                    hotelSys.disemptyRoom(hotelArray, roomNum);
                    System.out.println("-------------------");
                    break;
                case "D":
                    System.out.println("  Delete Room ");
                    System.out.println("-------------");
                    hotelSys.deleteRoom(hotelArray, roomNum, sc);
                    System.out.println("-------------------");
                    break;
                case "F":
                    System.out.println("   Find Customer ");
                    System.out.println("-------------------");
                    hotelSys.findCustomer(hotelArray, customerName, sc, roomNum);
                    System.out.println("-------------------");
                    break;
                case "S":
                    readWriteFile.writeFile(hotelArray, roomNum);
                    System.out.println("Successfully Stored !");
                    System.out.println("-------------------");
                    break;
                case "L":
                    readWriteFile.readFile(hotelArray);
                  
                    break;

                case "O":
                    System.out.println("        Sort  ");
                    System.out.println("-------------------");
                    hotelSys.sortbyCustomer(hotelArray);
                    System.out.println("-------------------");
                    break;
                    
                case "Q":
                    System.exit(0);
                default:
                    System.err.println("Invalid Input");
                    //menu.mainMenu(hotelArray, sc, roomNum, customerName);
            }

        }
    }

    private static void displayMenu() {
        System.out.println("V: View all rooms ");
        System.out.println("A: Add Customer");
        System.out.println("E: Display empty rooms");
        System.out.println("D: Delete customer from room");
        System.out.println("F: Find room from customer name");
        System.out.println("S: Store");
        System.out.println("L: Load");
        System.out.println("O: View all ordered alphabetically by name");
        System.out.println("Q: Exit");
    }
}
