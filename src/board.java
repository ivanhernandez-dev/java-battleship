import java.util.Random;
import java.util.Scanner;

public class board {
    static Scanner reader = new Scanner(System.in);
    static int[][] game; // 0 = Default, 1 = Barco, 2 = Agua, 3 = Tocado
    static int shipsRemaining;
    static int shipsAmount;


    static int[] requestParameters(){
        int[] parameters = new int[3]; // [0] Height, [1] Width, [2] Size
        do{
            System.out.print("Enter the board width: ");
            parameters[0] = reader.nextInt();
            if(parameters[0]<=0){
                System.out.println("Error: Width out of range");
            }
        } while (parameters[0]<=0);
        do{
            System.out.print("Enter board height: ");
            parameters[1] = reader.nextInt();
            if(parameters[1]<=0){
                System.out.println("Error: Height out of range");
            }
        } while (parameters[1]<=0);
        do{
            System.out.print("Introduce boat amount: ");
            parameters[2] = reader.nextInt();
            if (parameters[2] == 0 || parameters[2] > (parameters[0]*parameters[1])){
                System.out.println("Error: Amount out of range [1-" + (parameters[0]*parameters[1]) + "]");
            }
        } while (parameters[2] == 0 || parameters[2] > (parameters[0]*parameters[1]));
        System.out.println();

        return parameters;
    }

    static void create(int[] parameters){
        Random random = new Random();
        int posX, posY;
        game = new int[parameters[1]][parameters[0]];
        shipsRemaining = parameters[2];
        shipsAmount = parameters[2];
        int i = 0;
        while(i < parameters[2]){
            posX = random.nextInt(0, parameters[0]);
            posY = random.nextInt(0, parameters[1]);
            if (game[posY][posX] == 0){
                game[posY][posX] = 1;
                i++;
            }
        }
    }

    static void show(){
        for (var i = 0; i < game.length; i++){
            // Draw upper line
            if (i == 0){
                System.out.print("    ");
                for (var j = 0; j < game[i].length; j++){
                    System.out.print(j + " ");
                }
                System.out.println("x");
                System.out.print("   ");
                for (var j = 0; j < game[i].length*2; j++){
                    System.out.print("-");
                }
                System.out.println();
            }
            for (var j = 0; j < game[i].length; j++){
                // Draw left side line
                if (j == 0){
                    System.out.print(i + " | ");
                }
                // Draw content
                switch(game[i][j]){
                    case 0:
                    case 1:
                        System.out.print("· ");
                        break;
                    case 2:
                        System.out.print("X ");
                        break;
                    case 3:
                        System.out.print(ConsoleColors.BLUE + "X " + ConsoleColors.RESET);
                        break;
                    
                }
                
            }
            System.out.println();
        }
        System.out.println("y");
    }

    static void shoot(){
        int posX, posY;
        do{
            System.out.print("Enter the X coordinate of the shot: ");
            posX = reader.nextInt();
        } while(posX > game[0].length || posX < 0);

        do{
            System.out.print("Enter the Y coordinate of the shot: ");
            posY = reader.nextInt();
        } while(posY > game.length || posY < 0);

        switch(game[posY][posX]){
            case 0:
                System.out.println("You shot into the water.");
                game[posY][posX] = 2;
                break;
            case 1:
                System.out.println("You sunk a ship.");
                game[posY][posX] = 3;
                shipsRemaining--;
                break;
            case 2:
            case 3:
                System.out.println("You have shot here before.");
                break;
        }
    }
    static boolean checkShipsRemainging(){
        if (shipsRemaining != 0){
            return true;
        } else {
            return false;
        }
    }
}