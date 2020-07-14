/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premierleaguepredictiongame.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Isaak
 */
public class Table {
    
    private List<Team> table = new ArrayList<>();
    
    
    public Table(String filename){
        try{
        this.setTable(filename);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    void setTable(String filename) throws FileNotFoundException{
        
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(filename))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            
            JSONObject teams = (JSONObject) obj;
            Object teamRecords = teams.get("records");
            JSONArray teamsList = (JSONArray) teamRecords;
            
            teamsList.forEach(team->parseTeamObject( (JSONObject) team));
            //System.out.print(teamsList);
            //System.out.println(obj);
             
            
 
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
    }
    
     private void parseTeamObject(JSONObject teamObject) 
    {
        //Get team object within list
        //JSONObject teamObject = (JSONObject) team.get("employee");
         
        //Get team name
        String name = (String) teamObject.get("team");    
         
        //Get number of matches played
        long played = (long) teamObject.get("played");  
         
       //Get number of wins
        long win = (long) teamObject.get("win");    
         
        //Get number of draws
        long draw = (long) teamObject.get("draw");  
        
        //Get number of losses
        long loss = (long) teamObject.get("loss");    
         
        //Get number of goals scored
        long goalsFor = (long) teamObject.get("goalsFor");    
         
        //Get number of goals conceded
        long goalsAgainst = (long) teamObject.get("goalsAgainst");  
        
        //Get number of points
        long points = (long) teamObject.get("points");    
        
        this.table.add(new Team( name, (int)played, (int)win, (int)draw, (int)loss, (int)goalsFor, (int)goalsAgainst, (int)points));
    }
     
     
     // Getters and Setters
    
    public int getPosition(String teamName){
        for (int i = 0; i < this.table.size(); i++){
           if (table.get(i).getName().equals(teamName)){
               return i+1;
           }
       }
       return 0;
    }
    
    public void printTable(){
        table.forEach(System.out::println);
    }
}
