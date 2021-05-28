/**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy. If necessary, additional paragraphs should
 * be preceded by <p>, the html tag for a new paragraph.)
 *
 * @author Graeme Melrose
 */
public class Pokedex {

  private Pokemon[] pokedex = null;

  /**
  * Default Constructor.
  *
  * <p>Creates a new Pokedex from the Pokedex.tsv file.
  */
  public Pokedex()
  {
    String[] lines = Main.fileToArray("Pokedex.tsv");
    pokedex = new Pokemon[lines.length - 1];
    for(int i = 0; i<pokedex.length; i++){
      String[] line = lines[i+1].split("\t");
      pokedex[i] = new Pokemon(line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]));
    }
  }


  public Pokedex(String filename)
  {
    String[] lines = Main.fileToArray(filename);
    pokedex = new Pokemon[lines.length - 1];
    for(int i = 0; i<pokedex.length; i++){
      String[] line = lines[i+1].split("\t");
      pokedex[i] = new Pokemon(line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]));
    }
  }


  public Pokedex(String filename, String delimiter)
  {
    String[] lines = Main.fileToArray(filename);
    pokedex = new Pokemon[lines.length - 1];
    for(int i = 0; i<pokedex.length; i++){
      String[] line = lines[i+1].split(delimiter);
      pokedex[i] = new Pokemon(line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]));
    }
  }


  public Pokedex(long seed)
  {
    String[] lines = Main.fileToArray("Pokedex.tsv");
    pokedex = new Pokemon[lines.length - 1];
    for(int i = 0; i<pokedex.length; i++){
      String[] line = lines[i+1].split("\t");
      pokedex[i] = new Pokemon(line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]), seed);
    }
  }


  public Pokedex(String filename, long seed)
  {
    String[] lines = Main.fileToArray(filename);
    pokedex = new Pokemon[lines.length - 1];
    for(int i = 0; i<pokedex.length; i++){
      String[] line = lines[i+1].split("\t");
      pokedex[i] = new Pokemon(line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]), seed);
    }
  }


  public Pokedex(String filename, String delimiter, long seed)
  {
    String[] lines = Main.fileToArray(filename);
    pokedex = new Pokemon[lines.length - 1];
    for(int i = 0; i<pokedex.length; i++){
      String[] line = lines[i+1].split(delimiter);
      pokedex[i] = new Pokemon(line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]), seed);
    }
  }


  public int length()
  {
    return pokedex.length;
  }

  public Pokemon getByNumber(int pokedexID)
  {
    return pokedex[pokedexID - 1];
  }

}