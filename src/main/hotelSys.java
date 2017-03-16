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
public class hotelSys {

    static String[] hotelArray = new String[10]; //declare & initialise the array

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int roomNum = 0;
        String customerName = "";
        

        initialise(hotelArray);//initialise the array with "e"

        menu.mainMenu(hotelArray, input, roomNum, customerName);

    }

    private static void initialise(String hotelArray[]) {

        for (int i = 0; i < 10; i++) {

            hotelArray[i] = "empty"; // sets to empty
//            System.out.println(hotelArray[i]);
        }
        System.out.println("--------------------- ");
        System.out.println(" Welcome to Hotel007 ");
        System.out.println("--------------------- ");
    }

    public static void viewCustomer(String hotelArray[], int roomNum) {

        for (int i = 0; i < 10; i++) {//views the customers
            if (hotelArray[i].equals("empty")) {
                System.out.println("room " + (i + 1) + " is empty");
            } else {
                System.out.println("room " + (i + 1) + " is occupied by " + hotelArray[i]);
            }

        }
        //menu.mainMenu(hotelArray, input, roomNum, null);
    }

    public static void addCustomer(String hotelArray[], int roomNum, String customerName,Scanner input) {

        System.out.print("Free Rooms : ");
        for (int i = 0; i < 10; i++) {//loops
            if (hotelArray[i].equals("empty")) {//checks whether the array is empty.

                System.out.print((i + 1) + ",");
            }

        }
        System.out.println("");

        System.out.print("Enter room number (1-10) 0r 11 to exit: ");
        String value = input.next();
        if (!Character.isDigit(value.charAt(0))) {//checks for numbers input
            System.err.println("Invalid Input!");
            hotelSys.addCustomer(hotelArray, roomNum, customerName, input);
        } else {
            roomNum = Integer.parseInt(value);
            if (roomNum >= 1 && roomNum <= 10) {
                if (hotelArray[roomNum - 1].equals("empty")) {//only if it is empty it allows to enter customer name
                    System.out.println("Enter customer name for the room number " + roomNum + ": ");
                    System.out.print(" Enter customer first name : ");
                    String customerFName = input.next();
                    System.out.print(" Enter customer last name :");
                    String customerLName = input.next();
                    
                    customerName = customerFName + customerLName;
                    
                    
                    if (customerName.matches("[a-zA-Z]*")) {//checks whether the name only consist with alphabetical letters.
                        customerName=customerFName+ " " +customerLName;
                        hotelArray[roomNum - 1] = customerName;//room-1 and adds to the array
                        System.out.println("Room " + roomNum + " is occupied by " + customerName);
                        System.out.println(" Operation Successful ");
                        //menu.mainMenu(hotelArray, input, roomNum, customerName);

                    } else {

                        System.err.println(" Name cannot contain characters ");
                        hotelSys.addCustomer(hotelArray, roomNum, customerName,  input);
                    }
                } else {
                    System.err.println("Room" + roomNum + " is already booked.");
                    hotelSys.addCustomer(hotelArray, roomNum, customerName, input);
                }

            } else if (roomNum == 11) {
                menu.mainMenu(hotelArray, input, roomNum, customerName);
            } else {
                System.err.println("Invalid Input!");
                hotelSys.addCustomer(hotelArray, roomNum, customerName, input);
            }
        }
        //  menu.mainMenu(hotelArray, input, roomNaum, null);
    }

    public static void disemptyRoom(String hotelArray[], int roomNum) {
        for (int i = 0; i < 10; i++) {//loops
            if (hotelArray[i].equals("empty")) {//checks whether the array is empty.
                System.out.println("room " + (i + 1) + " is empty");
            }

        }
//menu.mainMenu(hotelArray, input, roomNum, null);
    }

    public static void deleteRoom(String hotelArray[], int roomNum, Scanner input) {

        System.out.print("Enter room number which you want to delete : ");
        String value = input.next();
        if (!Character.isDigit(value.charAt(0))) { //checks for number input
            System.err.println("Invalid Input!");
            hotelSys.deleteRoom(hotelArray, roomNum, input);
        } else {
            roomNum = Integer.parseInt(value);
            if (roomNum >= 1 && roomNum <= 10) {

                hotelArray[roomNum - 1] = "empty";//sets the array data to empty
                System.out.println("Room " + roomNum + " is empty ");
                System.out.println(" Operation Successful ");

            } else {
                System.err.println("Invalid Input!");
                hotelSys.deleteRoom(hotelArray, roomNum, input);
            }

//menu.mainMenu(hotelArray, input, roomNum, null);
        }

    }

    public static void findCustomer(String hotelArray[], String customerName, Scanner input, int roomNum) {

        System.out.print("Enter customer first name : "); //gets the required name
        String customerFName = input.next();
        
        System.out.print("Enter customer last name : "); //gets the required name
        String customerLName = input.next();
        
        customerName = customerFName + customerLName;

        if (customerName.matches("[a-zA-Z]*")) {//checks whether its alphebertical
            
            boolean token = false;
            customerName =customerFName +" "+ customerLName;
            for (int i = 0; i < 10; i++) {
                if (hotelArray[i].equalsIgnoreCase(customerName)) {
                    System.out.println("room " + (i + 1) + " is occupied by " + hotelArray[i]);
                    token = true;//checks for the name, whether it exist.
                }

            }
            if (token == false) {//if no such name exist
                System.out.println(" !!! Such customer name doesn't exist ");

            }
        } else {

            System.err.println(" Invalid Input ");//if an invalid input provided
            hotelSys.findCustomer(hotelArray, customerName, input, roomNum);

        }

    }

    public static void sortbyCustomer(String hotelArray[]) {
        String tmp;
        String sortArray[] = new String[10];

        for (int i = 0; i < hotelArray.length; i++) {//loads the hotel array data to the newly created array (sortArray[])

            sortArray[i] = hotelArray[i] + " room no " + (i + 1);

        }

        for (int i = 0; i < sortArray.length; i++) {
            for (int a = 0; a < sortArray.length - i - 1; a++) {

                if (sortArray[a].compareToIgnoreCase(sortArray[a + 1]) > 0) {
                    tmp = sortArray[a];
                    sortArray[a] = sortArray[a + 1];
                    sortArray[a + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < sortArray.length; i++) {
            if (!(sortArray[i].startsWith("empty"))) {
                System.out.println(sortArray[i]);
            }

        }

    }

}
