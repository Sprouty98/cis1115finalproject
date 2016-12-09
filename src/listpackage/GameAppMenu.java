/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listpackage;

import java.util.Scanner;
import utilities.GameStats;
import utilities.Prompt;

/**
 *
 * @author 55jphillip
 */
public class GameAppMenu {

    Scanner sc = new Scanner(System.in);
    DAOGame data = new DAOGame();

    public GameAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String name;
        double rating;
        double releasePrice;
        double currentPrice;

        while (choice != 0) {
            System.out.println("\nGame App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by Id");
            System.out.println("7 = Retrieve All: Order by Title");
            System.out.println("8 = Retrieve All: Order by Rating");
            System.out.println("9 = Retrieve All: Order by Release Price");
            System.out.println("10 = Retrieve All: Order by Current Price");
            System.out.println("11 = Retrieve All: Order by Name / Current Price Ascending");
            System.out.println("12 = Retrieve All: Order by Name / Rating Descending");
            System.out.println("13 = Statistics");
            choice = Prompt.getInt("Number of choice: ", 0, 13);

            if (choice == 1) {
                System.out.println(data.toString());
            } else if (choice == 2) {
                id = Prompt.getInt("Enter game id: ");
                name = Prompt.getLine("Enter title: ");
                rating = Prompt.getDouble("Enter game rating: ");
                releasePrice = Prompt.getDouble("Enter release price: ");
                currentPrice = Prompt.getDouble("Enter current price: ");
                Game game = new Game(id, name, rating, releasePrice, currentPrice);
                data.create(game);
            } else if (choice == 3) {
                id = Prompt.getInt("Enter game id: ");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                ;  
            } else if (choice == 5) {
                id = Prompt.getInt("Enter game id: ");
                data.delete(id);
            } else if (choice == 6) {
                System.out.println(data.orderById());
            } else if (choice == 7) {
                System.out.println(data.orderByName());
            } else if (choice == 8) {
                System.out.println(data.orderByRating());
            } else if (choice == 9) {
                System.out.println(data.orderByReleasePrice());
            } else if (choice == 10) {
                System.out.println(data.orderByCurrentPrice());
            } else if (choice == 11) {
               System.out.println(data.orderByNamePrice());
            } else if (choice == 12) {
                System.out.println(data.orderByNameRating());
            } else if (choice == 13) {
                System.out.println("Lowest current price - " + 
                        GameStats.lowestCurrentPrice(data));
                System.out.println("Highest current price - " + 
                        GameStats.highestCurrentPrice(data));
                System.out.println("Sum of current prices - " + 
                        GameStats.sumCurrentPrice(data));
                System.out.println("Average price - " + 
                        GameStats.avgPrice(data));
                System.out.println("Standard Deviation - " + 
                        GameStats.standardDeviation(data));
            }
           
        }
    }
}

