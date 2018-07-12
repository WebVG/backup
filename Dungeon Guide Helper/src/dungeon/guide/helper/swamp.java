/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.guide.helper;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fluxu
 */
public class swamp {
    
    Scanner scan = new Scanner(System.in);
    String next;
    public String[] swamp = null;
        
    public void options(){
        System.out.println("CONTROLS");
        System.out.println("movement: north || east || south || west ");
        System.out.println("attack: north || east || south || west ");  // needs expanded see actions function
    }
    public void actions(){
        // player functions go here
        
    }
    
    public void swampGo(){
        options();
        System.out.println("The swamp is desolate and rugged. There is a narrow path in between large puddles and brush, which direction do you want to go?");
        next = scan.nextLine();
        switch(next){
            case "north":               // the first choice was made
                System.out.println("The path twists and turns into a deeper part of the swamp. The woods become dense and you notice a backpack. which direction do you want to go?");
                scan.nextLine();
                String cNorth = scan.nextLine();
                    if(cNorth == "north"){
                        System.out.println("Deeper into the woods you travel and as time passes it gets darker or so you think. You reach a fork which way do you go?");
                        scan.nextLine();
                        String cNorth2 = scan.nextLine();
                    }
                    if(cNorth == "east"){
                        System.out.println("You are at a ledge over looking a path. That path is narrow and very close to a dark mountain side. The trees are thin here and some birds fly past. which way do you want to go? ");
                        scan.nextLine();
                        String cNorth2 = scan.nextLine();
                    }
                    if(cNorth == "south"){ // they went backwards?
                        System.out.println("You travel back to the swamp path that you started at. The other way seems different after looking at it from above. which way do you want to go?");
                        scan.nextLine();
                        String cNorth2 = scan.nextLine();
                    }
                    if(cNorth == "west"){
                        System.out.println("The west is filled with police that beat people for having feelings and shoot kids. Which way do you wanna go?");
                        scan.nextLine();
                        String cNorth2 = scan.nextLine();
                    }
                break;
            case "east":
                System.out.println("Traveling off the beaten path seems like a bad idea at first because the swamp has such dense forestry.");
                String cEast = scan.nextLine();
                    if(cEast == "north"){
                        System.out.println("Following the path proves useless, and the dense forest it too much to head up the hill so you go around.");
                    }
                    if(cEast == "east"){
                        System.out.println();
                        
                    }
                    if(cEast == "west"){
                        System.out.println();
                        
                    }
                    if(cEast == "south"){
                        System.out.println();
                        
                    }
                break;
            case "south":
                break;
            case "west":
                break;
        }
    }
    
    
    
}
