public class DrawRectangle implements IDrawShape{
    private Rectangle rectangle;
    public DrawRectangle(Rectangle rectangle) {
        this.rectangle=rectangle;
    }
    @Override
    public void draw() {
        for (int i = 0; i < rectangle.getLength(); i++) {
            System.out.println();
            for (int j = 0; j < rectangle.getWidth(); j++) {
                System.out.print("# ");
            }
        }
        

    }
    
}
