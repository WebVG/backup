/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.guide.helper;

import java.util.Scanner;

/**
 *
 * @author Fluxu
 */
public class storyTemp {        // String to hold player level selection - should pass through IF statements //


    public static void intro() {
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println("    INSTRUCTIONS     ");
        System.out.println("_____________________");
    }

    public void story() {
        intro();
        System.out.println("Level select pick one");
        System.out.println("|| swamp || ocean || dungeon ||");
        Scanner scan = new Scanner(System.in);
        String level; // use this to change menu you are in
        level = scan.nextLine();
        do {
            Scanner choice = new Scanner(System.in);
            String nextMove;
            switch (level) {
                case "restart":
                    intro();
                    level = scan.nextLine();
                    break;
                case "swamp":
                        swamp s = new swamp();
                        s.swampGo();
                        break;
                case "ocean":
                        System.out.println("The ocean seems to go on into the horizon, which direction do you want to go?");
                        nextMove = choice.nextLine();
                    break;
                case "dungeon":
                        System.out.println("The dungeon door is a marble slab");
                        nextMove = choice.nextLine();
                    break;
            }
        } while (!"exit".equals(level));
    }
}
