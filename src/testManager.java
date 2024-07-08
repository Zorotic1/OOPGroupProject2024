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
                    System.out.println(found);
                    break;
                }
            }
            if(!found) {
                System.out.println(question);
                questions.add(question);
                answers.add(answer);
            }
        }
        else{
            System.out.println(question);
            questions.add(question);
            answers.add(answer);
        }

    }


    public void startTest() {
        correctAnswers = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);

        for (int i : indices) {
            String userAnswer = JOptionPane.showInputDialog(questions.get(i));
            if (userAnswer != null && userAnswer.equalsIgnoreCase(answers.get(i))) {
                correctAnswers++;
                JOptionPane.showMessageDialog(null,"Correct!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is: " + answers.get(i));
            }
        }
    }

    public String getGrades() { // Added
        return correctAnswers + " out of " + questions.size() + " correct.";
    }
}
