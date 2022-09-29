public class Messages {
    static void welcome(){
        System.out.println("#############################################");
        System.out.println("######## WELCOMOME TO SEAK THE FLOAT ########");
        System.out.println("#############################################");
    }
    static void showShipsRemaining(){
        System.out.print("Barcos hundidos: " + (Board.shipsAmount - Board.shipsRemaining) + "/" + Board.shipsAmount + " [");
        for (var i = 1; i <= (Board.shipsAmount); i++){
            if (i > (Board.shipsAmount - Board.shipsRemaining)){
                System.out.print("·");
            } else {
                System.out.print("#");
            }
        }
        System.out.print("]");
    }
}