
package gamesps;

/**
 *
 * @author rovind
 */
import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Gamesps {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         Gamesps h=new Gamesps();
         h.display();
         
         int newgame=1;
         while(newgame==1){
         int keepon=1;
         int player1score=0,player2score=0;
         int totalturn=0;
         char a,b;
       	System.out.println("Welcome Stone Paper Scissor Game!!");
        System.out.println("Enter the player 1 name: ");
        String p1name=sc.next();
         System.out.println("Enter the player 2 name: ");
        String p2name=sc.next();
        while(keepon==1){
         totalturn++;
        System.out.println("Enter your choice "+p1name+" (rock/paper/scissor): ");
        String player1 = sc.next();
         System.out.println("Enter your choice "+p2name+" (rock/paper/scissor): ");
        String player2 = sc.next();
         if(player1.equals(player2)){
                System.out.println("Tie");
        }else if(player1.equals("rock")&&player2.equals("scissor") ||player1.equals("paper")&&player2.equals("rock") || player1.equals("scissor")&&player2.equals("paper")){
            player1score++;
                System.out.println(""+p1name+" Win");
        }
        else if(player2.equals("rock")&&player1.equals("scissor") ||player2.equals("paper")&&player1.equals("rock")  || player2.equals("scissor")&&player1.equals("paper")){
             System.out.println(""+p2name+" Win ");
            player2score++;
        }
          System.out.println("Would You Like to continue the game ? (y/n)");
          a =  sc.next().charAt(0);
          if(a=='y'){
              keepon=1;
          }else{
              keepon=0;
          }
}
        System.out.println("Total Match played : " +totalturn);
        System.out.println(""+p1name +" score " +player1score + " out of "+totalturn);
         System.out.println(""+p2name +" score " +player2score + " out of "+totalturn);
         System.out.println();
         if(player1score>player2score){
              try{
              File f=new File("data.txt");
                  try (PrintWriter pw = new PrintWriter(new FileOutputStream(f,true))) {
                      pw.append(p1name+","+player2score);
                      pw.close();
                  }
          }
          catch(FileNotFoundException e){}
             System.out.println("congratulation "+p1name +" Win the game ");
    }else if(player1score==player2score){   
     System.out.println("Match Tied!!");
}else{
         try{
              File f=new File("data.txt");
                  try (PrintWriter pw = new PrintWriter(new FileOutputStream(f,true))) {
                       pw.append(p2name+","+player2score);
                       pw.close();
                  }
          }
          catch(FileNotFoundException e){}
       System.out.println("congratulation "+p2name +" Win the game "); 
    }
        
          System.out.println("Would You Like to play new the game ? (y/n)");
           b =  sc.next().charAt(0);
           if(b=='y'){
               newgame=1;
           }else{
               newgame=0;
           }
         }
          System.out.println("Game Ended");
    }

    private void display() {
        try{
            int highscore=0,score;
        BufferedReader br=new BufferedReader(new FileReader("data.txt"));
        String S="";
        while( null !=(S=br.readLine())){
            String data[]=new String[2];
            data=S.split(",");
            for(int i=0;i<2;i++){
    
                System.out.println(data[i]+" ");
  
            }
             
            
        }
       
        }
        catch(FileNotFoundException e){} catch (IOException ex) {
            Logger.getLogger(Gamesps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
         
}
    
