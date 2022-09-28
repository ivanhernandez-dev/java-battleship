public class App {
    public static void main(String[] args) throws Exception {
        Messages.welcome();
        System.out.println();
        board.create(board.requestParameters());
        System.out.println();
        while (board.checkShipsRemainging()){
            board.show();
            System.out.println();
            board.shoot();
            System.out.println();
            Messages.showShipsRemaining();
            System.out.println();
        }
        System.out.println("You sunk the whole float.");
    }
}