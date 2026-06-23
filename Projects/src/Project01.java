/*
AUTHOR: Rodney Dennise
DATE: 06/23/2026
Code Description
A program to find the tallest basketball player whose age is less than or equal to the average of all the players.
*/

import java.util.*;
public class Project01 {

// Height class to represent the height of a player; in feet, inches and also converts feet to inches
    public static class Height { 
        private final double feet; // Height in feet
        private final double inches; // Height in inches

        public Height(double feet, double inches) { // Constructor to initialize height
            this.feet = feet;            // Initialize feet
            this.inches = inches;       // Initialize inches
        }

        public double toInches() {     // Convert height to inches
            return feet * 12 + inches; 
        }
     

        public String toString() {    // Convert height to a readable string
            if (inches > 12.0) {
                return(feet + inches / 12.0) + " ' " + (inches % 12) + " \" "; // if inches > 12, converts remainder and quotient to feet and inches
            }
            else {
                return feet + " ' " + inches + " \" ";  // Return the height in a readable format
            }
        }

    }
// Player class to represent a player object with name, age, and height
    public static class Player {
        private final String name;   // Name of the player
        private final int age;      // Age of the player
        private final Height height; // Height of the player

        public Player(String name, int age, Height height) {   // Constructor to initialize a player
            this.name = name;  // Initialize name
            this.height = height; // Initialize height
            this.age = age;      // Initialize age
        }
        public String getName() { // Get the name of the player
            return name;
        }

        public Height getHeight() { // Get the height of the player
            return height;
        }

        public int getAge() { // Get the age of the player
            return age; 
        }

        public String toString() { // Get the string representation of the player
            return "Player{" + "name='" + name + '\'' + ", age=" + age + ", height=" + height +'}';
        }
    }

    // Project1 class to contain the main method and logic for the program
    public static class Project1 { 
        public static void main(String[] args) {
            // Example usage
            Scanner scanner = new Scanner(System.in); // Create a scanner to read input
            ArrayList<Player> players = new ArrayList<>(); // Create an array list to store player objects
            int totalAge = 0;// Calculate the total age of all players
            double averageAge = 0;// Calculate the average age of all players

            while (true) { // Loop to continuously read player data and calculate the average age
                
                System.out.println("Enter player name, age, height (feet), and height (inches) (or 'quit' to exit):");
                String name = scanner.nextLine();
                if (name.equals("quit")) {
                    break;
                }
               
                int age = scanner.nextInt();    // Read the age of the player and store it
                double feet = scanner.nextDouble();   // Read the height of the player in feet and store it
                double inches = scanner.nextDouble();   // Read the height of the player in inches and store it
                
                scanner.nextLine(); // Consume the newline character to avoid issues with the next input

                Height height = new Height(feet, inches); // Create a Height object with the player's height
                Player player = new Player(name, age, height);     // Create a Player object with the player's data
                players.add(player); // Add the player to the list of players
                totalAge += age; // Add the player's age to the total age
            }

            if (players.isEmpty()) { // Check if no player data was entered
                System.out.println("No player data entered.");
            } else {
                averageAge = (double) totalAge / players.size(); // Calculate the average age of all players if there is data available
                System.out.println("Average age of all players: " + averageAge);

                int tallestPlayer = 0; // Index of the tallest player
                double maxHeight = 0; // Maximum height found so far

                for (int i = 0; i < players.size(); i++) { // Iterate through all players
                    Player player = players.get(i);  // Get the current player
                    double heightInches = player.getHeight().toInches(); // Convert the player's height to inches

                    if (player.getAge() < averageAge && heightInches > maxHeight) { //  Check if the player is younger than the average age and is taller than the current tallest player
                        maxHeight = heightInches;   // Update the maximum height
                        tallestPlayer = i; // Update the index of the tallest player
                    }
                }

                if (tallestPlayer >= 0) { // Check if a tallest player was found
                    System.out.println("Tallest player whose age is less than the average age: " + players.get(tallestPlayer));
                } 
            }
        }
    }
}



