public class App {
    public static void main(String[] args) throws Exception {
        Messages.welcome();
        System.out.println();
        Board.create(Board.requestParameters());
        System.out.println();
        while (Board.checkShipsRemainging()){
            Board.show();
            System.out.println();
            Board.shoot();
            System.out.println();
            Messages.showShipsRemaining();
            System.out.println();
        }
        System.out.println("You sunk the whole float.");
    }
}