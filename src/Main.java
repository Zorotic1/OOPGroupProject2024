//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String[] options = {"Exit", "Log Out", "Grades", "Test Yourself", "Information On Climate Change"};
        int result = JOptionPane.showOptionDialog(null, "Select an operation:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
        System.out.println(result);

        switch(result){
            case 4:
                Object[] options4 = { "OK", "CANCEL" };
                int op4Int = JOptionPane.showOptionDialog(null, "Information On Climate Change", "Information On Climate Change", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options4, options4);

                break;
            case 3:
                Object[] options3 = { "OK", "CANCEL" };
                JOptionPane.showOptionDialog(null, "Test Yourself", "Test Yourself", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options3, options3);
                break;
            case 2:
                Object[] options2 = { "OK", "CANCEL" };
                JOptionPane.showOptionDialog(null, "Grades", "Grades", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2);
                break;
            case 1:
                Object[] options1 = { "OK", "CANCEL" };
                JOptionPane.showOptionDialog(null, "Log Out", "Log Out", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1);
                break;
            case 0:
                Object[] options0 = { "OK", "CANCEL" };
                JOptionPane.showOptionDialog(null, "Exit", "Exit", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options0, options0);
                break;
        }


    }
}