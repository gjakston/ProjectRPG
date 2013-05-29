public class Item {
    public String type;
    public String name;
    public int rarity;
    public String[] features;
    public int offensive = 0;
    public int defensive = 0;
    public Item(String name, String type, int rarity) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
    }
    public void generateItem() {
        switch (type) {
            case "weapon":
            case "shield":
            case "cuirass":
            case "greaves":
            case "gauntlets":
            case "boots":
            case "food":
                break;
            case "potion":
                break;
        }
    }
    public int itemType() {
        switch (type) {
            case "weapon":
                return 1;
            case "shield":
                return 2;
            case "cuirass":
                return 3;
            case "greaves":
                return 4;
            case "gauntlets":
                return 5;
            case "boots":
                return 6;
            case "food":
                return 7;
            case "potion":
                return 8;
            default:
                return -1;
        }
    }
    public String info() {
        return name + " " + type + " " + rarity;
    }
}