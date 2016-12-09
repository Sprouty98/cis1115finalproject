
package listpackage;

/**
 *
 * @author 55sproutdj06
 */
public class GameApp2 {
    public static void main(String[] args) {
        DAOGame data = new DAOGame();
        data.create(new Game(5, "Call of Duty", 7.6, 60, 55));
        data.create(new Game(6, "Rise of the Tomb Raider", 8.8, 60, 35));
        data.create(new Game(7, "Call of Duty: Black Ops 3", 9.1, 60, 30));
        System.out.println(data);
        
        System.out.println(data.retrieve(2));
        System.out.println(data.retrieve(-1));
        
        Game g1 = new Game(1 ,"Battlefield 1", 8.9, 60, 60);
        data.update(g1);
        System.out.println(data.retrieve(2));
        
        data.delete(3);
        System.out.println(data);
    }
    
}
