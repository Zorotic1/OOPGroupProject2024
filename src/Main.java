import javax.swing.*;
import java.awt.*;
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
        testManager.addQuestion("Fill in the blanks: Internaltional cooperation and experience sharing are crucial for improving global capacity to respond to climate change. We can achieve this by participating in _______, collaborative projects, and bilateral exchanges.","Media");
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

    public static int mainMenu() {
        String[] options = currentUser.isAdmin() ? new String[]{ "Log Out", "Grades", "Test Yourself", "Information On Climate Change", "Manage Information"} :
                new String[]{ "Log Out", "Grades", "Test Yourself", "Information On Climate Change"};
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

    public static void addInfo() { // Added
        String info = JOptionPane.showInputDialog("Enter new information:");
        infoPages.add("<html><div style='width: 1000px;'>" + info + "</div></html>");
        JOptionPane.showMessageDialog(null, "Information added: " + info);
    }

    public static void editInfo() {
        String[] infoArray = infoPages.toArray(new String[0]);
        int index = JOptionPane.showOptionDialog(null, "Select information to edit:", "Edit Information", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, infoArray, infoArray[0]);
        if (index >= 0 && index < infoPages.size()) {
            String newInfo = JOptionPane.showInputDialog("Edit the information:", infoPages.get(index).replaceAll("<[^>]*>", ""));
            infoPages.set(index, "<html><div style='width: 500px;'>" + newInfo + "</div></html>");
            JOptionPane.showMessageDialog(null, "Information edited.");
        }
    }

    public static void deleteInfo() { // Added
        String[] infoArray = infoPages.toArray(new String[0]);
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
            JOptionPane.showMessageDialog(null, testManager.getGrades(), "Test Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void gradesMenu() {
        Object[] options2 = {"OK", "CANCEL"};
        JOptionPane.showOptionDialog(null, testManager.getGrades(), "Grades", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
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

