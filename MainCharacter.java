public class MainCharacter {
    public static String nameOfCharacter = "";
    public static int X;
    public static int Y;
    public MainCharacter(String s, int xPosition, int yPosition) {
        nameOfCharacter = s;
        X = xPosition;
        Y = yPosition;
    }
    public static int LocationX() {
        return X;
    }
    public static int LocationY() {
        return Y;
    }    
     public static void moveNorth() {
        if (Y - 1 >= 0) {
            Y += 1;
        } else {
            System.out.print(nameOfCharacter + ", you cannot go further west.");
        }
    }
    public static void moveSouth() {
        if (Y + 1 <= 50) {
            Y -= 1;
        } else {
            System.out.print(nameOfCharacter + ", you cannot go further west.");
        }
    }
    public static void moveWeast() {
        if (X - 1 >= 0) {
            X -= 1;
        } else {
            System.out.print(nameOfCharacter + ", you cannot go further west.");
        }
    }
    public static void moveEast() {
        if (X + 1 <= 50) {
            X += 1;
        } else {
            System.out.print(nameOfCharacter + ", you cannot go further west.");
        }
            
    }
}