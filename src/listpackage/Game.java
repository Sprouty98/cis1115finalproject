
package listpackage;


/**
 *Video games
 * @author Dan Sprout
 */
public class Game {

    private int id;
    private String name;
    private double rating;
    private double releasePrice;
    private double currentPrice;
    
    public Game(int id) {
        this.id = id; //Dont know if need
//        this.name = name;
    }

    Game(int i, String battlefield_1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public Game(int id, String name, double rating, double releasePrice, double currentPrice) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.releasePrice = releasePrice;
        this.currentPrice = currentPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getReleasePrice() {
        return releasePrice;
    }

    public void setReleasePrice(double releasePrice) {
        this.releasePrice = releasePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
    
    @Override
    public String toString() {
        //return "Video Game{" + "id=" + id + ", title=" + name + ", Price on release=" + releasePrice + " , Price today=" + currentPrice + '}';
        return String.format("%5d %-27s %8.2f %8.2f %8.2f", id, name, rating, releasePrice, currentPrice);
    }
    
    
    
    
    
}
