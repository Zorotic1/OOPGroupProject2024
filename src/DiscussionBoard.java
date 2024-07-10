import java.util.ArrayList;

public class DiscussionBoard { // New file
    private static ArrayList<String> posts = new ArrayList<>();

    public static void addPost(String post) {
        posts.add(post);
    }

    public static ArrayList<String> getPosts() {
        return posts;
    }
}
