package problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Spaceship {
    private int ammountOfFood;
    List<String> visitedPlanets = new ArrayList();
    Map<String, Integer> crewMembers = new HashMap<String, Integer>();

    public Spaceship(int ammountOfFood) {
        this.ammountOfFood = ammountOfFood;
    }

    /**
     * Boards a crew member with the given food intake. This crew member will now consume food during trips.
     */
    public void board(String crewMemberName, int foodPerDay) {
        crewMembers.put(crewMemberName, foodPerDay);
    }

    /**
     * Unboards a crew member with the given name from the ship. This crew member is no longer on the ship and no longer consumes food.
     */
    public void unboard(String crewMemberName) {
        crewMembers.remove(crewMemberName);
    }

    /**
     * Returns a String of visited planets, in order of visit. The string should be formatted like “[Earth, Mars, Venus]”
     */
    public String getPlanetsVisited() {
        return visitedPlanets.stream().collect(Collectors.joining(", ", "[", "]"));
    }

    /**
     * Attempts to fly to a planet, which takes the given number of days.
     */
    public boolean flyTo(String planetName, int daysRequired) {
        int poundsOfFoodNeeded = crewMembers.values().stream().reduce(0, (x, y) -> x + y) * daysRequired;
        if (poundsOfFoodNeeded > ammountOfFood) return false;
        else {
            visitedPlanets.add(planetName);
            this.ammountOfFood -= daysRequired;
            return true;
        }
    }

    public Map<String, Integer> getCrewMembers() {
        return new HashMap<>(crewMembers);
    }
}
