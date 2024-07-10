import java.util.ArrayList;

public class WorkshopTalkSchedule {

    // Inner class to represent a workshop or talk event
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

        public ArrayList<String> getRegisteredUsers() {
            return registeredUsers;
        }

        public void registerUser(String username) {
            registeredUsers.add(username);
        }
    }

    private static ArrayList<Event> events = new ArrayList<>();

    static {
        // Adding some sample events
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
}