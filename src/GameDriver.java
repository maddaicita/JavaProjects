



/*
GameDriver:
Includes main() method that creates instances of all the other classes,  prompts the user and then calls Game’s class methods to run the game.
a.	prompt user for names of human players
b.	display the menu and allow users to select from the menu. 
c.	create instances of the Players and initialize them
d.	store Players in a list or array
e.	create an instance of Game and start the game when user selects that option

 */


import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Maday
 */
public class GameDriver {
    
     private static final Scanner input = new Scanner(System.in);
     
     
  
    public static void main(String[] args) {
       
    System.out.print("********************************************************\n");
    System.out.print("********************************************************\n");
    System.out.print(" “ROCK, PAPER, SCISSORS, AND SAW” GAME\n");
    System.out.print("********************************************************\n");
    System.out.print("********************************************************\n");  
        
//prompt user for names of human players and validate it, then put inside the players array
//and use the names to create the plyers instances
        String[] players = ValidatePlayers();
         String player1 = players[0];
         String player2 = players[1]; 
       
 humanPlayer playerh1= new humanPlayer(player1);
 humanPlayer playerh2= new humanPlayer(player2);
 Game game = new Game(playerh1,playerh2 );
 Statistics stat=new Statistics();

//next section display the menu and allow users to select from the menu. 
        System.out.println("Please Select One Of the Following Options");

        MenuOptions menuOptions = MenuOptions.z;

        while (menuOptions != MenuOptions.e) {  
            try
            {
                menu();// called to print the menu
                
                menuOptions = MenuOptions.valueOf(input.nextLine());
         
                switch (menuOptions)
                {
                    case p:
                      //play game
                      game.playGame(playerh1,playerh2);
                      stat.insertPlayer(playerh1);
                      stat.insertPlayer(playerh2);
                     
                      
                        
                       break;

                    case r:
                        // Game Rules
                        game.showrules();                       
                        break;
                    case s:
                        //Statistics
                       
                        stat.showStatistics(player1,player2);
                       
                    
                      
                        break;
                    case m:
                        game.playGameSimulation(playerh1,playerh2);
                        Statistics statSim=new Statistics();
                        statSim.insertPlayer(playerh1);
                        statSim.insertPlayer(playerh2);
                        statSim.showStatistics(player1,player2);
                        //aqui creo otra instancia de stadisticas y llamo el metodo display statistics.
                        break;
                    case e:
                        System.out.println("Goodbye.");
                        break;
                    default:
                        System.out.println("Wrong selection. Try again");
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Selection out of range. Try again:");
            }
        }
        }
    
    
     
        
// implementation of an enum class used to define menu options
    enum MenuOptions{
    z("Continue..."), p("Play Game"), r("Display Game Rules"), 
    s("Display statistics"),m("Simulation"), e("Quit");

    
    private final String meaning;

    //getter and setter for the enum to interpret the selection enter by user
    MenuOptions(String meaning)
    {
        this.meaning = meaning;
    }

    public String getMeaning()
    {
        return meaning;
    }
    
   }
  // to print the menu options
    public static void menu()
    {
        System.out.println("\nPress:");
        System.out.println("\t. Press p to Play game");
        System.out.println("\t. Press r to Display game rules");
        System.out.println("\t. Press s to Display statistics");
        System.out.println("\t. Press m to Emulate Game.");
        System.out.println("\t. Press e to Exit.");
        System.out.print("\nSelection -> ");

    }
    
    public static String[] ValidatePlayers()
    {
       
       String[] players;
        players = new String[2];

        Scanner sc = new Scanner(System.in);
       


       while (true)

       {
           System.out.println("What is the name of the first player?");
          players[0] = sc.nextLine();
           if( players[0].length()<5 || players[0].length()>20) {
               System.out.println("Tha name must have between 5 and 20 characteres");
           }
           else {
             
               break;
           }  
       }
       
       while (true)

       {
           System.out.println("What is the name of the second player?");
           players[1]= sc.nextLine();
           
           if( players[1].length()<5 || players[1].length()>20) {
               System.out.println("Tha name must have between 5 and 20 characteres");
           }
           else if(players[0].equals(players[1])) {
               System.out.println("Enter a different name");
           } else {
               
              
               break;
           }  
       }
        
        
        
        
        
        
        
        
        
         return players;
    
    
    
    }
    
}  
    
    
    
    

    
    
    
    
    
    

