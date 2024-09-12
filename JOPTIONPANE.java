/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import javax.swing.JOptionPane;
/**
 *
 * @author DANCEL_ICS105
 */
public class Mavenproject1 {

  

    public static void main(String[] args) 
    { 
        
        Object[] options = { "Yes", "No", "Cancel" }; 
  
        
        int choice = JOptionPane.showOptionDialog( null,"Do you want to proceed?","Custom Options",JOptionPane.YES_NO_CANCEL_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, options, options[2]); 
  
      
        if (choice == JOptionPane.YES_OPTION) { 
            
            JOptionPane.showMessageDialog(null,"Proceeding..."); 
        } 
        else if (choice == JOptionPane.NO_OPTION) { 
            
            JOptionPane.showMessageDialog(null, "Not proceeding."); 
        } 
        else { 
            
            JOptionPane.showMessageDialog(null, "Operation canceled."); 
        } 
    } 
}
    

