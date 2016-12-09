
package listpackage;

/**
 *
 * @author 55sproutdj06
 */
public class GameApp {
    public static void main(String[] args) {
        Game ga1, ga2, ga3;
        ga1 =(new Game(1, "Overwatch", 9.1, 60, 40));
        ga2 =(new Game(2, "Battlefield 1", 8.8, 60, 55));
        ga3 =(new Game(3, "Call of Duty: Infinite Warfare", 7.7, 60, 60));
        
        System.out.println(ga1);
        System.out.println(ga2);
        System.out.println(ga3);
    }
    
}
