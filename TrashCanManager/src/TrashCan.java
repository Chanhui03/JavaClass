public class TrashCan {
    public final static String TRASH_TYPE_PLASTIC = "Plastic";
    public final static String TRASH_TYPE_BOTTLE  = "Bottle";
    public final static String TRASH_TYPE_GENERAL = "General";

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

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public Garbage[] getGarbages() {
        Garbage[] g = new Garbage[count];
        for (int i = 0; i < count; i++)
            g[i] = garbages[i];

        return g;
    }

    public boolean canAcceptType(Garbage garbage) {
        if (garbage.getType().equals(this.type)) {
            return true;
        }
        return false;
    }

    public boolean addGarbage(Garbage garbage) {
        if (count >= CAPACITY) {
            System.out.println("쓰레기통이 가득 찼습니다.");
            return false;
        }

        if (!canAcceptType(garbage)) {
            System.out.println("이 쓰레기통은 " + this.type + " 쓰레기만 받을 수 있습니다.");
            return false;
        }

        garbages[count] = garbage;
        count++;
        return true;
    }

    public void clear() {
        count = 0;
        // garbages = new Garbage[CAPACITY];
        // for (int i = 0; i < garbages.length; i++)
        //     garbages[i] = null;

        System.out.println(name + "이(가) 비워졌습니다.");
    }

    public void displayContents() {
        System.out.printf("%8s:\t", name);
        if (count == 0)
            System.out.println("비어있음");
        else {
            for (int i = 0; i < count; i++) {
                Garbage g = garbages[i];
                System.out.print(g.getName());
                if (i > 0) {
                    System.out.print(", ");
                }
            }

            System.out.println("(" + count + "개)");
        }
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
    @Override
    public boolean canAcceptType(Garbage garbage) {
        // 일반 쓰레기통은 모든 종류의 쓰레기를 받을 수 있음
        return true;
    }
}