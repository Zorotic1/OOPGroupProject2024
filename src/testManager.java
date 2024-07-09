import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class testManager {
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private int correctAnswers;

    public testManager() {
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        correctAnswers = 0;
    }

    public void addQuestion(String question, String answer) {

        boolean found = false;
        if (!questions.isEmpty()){
            for (String i : questions){
                if(question.equalsIgnoreCase(i)){
                    found = true;
                    break;
                }
            }
            if(!found) {
                questions.add(question);
                answers.add(answer);
            }
        }
        else{
            questions.add(question);
            answers.add(answer);
        }

    }


    public int startTest() {
        correctAnswers = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);

        for (int i : indices) {
            String userAnswer;
            do {
                userAnswer = JOptionPane.showInputDialog(questions.get(i));
                if (userAnswer == null) {
                    int quit = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you want to go back to the main menu?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (quit == JOptionPane.YES_OPTION) {
                        return 1;
                    }
                    break;
                }
            } while (userAnswer.isEmpty());

            if (userAnswer.equalsIgnoreCase(answers.get(i))) {
                correctAnswers++;
                JOptionPane.showMessageDialog(null, "Correct!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is: " + answers.get(i));
            }
        }
        return 0;
    }

    public String getGrades() { // Added
        return correctAnswers + " out of " + questions.size() + " correct.";
    }
}
