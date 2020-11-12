package JavaAdvancedRetakeExamAugust2020.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
         return data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)
                    && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
            return null;
    }

    public Pet getOldestPet() {
        Pet oldestPet = data.get(0);
        for (Pet pet : data) {
            if (pet.getAge() > oldestPet.getAge()) {
                oldestPet = pet;
            }
        } return oldestPet;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The clinic has the following patients:");
        sb.append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner());
            sb.append(System.lineSeparator());
        } return sb.toString();
    }
}
