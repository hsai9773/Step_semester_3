package objectClassMethodsInnerClasses.assignment_problems;
import java.util.*;

interface NotificationChannel {
    void send(NoticeStudent s, Notice n);
}

class EmailChannel implements NotificationChannel {
    public void send(NoticeStudent s, Notice n) {
        System.out.println("Email → " + s.name + ": " + n.title);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(NoticeStudent s, Notice n) {
        System.out.println("SMS → " + s.name + ": " + n.title);
    }
}

class AppChannel implements NotificationChannel {
    public void send(NoticeStudent s, Notice n) {
        System.out.println("App → " + s.name + ": " + n.title);
    }
}

class NoticeStudent {
    String name, department;
    List<NotificationChannel> channels;

    NoticeStudent(String n, String d, List<NotificationChannel> c) {
        name = n;
        department = d;
        channels = c;
    }
}

class Notice {
    String title;
    Set<String> departments;

    Notice(String t, String... d) {
        title = t;
        departments = new HashSet<>(Arrays.asList(d));
    }

    boolean valid() {
        return title != null && !title.isBlank() && !departments.isEmpty();
    }
}

class NoticeBoard {
    List<NoticeStudent> students = new ArrayList<>();

    void addStudent(NoticeStudent s) {
        students.add(s);
    }

    void post(Notice n) {
        if (!n.valid()) {
            System.out.println("Invalid notice: title and at least one target department required.");
            return;
        }

        for (NoticeStudent s : students)
            if (n.departments.contains(s.department))
                for (NotificationChannel c : s.channels)
                    c.send(s, n);
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        NoticeStudent asha = new NoticeStudent("Asha", "CSE",
                Arrays.asList(new EmailChannel(), new AppChannel()));

        NoticeStudent ravi = new NoticeStudent("Ravi", "ECE",
                Arrays.asList(new SmsChannel()));

        board.addStudent(asha);
        board.addStudent(ravi);

        board.post(new Notice("Lab Closed Tomorrow", "CSE"));
        board.post(new Notice("Fee Deadline Extended", "CSE", "ECE"));
        board.post(new Notice("Sports Day"));
    }
}