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
                Object[] options1 = { "OK", "CANCEL" };
                JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options1, options1);

        }


    }
}