



import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Maday
 */
public class humanPlayer extends Player {

    
   private Scanner playerInput = new Scanner(System.in);
    
   private String name;
   private int win; 
   private int loss; 
   private int tied;
   private int gameLost;
   private int gameWin;
   private int gameTied;
   private weapons weaponHuman; 
   
   private Statistics stat; // statistics for player
    
    humanPlayer(String player) {

       name = player;
       win=0;
       loss=0;
       tied=0;
       gameLost=0;
       gameWin=0;
       gameTied=0;

   }

    
    /**
     * @return the playerInput
     */
    public Scanner getPlayerInput() {
        return playerInput;
    }

    /**
     * @param playerInput the playerInput to set
     */
    public void setPlayerInput(Scanner playerInput) {
        this.playerInput = playerInput;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the win
     */
    public int getWin() {
        return win;
    }

    /**
     * @param win the win to set
     */
    public void setWin(int win) {
        this.win = win;
    }

    /**
     * @return the loss
     */
    public int getLoss() {
        return loss;
    }

    /**
     * @param loss the loss to set
     */
    public void setLoss(int loss) {
        this.loss = loss;
    }

    /**
     * @return the tied
     */
    public int getTied() {
        return tied;
    }

    /**
     * @param tied the tied to set
     */
    public void setTied(int tied) {
        this.tied = tied;
    }

    /**
     * @return the gameLost
     */
    public int getGameLost() {
        return gameLost;
    }

    /**
     * @param gameLost the gameLost to set
     */
    public void setGameLost(int gameLost) {
        this.gameLost = gameLost;
    }

    /**
     * @return the gameWin
     */
    public int getGameWin() {
        return gameWin;
    }

    /**
     * @param gameWin the gameWin to set
     */
    public void setGameWin(int gameWin) {
        this.gameWin = gameWin;
    }

    /**
     * @return the gameTied
     */
    public int getGameTied() {
        return gameTied;
    }

    /**
     * @param gameTied the gameTied to set
     */
    public void setGameTied(int gameTied) {
        this.gameTied = gameTied;
    }

    /**
     * @return the weaponHuman
     */
    public weapons getWeaponHuman() {
        return weaponHuman;
    }

    /**
     * @param weaponHuman the weaponHuman to set
     */
    public void setWeaponHuman(weapons weaponHuman) {
        this.weaponHuman = weaponHuman;
    }

    /**
     * @return the stat
     */
    public Statistics getStat() {
        return stat;
    }

    /**
     * @param stat the stat to set
     */
    public void setStat(Statistics stat) {
        this.stat = stat;
    }
   
    @Override
    public int selectWeapon() {
        setWeaponHuman(new weapons());
     List<String> weaponsList = getWeaponHuman().getWeaponList();
     
     System.out.println("Select Weapon :" + getName());
     weaponsList.forEach(System.out::println);
     int weaponSelected = getPlayerInput().nextInt();
     
     while(weaponSelected < 1 || weaponSelected > 4){
       System.out.println("Please enter a number between 1 and 4");
       System.out.println("Select Weapon :" + getName());
       weaponsList.forEach(System.out::println);
       weaponSelected = getPlayerInput().nextInt();
     }
      return weaponSelected;
      }
    
    
    @Override

   public String toString() {
   
   return ("\t\t\t " + win  + "\t " + loss  + "\t " + tied + "\t\t\t " + gameWin  + "\t " + gameLost  + "\t " + gameTied +"\n");
   
   }
    
}  
  