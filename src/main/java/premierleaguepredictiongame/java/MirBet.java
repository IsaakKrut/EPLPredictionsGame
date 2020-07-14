/*
This game is played by me and my friends and this project is designed to
calculate the results and identify the winner.
 */
package premierleaguepredictiongame.java;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Isaak
 */
public class MirBet {
    
    static String playersFile = "src\\main\\java\\premierleaguepredictiongame\\data\\players.txt";
    static String tableFile = "src\\main\\java\\premierleaguepredictiongame\\data\\PremierLeagueTable.json";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Prompt to reload the table and save it to a json file
        // due to a limited number of allowed API calls per month
        String s = null;
        Scanner sc = new Scanner(System.in);
        
        do{
        System.out.println("Would you like to load the table? (Y/N)");
        s = sc.next();
        
        } while(!s.equals("Y") & !s.equals("y") & !s.equals("N") & !s.equals("n"));
        
        
        if(s.equals("Y") || s.equals("y")){
            Utils.loadTable(tableFile);
        }        
        
        
        List<Player> players = new ArrayList<>();
        Table table = null;
        
           
        // load up the players and the table from the corresponding files
        try{
            players = Utils.getPlayers(playersFile);
            table = new Table(tableFile);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
        
        // Calculate the results and output them to standard output and a result file
        if (players != null && table!= null){
            Utils.printResults(players, table);
        }
        
    }
    
}
