/*MovieTime – Theater Show Listings (Insertion Sort)
Story: A movie theater allows users to sort upcoming showtimes. Since shows are added
throughout the day and the existing list is almost sorted, the app uses Insertion Sort to insert
each new show in the correct time slot.
Concepts Involved:
● Insertion Sort
● Real-time insertion
● Time-based ordering */

class Show {
    String title;
    String time; // Stored as "HH:mm"

    public Show(String title, String time) {
        this.title = title;
        this.time = time;
    }

    @Override
    public String toString() {
        return title + " at " + time;
    }
}

public class MovieTime {
    public static void main(String[] args) {
        Show[] shows = new Show[5];
        shows[0] = new Show("Movie A", "10:00");
        shows[1] = new Show("Movie B", "12:30");
        shows[2] = new Show("Movie C", "15:00");

        // Add new shows in real-time
        insertShow(shows, 3, new Show("Movie D", "11:15"));
        insertShow(shows, 4, new Show("Movie E", "13:45"));

        // Display final sorted showtimes
        System.out.println("Showtimes (sorted):");
        for (Show s : shows) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }

    // Insertion sort logic with string comparison
    public static void insertShow(Show[] shows, int count, Show newShow) {
        shows[count] = newShow;

        for (int i = 1; i <= count; i++) {
            Show key = shows[i];
            int j = i - 1;

            while (j >= 0 && shows[j].time.compareTo(key.time) > 0) {
                shows[j + 1] = shows[j];
                j--;
            }

            shows[j + 1] = key;
        }
    }
}
