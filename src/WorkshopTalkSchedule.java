import java.util.ArrayList;

public class WorkshopTalkSchedule {

    public static class Event {
        private String name;
        private ArrayList<String> registeredUsers;

        public Event(String name) {
            this.name = name;
            this.registeredUsers = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void registerUser(String username) {
            registeredUsers.add(username);
        }
    }

    private static ArrayList<Event> events = new ArrayList<>();

    static {
        events.add(new Event("Workshop on Climate Change - July 15, 2024"));
        events.add(new Event("Talk on Renewable Energy - July 20, 2024"));
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static boolean register(String username, String eventName) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(eventName)) {
                event.registerUser(username);
                return true;
            }
        }
        return false;
    }

    public static boolean addEvent(String eventName) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(eventName)) {
                return false; // Event already exists
            }
        }
        events.add(new Event(eventName));
        return true;
    }

    public static boolean removeEvent(String eventName) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(eventName)) {
                events.remove(event);
                return true; // Event removed successfully
            }
        }
        return false; // Event not found
    }
}

