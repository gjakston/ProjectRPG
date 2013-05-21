public interface Actor {
    public String type();
    public String name();
    public int health() ;
    public int healthRemaining(); 
    public void updateHealth(int change);
    public int power();
    public int defense(); 
    public void WriteToFile();
    public void TempDataToFile();
}