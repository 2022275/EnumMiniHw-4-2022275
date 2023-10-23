/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */ 


// GitHub Link: https://github.com/2022275/EnumMiniHw-4-2022275
package enumminihw.pkg4.pkg2022275;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EnumMiniHw42022275 {



    public static void main(String[] args) {
        String filePath = "D:\\User Data\\Documents\\NetBeansProjects\\EnumMiniHw-4-2022275\\MOCK_DATA.csv";  //the path to find the file
        
        List<String> allData = new ArrayList<>(); //// I'm making a array list to keep all the lines from the file in it.
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { //opening and reading the file here
            String line; // Keep reading lines from the file until there's nothing left.
            while ((line = br.readLine()) != null) {
                allData.add(line);  // Put each line into our array
            }
        } catch (IOException e) { // If something goes wrong with reading the file this message will show up
            System.out.println("No possible reading the file");
        }
       
        Collections.shuffle(allData); // Mix up all the names randomly for making the teams
        
        List<List<String>> teams = new ArrayList<>(); //  Make another array to keep our teams.
        for (int i = 0; i < allData.size(); i += 5) { 
            if (i + 4 < allData.size()) {  // Check if there are enough names left to make a team of 5.
                List<String> team = allData.subList(i, i + 5); // Grab 5 names at a time and make a team
                teams.add(team); // Add this team to our teams array
            }
        }

        // Make a tool to pick random numbers.
        Random r = new Random();  //
        for (int i = 0; i < teams.size(); i++) {
            String teamName = getRandomTeamName(r); // Go through each team and give it a random name
            System.out.println("Team " + (i + 1) + " (" + teamName + "):"); // Show the team number, its cool name, and all its members.
            for (String member : teams.get(i)) {
                System.out.println(member); // Show each team member's name.
            }
            System.out.println("-----------------"); // to separate the teams...
        }
    }

    private static final String[] FIRST = {  // first team cool names list to be selected randomly
        "Nitro", "Torque", "Asphalt", "Redline", "Turbo", "Circuit", "Overdrive", "Gearshift", 
        "Lane", "Pinnacle", "Raceway", "Octane", "Throttle", "Burnout", "Veloce", "Dragstrip", "Pulse Pedal"
    };

    private static final String[] SECOND = { // second team cool names list to be selected randomly
        "Lions", "Tigers", "Knights", "Hawks", "Eagles", "Wolves", "Cyclones", "Renegades", "Thrashers",
        "Panthers", "Sharks", "Dragons", "Phoenixes", "T-Rex", "Titans", "Overlords", "Pursuers"
    };
    private static String getRandomTeamName(Random r) { // This function picks one word from each box and sticks them together for a cool team name.
        String first = FIRST[r.nextInt(FIRST.length)];
        String second = SECOND[r.nextInt(SECOND.length)];
        return first + " " + second;
    }
}

