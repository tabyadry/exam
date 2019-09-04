package problem2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTest {

    @Test
    public void board() {
        Spaceship spaceship = new Spaceship(10);
        spaceship.board("Nick", 4);
        assertEquals(1, spaceship.getCrewMembers().size());
    }

    @Test
    public void unboard() {
        Spaceship spaceship = new Spaceship(10);
        spaceship.board("Nick", 4);
        spaceship.board("Norman", 2);
        assertEquals(2, spaceship.getCrewMembers().size());
        spaceship.unboard("Nick");
        assertEquals(1, spaceship.getCrewMembers().size());
    }

    @Test
    public void getPlanetsVisited() {
        Spaceship spaceship = new Spaceship(10);
        spaceship.board("Nick", 2);
        spaceship.flyTo("Mars", 3);
        assertEquals("[Mars]", spaceship.getPlanetsVisited());
    }

    @Test
    public void flyToSuccessful() {
        Spaceship spaceship = new Spaceship(10);
        spaceship.board("Nick", 2);
        assertEquals(true, spaceship.flyTo("Mars", 3));
    }

    @Test
    public void flyToUnsuccessful() {
        Spaceship spaceship = new Spaceship(10);
        spaceship.board("Nick", 2);
        assertEquals(false, spaceship.flyTo("Mars", 10));
    }
}