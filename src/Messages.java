public class Messages {
    static void welcome(){
        System.out.println("#############################################");
        System.out.println("######## WELCOMOME TO SEAK THE FLOAT ########");
        System.out.println("#############################################");
    }
    static void showShipsRemaining(){
        System.out.print("Barcos hundidos: " + (board.shipsAmount - board.shipsRemaining) + "/" + board.shipsAmount + " [");
        for (var i = 1; i <= (board.shipsAmount); i++){
            if (i > (board.shipsAmount - board.shipsRemaining)){
                System.out.print("·");
            } else {
                System.out.print("#");
            }
        }
        System.out.print("]");
    }
}