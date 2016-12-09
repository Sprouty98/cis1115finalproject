package listpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 55sproutdj06
 */
public class DAOGame {
    private final String fileName = "gamedata.txt";
    public List<Game> myList;

    public DAOGame() {
        myList = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAOGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public void create(Game game) {
        myList.add(game);
        writeList();
    }
    
    public Game retrieve(int id) {
        for (Game game : myList) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }
    
    public void update(Game game) {
        for(Game g : myList) {
            if(g.getId() == game.getId()) {
                g.setName(game.getName());
                break;
            }
        }
    }
    
    public void delete(int id) {
        Game myGame = null;
        for(Game g : myList) {
            if(g.getId() == id) {
                myGame = g;
                break;
            }
        }
        myList.remove(myGame);
        writeList();
    }
    // Java 8 sort
    public String orderById() {
        myList.sort(Comparator.comparing(Game::getId));
        return this.toString();
    }
    
    public String orderByName() {
        myList.sort(Comparator.comparing(Game::getName));
        return this.toString();
    }
    
    public String orderByRating() {
        myList.sort(Comparator.comparing(Game::getRating));
        return this.toString();
    }
    
    public String orderByNamePrice() {
        myList.sort(Comparator.comparing(Game::getName).thenComparing(Game::getCurrentPrice).reversed());
        return this.toString();
    }
    
    public String orderByCurrentPrice() {
        myList.sort(Comparator.comparing(Game::getName));
        return this.toString();
    }
    
    public String orderByReleasePrice() {
        myList.sort(Comparator.comparing(Game::getName));
        return this.toString();
    }
    
    public String orderByNameRating() {
        //Descending
        myList.sort(Comparator.comparing(Game::getName).thenComparing(Game::getRating));
        return this.toString();
    }
    
//    public int Statistics() {
//        http://www.zparacha.com/minimum-maximum-array-value/
//    }
  
    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double rating = Double.parseDouble(data[2]);
                double releasePrice = Double.parseDouble(data[3]);
                double currentPrice = Double.parseDouble(data[4]);
                Game myGame = new Game(id, name, rating, releasePrice, currentPrice);
                myList.add(myGame);
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Game game : myList) {
                writer.write(String.format("%5d %-10s %8.2f %8.2f %8.2f",
                        game.getId(),
                        game.getName(),
                        game.getRating(),
                        game.getReleasePrice(),
                        game.getCurrentPrice()));
                       
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Game game : myList) {
            sb.append(game).append("\n");
        }
        return sb.toString();
//        return "DAOGame{" + "myList=" + myList + '}';
    }
    
    
    
}
