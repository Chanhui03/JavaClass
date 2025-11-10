package lib.Trash;

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
    
    protected Garbage(String type, String name, int weight) {
        this.type = type;
        this.name = name;
        this.weight = weight;
    }

    public void displayName() {
        System.out.print(name);
    }

    public void displayDetails() {
        System.out.println("[" + type + "] " + name + "(" + weight + " g)" );
    }

    public void throwAway(TrashCan trashCan) {
        System.out.printf("[%s]을(를) %s에 버렸습니다.\n", name, trashCan.getName());
    }
}

class PlasticGarbage extends Garbage {
    public PlasticGarbage(String name, int weight) {
        super(TrashCan.TRASH_TYPE_PLASTIC, name, weight);
    }

    @Override
    public void throwAway(TrashCan trashCan) {
        super.throwAway(trashCan);
        if (!trashCan.getType().equals(this.getType())) {
            System.out.println("다음부터는 분리수거를 해주세요.");
        }
    }
}

class BottleGarbage extends Garbage {
    public BottleGarbage(String name, int weight) {
        super(TrashCan.TRASH_TYPE_BOTTLE, name, weight);
    }

    @Override
    public void throwAway(TrashCan trashCan) {
        super.throwAway(trashCan);
        if (!trashCan.getType().equals(this.getType())) {
            System.out.println("다음부터는 분리수거를 해주세요.");
        }
    }
}

class GeneralGarbage extends Garbage {
    public GeneralGarbage(String name, int weight) {
        super(TrashCan.TRASH_TYPE_GENERAL, name, weight);
    }
}
