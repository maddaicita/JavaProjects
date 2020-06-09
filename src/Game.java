

/*
 contains all the logic to play a game consisting of 3 rounds
 a)Must have a method to display rules for winning and
basic instructions how game is played (based on the requirements given)
 b)Must have all the logic for playing automatically 3 rounds and
announce winners of each round and winners of each game (based on the requirements given)

 */



import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Maday
 */
public class Game {
 
  private final Scanner playerInput = new Scanner(System.in);

   
   private final humanPlayer[] playerh= new humanPlayer[2];

   
   
   private final int[][] rulesArray = new int[5][5];// rules array 1st row is for rock,2nd row is for paper and so on

   Game(humanPlayer player1, humanPlayer player2) { // Game constructor
       
       
      playerh[0] = player1;

       playerh[1] = player2;

       rulesArray[1][1] = -1; // column refers to the opponent, rock vs rock =-1

       rulesArray[1][2] = 0; // rock loses against paper, hence rulesArray[1][2]=0, 2nd column is for paper

       rulesArray[1][3] = 1; // rock wins against scissors, hence rulesArray[1][3]=1, 3rd column is for scissors

       rulesArray[1][4] = 1;

       rulesArray[2][1] = 1;

       rulesArray[2][2] = -1;

       rulesArray[2][3] = 0;

       rulesArray[2][4] = 0;

       rulesArray[3][1] = 0;

       rulesArray[3][2] = 1;

       rulesArray[3][3] = -1;

       rulesArray[3][4] = 0;

       rulesArray[4][1] = 0;

       rulesArray[4][2] = 1;

       rulesArray[4][3] = 1;

       rulesArray[4][4] = -1;

   }


   
   
   
   public void playGame(humanPlayer player1,humanPlayer player2) 
   
   
   { // method to play game
       
       //instance for the computer to acces the weapon function and get selection
     
      String nameComp="computer";
      computerPlayer computer=new computerPlayer(nameComp);
    
     
      
      
      
      // weapon instance to get the list of weapons to display the weapon selection
     weapons weaponInst= new weapons();
     List<String> weaponsList = weaponInst.getWeaponList();
       
       
       playerh[0].setWin(0);
       playerh[0].setLoss(0);
       playerh[0].setTied(0);
       playerh[0].setGameLost(0);
       playerh[0].setGameWin(0);
       playerh[0].setGameTied(0);

       playerh[1].setWin(0);
       playerh[1].setLoss(0);
       playerh[1].setTied(0);
       playerh[1].setGameLost(0);
       playerh[1].setGameWin(0);
       playerh[1].setGameTied(0);
       
       
       
       int round = 1;

       while (round <= 3) {
        System.out.print("\n#######################\n");
        System.out.println("######"+"  ROUND:" + round+ "  ######"); 
        System.out.print("#######################\n");          
      //variables to hold the weapon selections
      System.out.println(playerh[0].getName() +"'s"+ " turn:\n");
      int weaponP1= player1.selectWeapon();
      System.out.println(playerh[1].getName() + "'s"+ " turn:\n");
      int weaponP2 = player2.selectWeapon();
      int weaponC = computer.selectWeapon();
           

           // use the matrix representation array to declare winner
           
        
           System.out.print("****************************************\n");
           System.out.print("****************************************\n");
           System.out.println(playerh[0].getName() + " selected :" + weaponsList.get(weaponP1-1));
           System.out.println("Computer" + " selected :" + weaponsList.get(weaponC-1));
           
           switch (rulesArray[weaponC][weaponP1]) {
               case 1:              
                   System.out.println("computer won\n");
                   System.out.print("****************************************\n");
                   playerh[0].setLoss(playerh[0].getLoss() + 1);
                   
                   
                   break;
               case 0:
                   System.out.println(playerh[0].getName() + " won\n");
                   System.out.print("****************************************\n");
                   playerh[0].setWin(playerh[0].getWin() + 1);
                   
                   
                   break;
               default:
                   System.out.println("it is a tie\n");
                   System.out.print("****************************************\n");
                   playerh[0].setTied(playerh[0].getTied() + 1);
                   
                   break;
           }
           
           System.out.print("****************************************\n");
           System.out.println(playerh[1].getName() + " selected :" + weaponsList.get(weaponP2-1));
           System.out.println("Computer" + " selected :" + weaponsList.get(weaponC-1));
           

           switch (rulesArray[weaponC][weaponP2]) {
               case 1:
                   // second player chooses w2
                   
                   // weapon, check in rules array
                   
                   System.out.println("computer won\n");
                   System.out.print("****************************************\n");
                   System.out.print("****************************************\n\n");
                  
                   playerh[1].setLoss(playerh[1].getLoss() + 1);
                   
                   break;
               case 0:
                   System.out.println(playerh[1].getName() + " won\n");
                   System.out.print("****************************************\n");
                    System.out.print("****************************************\n\n");
                   playerh[1].setWin(playerh[1].getWin() + 1);
                  
                   break;
               default:
                   System.out.println("it is a tie\n");
                   System.out.print("****************************************\n");
                   System.out.print("****************************************\n\n");
                   playerh[1].setTied(playerh[1].getTied() + 1);
                   
                   break;
           }
        
           round++;

       }
       // calculate the game winner
       System.out.println("Game Winner : "); 

       if (playerh[0].getWin() > playerh[1].getWin()) {

           System.out.println(playerh[0].getName() + " won the game ");
            playerh[0].setGameWin(playerh[0].getGameWin() + 1);
            playerh[1].setGameLost(playerh[1].getGameLost() + 1);

       } else if (playerh[1].getWin() > playerh[0].getWin()) {

           System.out.println(playerh[1].getName() + " won the game");
           playerh[1].setGameWin(playerh[1].getGameWin() + 1);
           playerh[0].setGameLost(playerh[0].getGameLost() + 1);

       } else {

           if (playerh[0].getLoss() > playerh[1].getLoss()) {
               System.out.println(playerh[1].getName() + " won the game ");
               playerh[1].setGameWin(playerh[1].getGameWin() + 1);
               playerh[0].setGameLost(playerh[0].getGameLost() + 1);
               
           } else if (playerh[1].getLoss() > playerh[0].getLoss()) {
               System.out.println(playerh[0].getName() + " won the game");
               playerh[0].setGameWin(playerh[0].getGameWin() + 1);
               playerh[1].setGameLost(playerh[1].getGameLost() + 1);
               
           } else {
               System.out.println("It is a tie");
               playerh[1].setGameTied(playerh[1].getGameTied() + 1);
               playerh[0].setGameTied(playerh[0].getGameTied() + 1);
           }
           
         

       }

     

   }
   
