import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static ArrayList<User> users = new ArrayList<>(); // Added
    private static User currentUser; // Added
    private static testManager testManager = new testManager();
    private static ArrayList<String> infoPages = new ArrayList<>(Arrays.asList(
            "<html><div style='width: 1000px;'>Climate change refers to significant and lasting changes in the Earth’s climate and weather patterns. These changes can be natural, but in the context of recent discussions, the term often refers to changes driven by human activities, particularly the increase in greenhouse gases (like carbon dioxide and methane) due to burning fossil fuels, deforestation, and other industrial processes. Key aspects of climate change include:<br><br>"
                    + "1. Global Warming: The long-term rise in Earth’s average surface temperature due to increased concentrations of greenhouse gases.<br>"
                    + "2. Changes in Weather Patterns: More frequent and severe weather events, such as hurricanes, heatwaves, droughts, and heavy rainfall.<br>"
                    + "3. Sea Level Rise: Melting polar ice and glaciers contribute to rising sea levels, which can lead to coastal flooding and erosion.<br>"
                    + "4. Ocean Acidification: Increased levels of CO2 lead to higher acidity in oceans, affecting marine life.<br>"
                    + "5. Ecosystem Disruption: Changes in temperature and precipitation patterns can alter habitats and the distribution of plant and animal species.</div></html>",
            "<html><div style='width: 1000px;'>1. Climate change refers to long-term shifts in temperatures and weather patterns. Such shifts can be natural, due to changes in the sun’s activity or large volcanic eruptions.<br><br>"
                    + "2. But since the 1800s, human activities have been the main driver of climate change, primarily due to the burning of fossil fuels like coal, oil, and gas.<br><br>"
                    + "3. Burning fossil fuels generates greenhouse gas emissions that act like a blanket wrapped around the Earth, trapping the sun’s heat and raising temperatures.<br><br>"
                    + "4. The main greenhouse gases that are causing climate change include carbon dioxide and methane. These come from using gasoline for driving a car or coal for heating a building.<br><br>"
                    + "5. Clearing land and cutting down forests can also release carbon dioxide. Agriculture, oil, and gas operations are major sources of methane emissions.<br><br>"
                    + "6. Energy, industry, transport, buildings, agriculture, and land use are among the main sectors causing greenhouse gases.</div></html>"
    ));


    public static void populateTestQuestions() {
        testManager.addQuestion("Fill in the blank: Energy, industry, transport, buildings, _________, and land use are among the main sectors causing greenhouse gases.", "agriculture");
        testManager.addQuestion("Fill in the blank: The main greenhouse gases that are causing climate change include carbon dioxide and methane. These come from using gasoline for driving a car or _______ for heating a building", "coal");
        testManager.addQuestion("Fill in the blank: Changes in Weather Patterns: More frequent and severe weather events, such as hurricanes, heatwaves, _______, and heavy rainfall.","droughts");
        testManager.addQuestion("Fill in the blank: To enhance students' understanding and ability to respond to climate change, we can introduce courses on _________ and environmental protection in schools and higher education institutions.","International conferences");
        testManager.addQuestion("Fill in the blank: To raise public awareness of environmental issues, we can use_______, community activities, and social networks to widely disseminate information on the impacts and measures of climate change","Climate change");
        testManager.addQuestion("Fill in the blanks: International cooperation and experience sharing are crucial for improving global capacity to respond to climate change. We can achieve this by participating in _______, collaborative projects, and bilateral exchanges.","Media");
    }

    public static void populateUsers() { // Added
        users.add(new User("test", "1234", false));
        users.add(new User("testadmin", "1234", true));
    }

    public static String[] login() {
        populateUsers();

        String[] results = new String[2];

        User user;
        do {
            String name = JOptionPane.showInputDialog("Please enter your Username:");
            if (name == null) {
                int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to quit?", "Warning", JOptionPane.YES_NO_OPTION);
                if (quit == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
            else {
                user = getUserByUsername(name);
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "Username does not exist. Please enter a valid username.");
                }
                else {
                    break;
                }
            }
        } while (true);

        String pass;
        do {
            pass = JOptionPane.showInputDialog("Please enter your Password:");
            if (pass == null) {
                int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to quit?", "Warning", JOptionPane.YES_NO_OPTION);
                if (quit == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
            else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password cannot be empty.");
            }
            else if (!user.checkPassword(pass)) {
                JOptionPane.showMessageDialog(null, "Incorrect Password. Please enter the correct password.");
            }
            else {
                break;
            }
        } while (true);

        results[0] = user.getUsername();
        results[1] = pass;

        return results;
    }
    public static void addNewUser() {
        User user;
        String name;
        do {
            name = JOptionPane.showInputDialog("Please enter your Username:");
            if (name == null) {
                int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to return to main menu?", "Warning", JOptionPane.YES_NO_OPTION);
                if (quit == JOptionPane.YES_OPTION) {
                    return;
                }
            } else {
                user = getUserByUsername(name);
                if (name == null) {
                    JOptionPane.showMessageDialog(null, "Field cannot be empty. Please enter a valid username.");
                }
                if (user != null) {
                    JOptionPane.showMessageDialog(null, "Username already exists. Please enter a valid username.");
                } else {
                    break;
                }
            }
        } while (true);

        String pass;
        do {
            pass = JOptionPane.showInputDialog("Please enter your Password:");
            if (pass == null) {
                int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to quit?", "Warning", JOptionPane.YES_NO_OPTION);
                if (quit == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password cannot be empty.");
            } else {
                break;
            }
        } while (true);

        int isAdminOption = JOptionPane.showConfirmDialog(null, "Is this user an admin?", "Admin User", JOptionPane.YES_NO_OPTION);
        boolean isAdmin = (isAdminOption == JOptionPane.YES_OPTION);


        users.add(new User(name, pass, isAdmin));
    }

    public static int mainMenu() {
        String[] options = currentUser.isAdmin() ? new String[]{ "Log Out", "Grades", "Test Yourself", "Information On Climate Change","Discussion Board","Workshop/Talk Schedule","Manage Information", "Add New User"} :
                new String[]{ "Log Out", "Grades", "Test Yourself", "Information On Climate Change", "Discussion Board","Workshop/Talk Schedule"};
        int result = JOptionPane.showOptionDialog(null, "Select an operation:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);

        return result;
    }

    public static int infoMenu() {
        Object[] options4 = {"NEXT PAGE", "PREVIOUS PAGE", "BACK TO MAIN MENU"};

        int currentPage = 0;
        int result;

        do {
            result = JOptionPane.showOptionDialog(null, infoPages.get(currentPage), "Information On Climate Change", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options4, options4[0]);

            if (result == 0 && currentPage < infoPages.size() - 1) {
                currentPage++;
            }
            else if (result == 1 && currentPage > 0) {
                currentPage--;
            }
            else if (result == 2) {
                return 0;
            }
            else if (result == JOptionPane.CLOSED_OPTION) {
                int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to go back to the main menu?", "Warning", JOptionPane.YES_NO_OPTION);
                if (quit == JOptionPane.YES_OPTION) {
                    return 1;
                }
            }
        } while (result != JOptionPane.CLOSED_OPTION);

        return 0;
    }


    public static int manageInfoMenu() { // Added
        String[] options = {"Add Information", "Edit Information", "Delete Information", "Back to Main Menu"};
        int result = JOptionPane.showOptionDialog(null, "Manage Information:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
        return result;
    }

    public static void addInfo() {
        String info;
        do {
            info = JOptionPane.showInputDialog("Enter new information:");
            if (info == null) {
                int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to go back?", "Warning", JOptionPane.YES_NO_OPTION);
                if (quit == JOptionPane.YES_OPTION) {
                    return;
                }
            }
        } while (info == null);

        while (info.isEmpty()) {
            info = JOptionPane.showInputDialog("Info cannot be empty. Enter new information:");
        }

        infoPages.add("<html><div style='width: 1000px;'>" + info + "</div></html>");
        JOptionPane.showMessageDialog(null, "Information added: " + info);
    }

    public static void editInfo() {
        String[] infoArray = infoPages.toArray(new String[0]);

        Object[] options = new Object[infoArray.length];
        for (int i = 0; i < infoArray.length; i++) {
            String buttonText = infoArray[i].replaceAll("<[^>]*>", "");
            if (buttonText.length() > 50) {
                buttonText = buttonText.substring(0, 50) + "...";
            }
            options[i] = buttonText;
        }

        int index = JOptionPane.showOptionDialog(null, "Select information to edit:", "Edit Information", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (index >= 0 && index < infoPages.size()) {
            String newInfo = JOptionPane.showInputDialog("Edit the information:", infoPages.get(index).replaceAll("<[^>]*>", ""));

            if (newInfo != null) {
                infoPages.set(index, "<html><div style='width: 5000px;'>" + newInfo + "</div></html>");
                JOptionPane.showMessageDialog(null, "Information edited.");
            }
        }
    }

    public static void deleteInfo() {
        String[] infoArray = new String[infoPages.size()];
        for (int i = 0; i < infoPages.size(); i++) {
            String info = infoPages.get(i);
            String buttonText = info.replaceAll("<[^>]*>", "");
            if (buttonText.length() > 50) {
                buttonText = buttonText.substring(0, 50) + "...";
            }
            infoArray[i] = buttonText;
        }
        int index = JOptionPane.showOptionDialog(null, "Select information to delete:", "Delete Information", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, infoArray, infoArray[0]);
        if (index >= 0 && index < infoPages.size()) {
            infoPages.remove(index);
            JOptionPane.showMessageDialog(null, "Information deleted.");
        }
    }
    public static void testMenu() {
        populateTestQuestions();
        int c = testManager.startTest();
        if (c == 1){
            mainMenuLoop();
        }
        else{
            JOptionPane.showMessageDialog(null, testManager.getGradesInfo(), "Test Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void gradesMenu() {
        testManager.viewGrades();
    }

    public static void logoutMenu() {
        int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to log out?", "Warning", JOptionPane.YES_NO_OPTION);
        if (quit == JOptionPane.YES_OPTION) {
            String[] login = login();
            currentUser = getUserByUsername(login[0]);
        }
    }

    public static void mainMenuLoop() {
        int result = mainMenu();
        while (result != -35) {
            switch (result) {
                case 3:
                    infoMenu();
                    break;
                case 2:
                    testMenu();
                    break;
                case 1:
                    gradesMenu();
                    break;
                case 0:
                    logoutMenu();
                    break;
                case 4:
                    discussionBoardMenu();
                    break;
                case 5:
                    workshopTalkScheduleMenu();
                    break;
                case 6:
                    if (currentUser.isAdmin()) {
                        int manageResult = manageInfoMenu();
                        while (manageResult != 3) {
                            switch (manageResult) {
                                case 0:
                                    addInfo();
                                    break;
                                case 1:
                                    editInfo();
                                    break;
                                case 2:
                                    deleteInfo();
                                    break;
                                case (JOptionPane.CLOSED_OPTION):
                                    int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to go back to the main menu?", "Warning", JOptionPane.YES_NO_OPTION);
                                    if (quit == JOptionPane.YES_OPTION) {
                                        mainMenuLoop();
                                        break;
                                    }
                                    break;

                            }
                            manageResult = manageInfoMenu();
                        }
                    }
                    break;
                case 7:
                    if(currentUser.isAdmin()) {
                        addNewUser();
                        break;
                    }
                case -1:
                    int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to close?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (quit == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                    break;
            }
            result = mainMenu();
        }
    }

    public static void viewPosts() {
        ArrayList<String> posts = DiscussionBoard.getPosts();
        StringBuilder formattedPosts = new StringBuilder();
        for (String post : posts) {
            formattedPosts.append(post).append("\n\n");
        }

        if (formattedPosts.length() > 0) {
            JOptionPane.showMessageDialog(null, formattedPosts.toString(), "Discussion Board Posts", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No posts available.", "Discussion Board", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void addPost() {
        String post;
        do {
            post = JOptionPane.showInputDialog("Enter your post:");
            if (post == null) {
                int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to go back to the main menu?", "Warning", JOptionPane.YES_NO_OPTION);
                if (quit == JOptionPane.YES_OPTION) {
                    return;
                }
            }
        } while (post == null);

        if (post != null && !post.trim().isEmpty()) {
            DiscussionBoard.addPost(currentUser.getUsername() + ": " + post);
            JOptionPane.showMessageDialog(null, "Post added.");
        }
    }

    public static void discussionBoardMenu() {
        String[] options = currentUser.isAdmin() ? new String[]{"View Posts", "Add Post", "Remove Post", "Back to Main Menu"} : new String[]{"View Posts", "Add Post", "Back to Main Menu"};
        int result;
        do {
            result = JOptionPane.showOptionDialog(null, "Discussion Board:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (result) {
                case 0:
                    viewPosts();
                    break;
                case 1:
                    addPost();
                    break;
                case 2:
                    if (currentUser.isAdmin()) {
                        removePost();
                    } else {
                        return;
                    }
                    break;
                case 3:
                    return;
                case (JOptionPane.CLOSED_OPTION):
                    int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to go back to the main menu?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (quit == JOptionPane.YES_OPTION) {
                        return;
                    }
            }
        } while (result != 3);
    }
    public static void viewSchedule() { // Added
        ArrayList<WorkshopTalkSchedule.Event> events = WorkshopTalkSchedule.getEvents();
        StringBuilder formattedSchedule = new StringBuilder();
        for (WorkshopTalkSchedule.Event event : events) {
            formattedSchedule.append(event.getName()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Workshop/Talk Schedule:\n\n" + formattedSchedule.toString());
    }

    public static void registerForWorkshopTalk() { // Modified
        ArrayList<WorkshopTalkSchedule.Event> events = WorkshopTalkSchedule.getEvents();
        String[] eventNames = new String[events.size()];
        for (int i = 0; i < events.size(); i++) {
            eventNames[i] = events.get(i).getName();
        }

        String eventName = (String) JOptionPane.showInputDialog(
                null,
                "Select a workshop/talk to register for:",
                "Register for Workshop/Talk",
                JOptionPane.QUESTION_MESSAGE,
                null,
                eventNames,
                eventNames[0]);

        if (eventName != null) {
            boolean success = WorkshopTalkSchedule.register(currentUser.getUsername(), eventName);
            if (success) {
                JOptionPane.showMessageDialog(null, "Successfully registered for " + eventName);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to register for " + eventName + ". Make sure the event exists.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No event selected.");
        }
    }

    public static void workshopTalkScheduleMenu() { // Added
        String[] options = {"View Schedule", "Register for Workshop/Talk","Add Event", "Remove Event", "Back to Main Menu"};
        int result;
        do {
            result = JOptionPane.showOptionDialog(null, "Workshop/Talk Schedule:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (result) {
                case 0:
                    viewSchedule();
                    break;
                case 1:
                    registerForWorkshopTalk();
                    break;
                case 2:
                    if (currentUser.isAdmin()) {
                        addEvent();
                    }
                    break;
                case 3:
                    if (currentUser.isAdmin()) {
                        removeEvent();
                    }
                    break;
                case 4:
                    return;
            }
        } while (result != 4);
    }

    public static void addEvent() {
        String eventName = JOptionPane.showInputDialog("Enter the name of the new event:");
        if (eventName != null && !eventName.trim().isEmpty()) {
            boolean success = WorkshopTalkSchedule.addEvent(eventName);
            if (success) {
                JOptionPane.showMessageDialog(null, "Event added successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Event already exists.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Event name cannot be empty.");
        }
    }

    // Add this method to the main class
    public static void removeEvent() {
        ArrayList<WorkshopTalkSchedule.Event> events = WorkshopTalkSchedule.getEvents();
        String[] eventNames = new String[events.size()];
        for (int i = 0; i < events.size(); i++) {
            eventNames[i] = events.get(i).getName();
        }

        String eventName = (String) JOptionPane.showInputDialog(
                null,
                "Select an event to remove:",
                "Remove Event",
                JOptionPane.QUESTION_MESSAGE,
                null,
                eventNames,
                eventNames[0]);

        if (eventName != null) {
            boolean success = WorkshopTalkSchedule.removeEvent(eventName);
            if (success) {
                JOptionPane.showMessageDialog(null, "Event removed successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to remove event.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No event selected.");
        }
    }


    public static void removePost() {
        ArrayList<String> posts = DiscussionBoard.getPosts();
        if (posts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No posts available to remove.", "Discussion Board", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] postArray = new String[posts.size()];
        for (int i = 0; i < posts.size(); i++) {
            String post = posts.get(i);
            String buttonText = post.length() > 50 ? post.substring(0, 50) + "..." : post;
            postArray[i] = buttonText;
        }

        int index = JOptionPane.showOptionDialog(null, "Select post to remove:", "Remove Post", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, postArray, postArray[0]);

        if (index >= 0 && index < posts.size()) {
            DiscussionBoard.removePost(index);
            JOptionPane.showMessageDialog(null, "Post removed.");
        }
    }

    public static void main(String[] args) {
        String[] login = login();
        currentUser = getUserByUsername(login[0]); // Added
        mainMenuLoop();
    }

    public static User getUserByUsername(String username) { // Added
        for (User i : users) {
            if (i.getUsername().equals(username)) {
                return i;
            }
        }
        return null;
    }
}



