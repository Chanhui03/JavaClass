public class TrashCan {
    public final static String TRASH_TYPE_PLASTIC   = "Plastic";
    public final static String TRASH_TYPE_BOTTLE    = "Bottle";
    public final static String TRASH_TYPE_GENERAL   = "General";

    private final int CAPACITY = 10;

    private String type;
    private String name;
    private int    count;
    private Garbage[] garbages;

    protected TrashCan(String type, String name) {
        this.type = type;
        this.name = name;
        this.count = 0;
        this.garbages = new Garbage[CAPACITY];
    }

    public String getType() { return type;}
    public String getName() { return name;}
    public int getCount() { return count;}
    public Garbage[] getGarbages() { 
        Garbage[] currentGarbages = new Garbage[count];
        for (int i = 0; i < count; i++) 
            currentGarbages[i] = garbages[i];

        return currentGarbages;
    }
    public boolean canAcceptType(Garbage garbage) { 
        return this.type.equals(garbage.getType());
    }
    public boolean addGarbage(Garbage garbage) { 
        if (count >= CAPACITY)
            return false;

        garbages[count] = garbage;
        count++;
        return true;
    }

    public void clearContents() {
        count = 0;
        garbages = new Garbage[CAPACITY];
        System.out.println(name + " 쓰레기통이 비워졌습니다.");
    }

    public void displayContents() { 
        System.out.print("[" + name + " - " + type + " 쓰레기통] : ");
        if (count == 0) {
            System.out.println("비어있음");
            return;
        }
        for (int i = 0; i < count; i++) {
            garbages[i].displayDetails();
            System.err.print(" ");
        }
        System.out.println("" );
    }
}

class PlasticTrashCan extends TrashCan {
    public PlasticTrashCan(String name) {
        super(TRASH_TYPE_PLASTIC, name);
    }
}
class BottleTrashCan extends TrashCan {
    public BottleTrashCan(String name) {
        super(TRASH_TYPE_BOTTLE, name);
    }
}
class GeneralTrashCan extends TrashCan {
    public GeneralTrashCan(String name) {
        super(TRASH_TYPE_GENERAL, name);
    }
}