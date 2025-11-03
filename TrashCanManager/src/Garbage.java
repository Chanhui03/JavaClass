public class Garbage {
    private String type;
    private String name;
    private int weight;    // 단위: g

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void displayDetails() {
        System.out.println(name + "(" + weight + " g)" );
    }
    
    public void throwaway() {
        System.out.println(name + "이(가) 버려졌습니다.");
    }

    protected Garbage(String type, String name, int weight) {
        this.type = type;
        this.name = name;
        this.weight = weight;
    }
}

class PlasticGarbage extends Garbage {
    public PlasticGarbage(String name, int weight) {
        super(TrashCan.TRASH_TYPE_PLASTIC, name, weight);
    }
}

class BottleGarbage extends Garbage {
    public BottleGarbage(String name, int weight) {
        super(TrashCan.TRASH_TYPE_BOTTLE, name, weight);
    }
}

class GeneralGarbage extends Garbage {
    public GeneralGarbage(String name, int weight) {
        super(TrashCan.TRASH_TYPE_GENERAL, name, weight);
    }
}
