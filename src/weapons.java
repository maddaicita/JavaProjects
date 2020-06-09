

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maday
 */
public class weapons {
    
    private final String weapon1="1.Rock";
    private final String weapon2="2.Paper";
    private final String weapon3="3.Scissors";
    private final String weapon4="4.Saw";
    
    private final List<String> weapon;
    
    public weapons()
    {
    weapon=new ArrayList<>();
    weapon.add(weapon1);
    weapon.add(weapon2);
    weapon.add(weapon3);
    weapon.add(weapon4);
    }
    public List<String> getWeaponList() {
       return weapon;
   }
   
}
