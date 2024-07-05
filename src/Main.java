import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;


public class Main {

    private static ArrayList<User> users = new ArrayList<>(); // Added
    private static User currentUser; // Added

    public static void populateUsers() { // Added
        users.add(new User("test", "1234", false));
        users.add(new User("testadmin", "1234", true));
    }

    public static String[] login() {
        populateUsers(); // Added

        String name;
        String pass;
        String[] results = new String[2];

        name = JOptionPane.showInputDialog("Please enter your Username:");
        User user = getUserByUsername(name);

        while (user == null) {
            name = JOptionPane.showInputDialog("Username does not exist, Please enter your Username:");
            user = getUserByUsername(name);
        }

        pass = JOptionPane.showInputDialog("Please enter your Password:");
        while (!user.checkPassword(pass)) {
            pass = JOptionPane.showInputDialog("Incorrect Password, Please enter your Password:");
        }

        results[0] = user.getUsername();
        results[1] = pass;

        return results;
    }

    public static int mainMenu() {
        String[] options = currentUser.isAdmin() ? new String[]{"Exit", "Log Out", "Grades", "Test Yourself", "Information On Climate Change", "Manage Information"} :
                new String[]{"Exit", "Log Out", "Grades", "Test Yourself", "Information On Climate Change"};
        int result = JOptionPane.showOptionDialog(null, "Select an operation:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);

        return result;
    }

    public static int infoMenu() {
        Object[] options4 = {"NEXT PAGE", "PREVIOUS PAGE", "BACK TO MAIN MENU"};

        String[] infoPages = {
                "<html><div style='width: 1000px;'>Climate change refers to significant and lasting changes in the Earth’s climate and weather patterns. These changes can be natural, but in the context of recent discussions, the term often refers to changes driven by human activities, particularly the increase in greenhouse gases (like carbon dioxide and methane) due to burning fossil fuels, deforestation, and other industrial processes. Key aspects of climate change include:<br><br>"
                        + "1. Global Warming: The long-term rise in Earth’s average surface temperature due to increased concentrations of greenhouse gases.<br>"
                        + "2. Changes in Weather Patterns: More frequent and severe weather events, such as hurricanes, heatwaves, droughts, and heavy rainfall.<br>"
                        + "3. Sea Level Rise: Melting polar ice and glaciers contribute to rising sea levels, which can lead to coastal flooding and erosion.<br>"
                        + "4. Ocean Acidification: Increased levels of CO2 lead to higher acidity in oceans, affecting marine life.<br>"
                        + "5. Ecosystem Disruption: Changes in temperature and precipitation patterns can alter habitats and the distribution of plant and animal species.</div></html>",
                "<html><div style='width: 1000px;'>1. Climate change refers to long-term shifts in temperatures and weather patterns. Such shifts can be natural, due to changes in the sun’s activity or large volcanic eruptions.<br><br>"
                        + "2. But since the 1800s, human activities have been the main driver of climate change, primarily due to the burning of fossil fuels like coal, oil, and gas.</div></html>",
                "<html><div style='width: 1000px;'>3. Burning fossil fuels generates greenhouse gas emissions that act like a blanket wrapped around the Earth, trapping the sun’s heat and raising temperatures.<br><br>"
                        + "4. The main greenhouse gases that are causing climate change include carbon dioxide and methane. These come from using gasoline for driving a car or coal for heating a building, for example.</div></html>",
                "<html><div style='width: 1000px;'>5. Clearing land and cutting down forests can also release carbon dioxide. Agriculture, oil, and gas operations are major sources of methane emissions.<br><br>"
                        + "6. Energy, industry, transport, buildings, agriculture, and land use are among the main sectors causing greenhouse gases.</div></html>"
        };

        int currentPage = 0;
        int result = 0;

        while (result != 2) {
            result = JOptionPane.showOptionDialog(null, infoPages[currentPage], "Information On Climate Change", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options4, options4[0]);

            if (result == 0 && currentPage < infoPages.length - 1) {
                currentPage++;
            } else if (result == 1 && currentPage > 0) {
                currentPage--;
            } else if (result == 2) {
                return 0;
            }
        }

        return 0;
    }


    public static int manageInfoMenu() { // Added
        String[] options = {"Add Information", "Edit Information", "Delete Information", "Back to Main Menu"};
        int result = JOptionPane.showOptionDialog(null, "Manage Information:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
        return result;
    }

    public static void addInfo() { // Added
        String info = JOptionPane.showInputDialog("Enter new information:");
        JOptionPane.showMessageDialog(null, "Information added: " + info);
    }

    public static void testMenu() {
        String[] questions = new String[3];
        questions[0] = JOptionPane.showInputDialog("Fill in the blank: A car produces ____ amount of CO2 on average per year.");
        questions[1] = JOptionPane.showInputDialog("Fill in the blank: The best way to reduce waste is to _____.");
        questions[2] = JOptionPane.showInputDialog("Fill in the blank: The 3R is Recycle, Reduce and _______.");

        int randInt;
        int[] numbers = new int[3];
        String[] ans = new String[3];
        boolean contains;

        for (int i = 0; i < 3; i++) {
            do {
                randInt = ThreadLocalRandom.current().nextInt(3);
                contains = Arrays.binarySearch(numbers, randInt) >= 0;
            } while (contains);

            ans[i] = questions[randInt];
            numbers[i] = randInt;
        }
    }

    public static void gradesMenu() {
        Object[] options2 = {"OK", "CANCEL"};
        JOptionPane.showOptionDialog(null, "Grades", "Grades", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2);
    }

    public static void outMenu() {
        Object[] options1 = {"OK", "CANCEL"};
        JOptionPane.showOptionDialog(null, "Log Out", "Log Out", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1);
    }

    public static void main(String[] args) {
        String[] login = login();
        currentUser = getUserByUsername(login[0]); // Added

        int result = mainMenu();
        while (result != 0) {
            switch (result) {
                case 4:
                    result = infoMenu();
                    break;
                case 3:
                    testMenu();
                    break;
                case 2:
                    gradesMenu();
                    break;
                case 1:
                    outMenu();
                    break;
                case 5: // Added
                    if (currentUser.isAdmin()) { // Added
                        int manageResult = manageInfoMenu(); // Added
                        while (manageResult != 3) { // Added
                            switch (manageResult) { // Added
                                case 0:
                                    addInfo(); // Added
                                    break;
                                case 1:
                                    // Call the editInfo() method if implemented
                                    break;
                                case 2:
                                    // Call the deleteInfo() method if implemented
                                    break;
                            }
                            manageResult = manageInfoMenu();
                        }
                    }
                    break;
            }
            result = mainMenu();
        }
    }

    public static User getUserByUsername(String username) { // Added
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}

class User { // Added
    private String username;
    private String password;
    private boolean isAdmin;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
