public class Town {
    private String name;
    private int size;// 1, 2, 3
    private int x;
    private int y;
    private int relationToTown = 0; // 0 = Neutral
    public Town(String name, int size, int x, int y) {
        this.name = name;
        this.size = size;
        this.x = x;
        this.y = y;
    }
    public Town(String name, int size, int x, int y, int relationToTown) {
        this.name = name;
        this.size = size;
        this.x = x;
        this.y = y;
        this.relationToTown = relationToTown;
    }
    public void WriteToFile() {
        
    }
}