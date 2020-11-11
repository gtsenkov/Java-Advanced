package JavaAdvancedRetakeExamDec2019.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        if (this.data.removeIf(p -> p.getName().equals(name))) {
            return true;
        }
        return false;
    }

    public Present heaviestPresent() {

        Present heaviest = this.data.get(0);

        for (Present present : data) {
            if (present.getWeight() > heaviest.getWeight()) {
                heaviest = present;
            }
        }return heaviest;
    }

    public Present getPresent(String name) {
        Present presentToGet = null;
        for (Present present : data) {
            if (present.getName().equals(name)) {
                presentToGet = present;
            }
        }
        return presentToGet;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(getColor()).append(" bag contains:").append(System.lineSeparator());

        for (Present present : data) {
            sb.append(present).append(System.lineSeparator());
        } return sb.toString();
    }
}
