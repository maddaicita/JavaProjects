

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Maday
 */
public class Statistics {

   public ArrayList<humanPlayer> statistics;
   
  
   public Statistics(){
   
   statistics= new ArrayList<>();
  
   }

   public ArrayList<humanPlayer> getStatistics() {
        return statistics;
    }

   
   public void insertPlayer(humanPlayer p) {
        this.statistics.add(p);

    }
   
   
   // show statistics---------------------------------------------------------------------------
   
   public void showStatistics(String player1, String player2)
   {
   boolean found= false;
   int i=0;
   while(!found && i<statistics.size())
   {
       if(statistics.get(i).getName().compareToIgnoreCase(player1)==0)
       {
           found=true;
       } 
       else 
       {
           i++;
       }
   }
   
   if (found) {
                System.out.print("#################################    STATISTICS     #################################");
		System.out.print("\nSTATISTICS\n\n");
		System.out.print("Players\t\tRounds:\tWins\tLoss\tTies\t\tGames:\tWins\tLoss\tTies\n");
		System.out.print(statistics.get(i).getName() +"\t\t\t " + statistics.get(i).getWin()  + "\t " + statistics.get(i).getLoss()  + "\t " + statistics.get(i).getTied());
                System.out.print("\t\t\t " + statistics.get(i).getGameWin()  + "\t " + statistics.get(i).getGameLost()  + "\t " + statistics.get(i).getGameTied() + "\n");
                System.out.print(statistics.get(i+1).getName() +"\t\t\t " + statistics.get(i+1).getWin()  + "\t " + statistics.get(i+1).getLoss()  + "\t " + statistics.get(i+1).getTied());
                System.out.print("\t\t\t " + statistics.get(i+1).getGameWin()  + "\t " + statistics.get(i+1).getGameLost()  + "\t " + statistics.get(i+1).getGameTied() + "\n");
                System.out.print("\n#####################################################################################\n\n");
                
                overallWinner(player1,player2);
   }
   else{
       
       statistics.add(new humanPlayer(player1));
       statistics.add(new humanPlayer(player2));
       
       System.out.print("#################################    STATISTICS     #################################");
		System.out.print("\nSTATISTICS\n\n");
		System.out.print("Players\t\tRounds:\tWins\tLoss\tTies\t\tGames:\tWins\tLoss\tTies\n");
		System.out.print(statistics.get(i).getName() +"\t\t\t " + statistics.get(i).getWin()  + "\t " + statistics.get(i).getLoss()  + "\t " + statistics.get(i).getTied());
                System.out.print("\t\t\t " + statistics.get(i).getGameWin()  + "\t " + statistics.get(i).getGameLost()  + "\t " + statistics.get(i).getGameTied() + "\n");
                System.out.print(statistics.get(i+1).getName() +"\t\t\t " + statistics.get(i+1).getWin()  + "\t " + statistics.get(i+1).getLoss()  + "\t " + statistics.get(i+1).getTied());
                System.out.print("\t\t\t " + statistics.get(i+1).getGameWin()  + "\t " + statistics.get(i+1).getGameLost()  + "\t " + statistics.get(i+1).getGameTied() + "\n");
                System.out.print("\n#####################################################################################\n\n");
       
                System.out.print("There is no record to show, you have to play first");
   }
  
       
   }
   
   
   
  // Determine Overall winner---------------------------------------------------------------------------
 

	public void overallWinner(String player1,String player2)
	{		
		System.out.print("\n");
                int p=0;
               humanPlayer[] playerh= new humanPlayer[2];
               
               if(statistics == null || statistics.isEmpty())
                  {
                   playerh[0]= new humanPlayer(player1);
                   playerh[1]=new humanPlayer(player2); 
                   
                  }
               else
               {
                
               for(int i=0; i<statistics.size(); i++)
               {
                if(statistics.get(p).getName().compareToIgnoreCase(player1)==0)
                {
                 
                 playerh[0]=statistics.get(p);
                 playerh[1]=statistics.get(p+1);   
                          
                }
               }
               }
               
               
               
                
		
                                      
               //same numbers of wins, losses and ties.Is Tied         
               if (playerh[0].getGameWin() == playerh[1].getGameWin())
		                       
		{  
                    if(playerh[0].getGameLost() == playerh[1].getGameLost())//
			{
			  if(playerh[0].getGameTied() == playerh[1].getGameTied())
				{
					System.out.print("######################" + playerh[0].getName() + " and " + playerh[1].getName() + " are tied! ######################");
				}
                          
                          //If  player 1 has more ties than the player2 or viceversa
			   else if(playerh[0].getGameTied() > playerh[1].getGameTied())
				{
					System.out.print("######################" + playerh[0].getName() + " is the winner ######################");
				}
				else
				{
					System.out.print("######################" + playerh[1].getName() + " is the winner ######################");
				}
			}
                    
                    //if player 1 have less loses or win
			else if(playerh[0].getGameWin() < playerh[1].getGameWin())
			{
				System.out.print("######################" + playerh[0].getName() + " is the winner ######################");
			}
			else
			{
				System.out.print("######################" + playerh[1].getName() + " is the winner ######################");
			}
		}
		else if(playerh[0].getGameLost()< playerh[1].getGameLost())
		{
			System.out.print("\t\t\t\t\t\t" + playerh[0].getName() + " is the winner");
		}
		else
		{
			System.out.print("######################" + playerh[1].getName() + " is the winner ######################");
		}
	}	 
   
   
   
   
   
   
}
  




   
   
   

   
   

  
   
    
   
  
  
    

