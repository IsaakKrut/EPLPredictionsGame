/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvcmaven.premierleaguepredictiongame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author Isaak
 */
public class Utils {
    
    
    // Sends a HTTP GET Request to a REST API 
    // and saves the response to a file to be read from later
    
    static void loadTable(String filename){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague/table")
                .get()
                .addHeader("x-rapidapi-host", "heisenbug-premier-league-live-scores-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "70727e2265msh355a2ad6cc067fap12d830jsnff739d47a6ed")
                .build();
        
        Response response = null;

        try{
        response = client.newCall(request).execute();     
        
        FileWriter file = new FileWriter(filename);
        //writing response from the API to a file
            file.write(response.body().string());
            file.flush();
 
        } catch (IOException e) {
        }
        
        
    }
    
    // Loads up the players from the file in the parameters
    
    static List<Player> getPlayers(String filename) throws FileNotFoundException{
        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);
        
        
        
        List<Player> players = new ArrayList<>();
        int idCount = 0;
        
        while (in.hasNextLine()){
            idCount++;
            String str = in.nextLine();
            String[] tokens = str.split(",");
            if (tokens.length != 7){
                continue;
            }
            else{
                List<String> teams = new ArrayList<>();
                for (int i = 1; i < 7; i++){
                teams.add(tokens[i]);
            }
                Player player = new Player(tokens[0], teams, idCount);
                players.add(player);
            }
        }
        return players;
    }
    
   // Calculates the results for each player based on the rules and prints them
   // to the default choice of output, as well as a file
    
    static void printResults(List<Player> players, Table table){
        
        StringBuilder output = new StringBuilder();
        players.forEach((player) -> {
            int points = 0;
            
            List<String> teams = player.getTeams();
            for (int i = 0; i < teams.size(); i++){
                points+= 5 - Math.abs(i+1 - table.getPosition(teams.get(i)));
            }
            output.append(player.getName() + ". " + points + " points\n");
        });
        System.out.println(output);
        try(FileWriter file = new FileWriter("C:\\Users\\Isaak\\Desktop\\BetResults.txt")){
        //writing response from the API to a file
            file.write(output.toString());
            file.flush();
 
        } catch (IOException e) {
        }
    }
    
     
    
}
