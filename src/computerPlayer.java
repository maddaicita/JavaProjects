



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 *
 * @author Maday
 */
public class computerPlayer extends Player{
    
   
    
    String player;
   

    public computerPlayer(String player) {
        
        this.player=player;
        
    }

    @Override
    public int selectWeapon() 
    {
        return (int) (Math.random() * 4 + 1);
       
    }
       
    
}
