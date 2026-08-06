import entities.Comment;
import entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow that's awesome!");
        LocalDateTime moment = LocalDateTime.parse("21/06/2026 16:00:50", formatter);
        Post p1 = new Post(moment,
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country",
                12);
        p1.addComment(c1);
        p1.addComment(c2);

        Comment c3 = new Comment("Good night guys");
        Comment c4 = new Comment("May the Force be with you");
        LocalDateTime moment2 = LocalDateTime.parse("21/06/2026 16:00:50", formatter);
        Post p2 = new Post(moment2,
                "Good night guys",
                "See you tomorrow",
                5);

        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p1);
        System.out.println(p2);

    }
}