   // show rules---------------------------------------------------------------------------

   public void showrules() {

    

    System.out.print("*********************************************************************************************************************\n");
    System.out.print("*********************************************************************************************************************\n");
    System.out.print(" “ROCK, PAPER, SCISSORS, AND SAW” GAME RULES\n");
    System.out.print("*********************************************************************************************************************\n");
    System.out.print("*********************************************************************************************************************\n");
    System.out.println("Two players will play against computers for three rounds:\n");
    System.out.print("Winner of the round will be determined as follow:\n");
    System.out.print( "a.Rock breaks scissors and Saw therefore rock wins over scissors and saw. Rock loses against paper.\n");
    System.out.print( "b.Scissors cut paper therefore scissors win over paper. Scissors lose against rock and Saw.\n");
    System.out.print( "c.Paper covers rock therefore paper wins over rock. Paper loses against scissors and saw.\n");
    System.out.print( "d.Saw cuts through scissors and paper therefore saw wins over scissors and paper. Saw loses against rock.\n");
    System.out.print( "e.If player and computer make the same selection, there is a tie.\n");
    System.out.print( "Winner of the game against the computer is one who won more rounds (must account for ties)\n");
    System.out.print( "Overall human winner is based on the greater number of won games against the computer. \n");
    System.out.print( "and least games lost (must account for tie between human players)\n");
    System.out.print("*********************************************************************************************************************\n");
    System.out.print("*********************************************************************************************************************\n");

   }
   
   
   
   //Game simulation------------------------------------------------------------------------------------------
   
   public void playGameSimulation(humanPlayer player1,humanPlayer player2) 
   
   
   { // method to play emulation
       
           
       playerh[0].setWin(0);
       playerh[0].setLoss(0);
       playerh[0].setTied(0);
       playerh[0].setGameLost(0);
       playerh[0].setGameWin(0);
       playerh[0].setGameTied(0);

       playerh[1].setWin(0);
       playerh[1].setLoss(0);
       playerh[1].setTied(0);
       playerh[1].setGameLost(0);
       playerh[1].setGameWin(0);
       playerh[1].setGameTied(0);
       
       
       System.out.print("How many times do you want me to play?\n");
       int times=playerInput.nextInt();
      for (int i=0; i<=times;i++ )
      {
       int round = 1;

       while (round <= 3) {

          //  weapon selections 
      int weaponP1= (int) (Math.random() * 4 + 1); 
      int weaponP2 = (int) (Math.random() * 4 + 1); 
      int weaponC =(int) (Math.random() * 4 + 1); 
           

           // use the matrix representation array to find winner
                     
           switch (rulesArray[weaponC][weaponP1]) {
               case 1:   
                   playerh[0].setLoss(playerh[0].getLoss() + 1); 
                   break;
               case 0:
                   playerh[0].setWin(playerh[0].getWin() + 1);
                   break;
               default: 
                   playerh[0].setTied(playerh[0].getTied() + 1);
                   break;
           }

           switch (rulesArray[weaponC][weaponP2]) {
               case 1:
                   playerh[1].setLoss(playerh[1].getLoss() + 1);
                   break;
               case 0:
                   playerh[1].setWin(playerh[1].getWin() + 1);
                   break;
               default:
                   playerh[1].setTied(playerh[1].getTied() + 1);
                   break;
           }
        
           round++;

       }
       // find the game winner
   

       if (playerh[0].getWin() > playerh[1].getWin()) {
            playerh[0].setGameWin(playerh[0].getGameWin() + 1);
            playerh[1].setGameLost(playerh[1].getGameLost() + 1);

       } else if (playerh[1].getWin() > playerh[0].getWin()) {
           playerh[1].setGameWin(playerh[1].getGameWin() + 1);
           playerh[0].setGameLost(playerh[0].getGameLost() + 1);
       } else {

           if (playerh[0].getLoss() > playerh[1].getLoss()) {
               
               playerh[1].setGameWin(playerh[1].getGameWin() + 1);
               playerh[0].setGameLost(playerh[0].getGameLost() + 1);
               
           } else if (playerh[1].getLoss() > playerh[0].getLoss()) {
               
               playerh[0].setGameWin(playerh[0].getGameWin() + 1);
               playerh[1].setGameLost(playerh[1].getGameLost() + 1);
               
           } else {
              
               playerh[1].setGameTied(playerh[1].getGameTied() + 1);
               playerh[0].setGameTied(playerh[0].getGameTied() + 1);
           }
           
         

       }
      }
      
     
     

   }
   
   
   
   

}
    

