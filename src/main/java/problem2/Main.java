package problem2;

public class Main {
    public static void main(String[] args) {
        Spaceship spaceship = new Spaceship(50);
        spaceship.board("Nolan",3);
        spaceship.board("Nick",4);

        System.out.println(spaceship.flyTo("Mars",7));
    }
}
