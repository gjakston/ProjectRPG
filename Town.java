public class Town {
    private String name;
    private int size;// 1, 2, 3
    private int x;
    private int y;
    private int relationToTown = 0; // 0 = Neutral
    public Town(int x, int y, int size, String name) {
        this.name = name;
        this.size = size;
        this.x = x;
        this.y = y;
    }
    public Town( int x, int y, int size, int relationToTown, String name) {
        this.name = name;
        this.size = size;
        this.x = x;
        this.y = y;
        this.relationToTown = relationToTown;
    }
    public void WriteToFile() {
        
    }
    public String name() {return name;}
}