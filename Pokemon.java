import java.util.Random;

/**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy. If necessary, additional paragraphs should
 * be preceded by <p>, the html tag for a new paragraph.)
 *
 * @author Graeme Melrose
 */
public class Pokemon {
  // Pokédex Entry
  private String name = null;

  // Pokémon's Type defenses
  private String type = null;
  private String weakness = null;

  // Pokémon's Base Stats
  private int baseHitPoints = 0;
  private int baseSpeed = 0;
  private int baseAttack = 0;
  private int baseDefense = 0;

  // Pokémon's Individual Values
  private int hitPointsIV = 0;
  private int speedIV = 0;
  private int attackIV = 0;
  private int defenseIV = 0;

  // Pokémon's Current Stats
  private int hitPoints = 0;
  private int hitPointsRemaining = 0;
  private int speed = 0;
  private int attack = 0;
  private int defense = 0;
  private int level = 0;
  

  /**
  * Create a level 1 Pokémon with the given parameters.
  * 
  * @param name The Pokémon's Name as listed in the Pokédex.
  */
  public Pokemon(String name) 
  {

  }
  

  /**
  * Create a level 1 Pokémon with the given parameters.
  * 
  * @param name The Pokémon's Name as listed in the Pokédex.
  * @param seed Fixed random seed for IV generation.
  */
  public Pokemon(String name, long seed) 
  {

  }
  

  /**
  * Create a level 1 Pokémon with the given parameters.
  * 
  * @param name The Pokémon's Name as listed in the Pokédex.
  * @param type The Pokémon's primary Type.
  * @param weakness The Pokémon's primary Weakness.
  * @param hitPoints The Pokémon's base Hit Points.
  * @param speed The Pokémon's base Speed.
  * @param attack The Pokémon's base Attack.
  * @param defense The Pokémon's base Defense.
  */
  public Pokemon(String name, String type, String weakness, int hitPoints, int speed, int attack, int defense) 
  {
    this.name = name;

    this.type = type;
    this.weakness = weakness;

    this.baseHitPoints = hitPoints;
    this.baseSpeed = speed;
    this.baseAttack = attack;
    this.baseDefense = defense;

    Random rnd = new Random();
    this.hitPointsIV = rnd.nextInt(16);
    this.speedIV = rnd.nextInt(16);
    this.attackIV = rnd.nextInt(16);
    this.defenseIV = rnd.nextInt(16);

    this.level = 0;
    this.levelUP();
  }
  

  /**
  * Create a level 1 Pokémon with the given parameters.
  * 
  * @param name The Pokémon's Name as listed in the Pokédex.
  * @param type The Pokémon's primary Type.
  * @param weakness The Pokémon's primary Weakness.
  * @param hitPoints The Pokémon's base Hit Points.
  * @param speed The Pokémon's base Speed.
  * @param attack The Pokémon's base Attack.
  * @param defense The Pokémon's base Defense.
  * @param seed Fixed random seed for IV generation.
  */
  public Pokemon(String name, String type, String weakness, int hitPoints, int speed, int attack, int defense, long seed) 
  {
    this.name = name;

    this.type = type;
    this.weakness = weakness;

    this.baseHitPoints = hitPoints;
    this.baseSpeed = speed;
    this.baseAttack = attack;
    this.baseDefense = defense;

    Random rnd = new Random(seed);
    this.hitPointsIV = rnd.nextInt(16);
    this.speedIV = rnd.nextInt(16);
    this.attackIV = rnd.nextInt(16);
    this.defenseIV = rnd.nextInt(16);

    this.level = 0;
    this.levelUP();
  }


  /**
  * Returns the name of this Pokémon.
  *
  * @return The name of this Pokémon.
  */
  public String getName()
  {
    return name;
  }


  /**
  * Returns the type of this Pokémon.
  *
  * @return The type of this Pokémon.
  */
  public String getType()
  {
    return type;
  }
  

  /**
  * Returns the weakness of this Pokémon.
  *
  * @return The weakness of this Pokémon.
  */
  public String getWeakness()
  {
    return weakness;
  }
  

  /**
  * Returns the hit points of this Pokémon.
  *
  * @return The hit points of this Pokémon.
  */
  public int getHitPoints()
  {
    return hitPoints;
  }
  

  /**
  * Returns the current remaining hit points of this Pokémon.
  *
  * @return The current remaining hit points of this Pokémon.
  */
  public int getHitPointsRemaining()
  {
    return hitPointsRemaining;
  }
  

  /**
  * Returns the speed of this Pokémon.
  *
  * @return The speed of this Pokémon.
  */
  public int getSpeed()
  {
    return speed;
  }
  

  /**
  * Returns the attack of this Pokémon.
  *
  * @return The attack of this Pokémon.
  */
  public int getAttack()
  {
    return attack;
  }
  

  /**
  * Returns the defense of this Pokémon.
  *
  * @return The defense of this Pokémon.
  */
  public int getDefense()
  {
    return defense;
  }
  

  /**
  * Returns the level of this Pokémon.
  *
  * @return The level of this Pokémon.
  */
  public int getLevel()
  {
    return level;
  }


  /**
  * Fully heals this Pokémon.
  *
  */
  public void heal()
  {
    hitPointsRemaining = hitPoints;
  }


  /**
  * Heals this Pokémon by healthRestored. If the total health is greater than the 
  * maximum hitpoints, the Pokémon will instead be healed to full.
  *
  * @param healthRestored The amount of health to be restored.
  */
  public void heal(int healthRestored)
  {
    hitPointsRemaining = Math.min((hitPointsRemaining + healthRestored), hitPoints);
  }


  /**
  * Levels up the Pokémon once.
  * Increases the statistics of the Pokémon, and returns it to full health.
  * This method uses the Generation I/II formula for leveling, without the inclusion of
  * Effort Values.
  *
  * Hit points are determined by HP = ⌊((2 x Base + IV) x Level) / 100⌋ + Level + 10. 
  *
  * Other stats are determined by OtherStat = ⌊((2 x Base + IV) x Level) / 100⌋ + 5.
  *
  */
  public void levelUP()
  {
    if(level<100){
      hitPoints = (((2 * baseHitPoints + hitPointsIV) * level) / 100) + level + 10;
      speed = (((2 * baseSpeed + speedIV) * level) / 100) + 5;
      attack = (((2 * baseAttack + attackIV) * level) / 100) + 5;
      defense = (((2 * baseDefense + defenseIV) * level) / 100) + 5;

      level += 1;
    }
    this.heal();
  }


  /**
  * Levels up the Pokémon xLevel times.
  * Increases the statistics of the Pokémon, and returns it to full health.
  * This method uses the Generation I/II formula for leveling, without the inclusion of
  * Effort Values.
  *
  * Hit points are determined by HP = ⌊((2 x Base + IV) x Level) / 100⌋ + Level + 10. 
  *
  * Other stats are determined by OtherStat = ⌊((2 x Base + IV) x Level) / 100⌋ + 5.
  *
  * @param xLevel The amount of levels to increase by, maximum level is 100.
  */
  public void levelUP(int xLevel)
  {
      if(xLevel>0){
        this.levelUP();
        this.levelUP(xLevel - 1);
      }
  }


  /**
  * Pretty print the Pokémon to console.
  *
  */
  public void print()
  {
    System.out.println(name + "\t" + type + "\t" + weakness + "\t" + hitPoints + "\t" + speed + "\t" + attack + "\t" + defense + "\t" + level);
  }


}