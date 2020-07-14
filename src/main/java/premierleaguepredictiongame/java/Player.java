/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premierleaguepredictiongame.java;

import java.util.List;

/**
 *
 * @author Isaak
 */
public class Player {
    
    private final int id;
    
    private String name;
    
    private List<String> teams;

    public Player(String name, List<String> teams, int id) {
        this.name = name;
        this.teams = teams;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }
    
    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        String result = this.name + ". ";
        for (int i = 0; i < teams.size(); i++){
            result+= teams.get(i) + "  ";
        };
        
        return result;
    }
    
    
    
    
}
