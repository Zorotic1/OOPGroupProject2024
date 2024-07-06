import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class testManager {
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    public testManager() {
        questions = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public void addQuestion(String question, String answer) {
        questions.add(JOptionPane.showInputDialog(question));
        answers.add(answer);
    }

    public void startTest() {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);

        for (int i : indices) {
            String userAnswer = JOptionPane.showInputDialog(questions.get(i));
            if (userAnswer != null && userAnswer.equalsIgnoreCase(answers.get(i))) {
                JOptionPane.showMessageDialog(null,"Correct!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is:" + answers.get(i));
            }
        }
    }


}
