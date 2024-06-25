//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;

public class Main {
    public static int mainMenu() {
        String[] options = {"Exit", "Log Out", "Grades", "Test Yourself", "Information On Climate Change"};
        int result = JOptionPane.showOptionDialog(null, "Select an operation:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
        System.out.println(result);

        return result;
    }
    public static void infoMenu() {
        Object[] options4 = { "NEXT PAGE", "PREVIOUS PAGE", "BACK TO MAIN MENU" };

        String info1 = ("<html><center>Climate change refers to long-term shifts in temperatures and weather patterns. Such shifts can be natural, due to changes in the sun’s activity or large volcanic eruptions.</center><br><br></html>" +
                "<html><center>But since the 1800s, human activities have been the main driver of climate change, primarily due to the burning of fossil fuels like coal, oil and gas.</center><br><br></html>"
         + "<html><center>Burning fossil fuels generates greenhouse gas emissions that act like a blanket wrapped around the Earth, trapping the sun’s heat and raising temperatures.</center><br><br></html>" +
          "<html><center>The main greenhouse gases that are causing climate change include carbon dioxide and methane. These come from using gasoline for driving a car or coal for heating a building, for example.</center><br><br></html> " +
        "<html><center>Clearing land and cutting down forests can also release carbon dioxide. Agriculture, oil and gas operations are major sources of methane emissions.</center><br><br></html>" +
                "<html><center>Energy, industry, transport, buildings, agriculture and land use are among the main sectors causing greenhouse gases.<br></html>");


        int op4Int = JOptionPane.showOptionDialog(null, info1, "Information On Climate Change", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options4, options4);

            switch (op4Int) {
                case 0:

            }

    }

    public static void testMenu() {
        Object[] options3 = { "OK", "CANCEL" };
        JOptionPane.showOptionDialog(null, "Test Yourself", "Test Yourself", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options3, options3);

    }

    public static void gradesMenu() {
        Object[] options2 = { "OK", "CANCEL" };
        JOptionPane.showOptionDialog(null, "Grades", "Grades", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2);

    }

    public static void outMenu() {
        Object[] options1 = { "OK", "CANCEL" };
        JOptionPane.showOptionDialog(null, "Log Out", "Log Out", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1);

    }

    public static void exitMenu() {
        Object[] options0 = { "OK", "CANCEL" };
        JOptionPane.showOptionDialog(null, "Exit", "Exit", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options0, options0);

    }

    public static void main(String[] args) {
        int result = mainMenu();

        switch(result){
            case 4:
                infoMenu();
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
            case 0:
                exitMenu();
                break;
        }


    }
}