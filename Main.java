import java.io.FileReader;      // File Reading...
import java.io.BufferedReader;  // Read the file line by line
import java.io.IOException;     // IO Exceptions! Signals that an Input/Output exception of some sort has occurred. 

import java.util.List;          // Gives us the List class!
import java.util.ArrayList;     // Allows us to dynamically create Arrays.

class Main {
  public static void main(String[] args) {
    /*
    Pokemon pikachu = new Pokemon("Pikachu", "Electric", "Ground", 35, 90, 55, 40);
    System.out.println(pikachu.getType());
    pikachu.heal();
    Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass", "Fire", 45, 45, 49, 49);
    System.out.println(bulbasaur.getType());
    pikachu.heal();
    
    Pokedex pokedex = new Pokedex(951123);
    
    for(int i = 1; i<= pokedex.length(); i++){
      pokedex.getByNumber(i).print();
    }
    Pokemon pikachu = pokedex.getByNumber(25);
    pikachu.print();

    pikachu.levelUP();
    pikachu.print();

    
    pikachu.levelUP(50);
    pikachu.print();
    
    pikachu.levelUP(50);
    pikachu.print();
    */

    System.out.println(32 - Integer.numberOfLeadingZeros(64 - 1));

  }

  public static String[] fileToArray(String filename) 
  {
    try 
    {
      BufferedReader myReader = new BufferedReader(new FileReader(filename));
      List<String> lines = new ArrayList<String>();
      String line = null;
      while ((line = myReader.readLine()) != null) {
        lines.add(line);
      }
      myReader.close();
      return lines.toArray(new String[lines.size()]);
    } catch (IOException exception) {
      System.out.println("IO Exception Occured!");
      exception.printStackTrace();
      return null;
    }
  }
}