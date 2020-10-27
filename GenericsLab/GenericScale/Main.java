package GenericsLab.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(1, -1);

        System.out.println(scale.getHeavier());
    }
}
