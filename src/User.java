import java.util.ArrayList;

public class User { // Added
    private String username;
    private String password;
    private static ArrayList<String> scores = new ArrayList();
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

    public static void storeGrades() {
        String grade = testManager.getGradesInfo();
        scores.add(grade);
        System.out.println(scores);
    }

    public static ArrayList<String> returnGradeslist(){
        return scores;
    }
}
