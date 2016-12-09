package utilities;

import listpackage.DAOGame;
import listpackage.Game;

/**
 * http://stackoverflow.com/questions/1484347/finding-the-max-min-value-in-an-array-of-primitives-using-java
 * 
 * http://www.vogella.com/tutorials/JavaCollections/article.html#javacollections_typicaltypes1
 * 
 * @author 55sproutdj06
 */
public class GameStats {
    public static double lowestCurrentPrice(DAOGame data) {
        double low = 0;
        for(Game game : data.myList) {
            if(game.getCurrentPrice() < low) low = game.getCurrentPrice();
        }
        return low;
    }
    
    public static double highestCurrentPrice(DAOGame data) {
        double highest = 0;
        for(Game game : data.myList) {
            if(game.getCurrentPrice() > highest) highest = game.getCurrentPrice();
        }
        return highest;
    }
    
    public static double sumCurrentPrice(DAOGame data) {
        double sum = 0;
        for(Game game : data.myList) {
            sum += game.getCurrentPrice();
        }
        return sum;
    }
    
    public static double avgPrice(DAOGame data) {
        double sum = sumCurrentPrice(data);
        double average = sum / data.myList.size();
        return average;
    }
    
    public static double standardDeviation(DAOGame data) {
        double total = 0;
        double average = avgPrice(data);
        for(Game game : data.myList) { 
            total += Math.pow((game.getCurrentPrice() - average), 2); //calculates top of standard dev calculation 
        }
        return Math.sqrt(total / (data.myList.size() - 1));
    }
}

