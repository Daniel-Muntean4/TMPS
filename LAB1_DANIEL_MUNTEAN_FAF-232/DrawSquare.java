public class DrawSquare implements IDrawShape{
    private Square square;
    public DrawSquare(Square square) {
        this.square=square;
    }
    @Override
    public void draw() {
        for (int i = 0; i < square.getSize(); i++) {
            System.out.println();
            for (int j = 0; j < square.getSize(); j++) {
                System.out.print("* ");
            }
        }
    }
    
}
