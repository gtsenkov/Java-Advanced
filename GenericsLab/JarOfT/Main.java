package GenericsLab.JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jarOne = new Jar<>();
        Jar<String> jarTwo = new Jar<>();

        jarOne.add(12);
        jarTwo.add("text");

        System.out.println(jarOne.remove());
        System.out.println(jarTwo.remove());
    }
}
