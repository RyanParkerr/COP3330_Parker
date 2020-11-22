import java.time.LocalDate;

public class TaskItem {
    private String title;
    private String description;
    private LocalDate date;
    private boolean completion;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isComplete() {
        return completion;
    }

    public void complete(boolean completion) {
        this.completion = completion;
    }

    public TaskItem(String title, String description, String date) {
        LocalDate d;
        if(title.length() == 0) {
            throw new IllegalArgumentException("All tasks must be at least 1 character long.");
        }
        try {
            d = LocalDate.parse(date);
        } catch (java.time.format.DateTimeParseException ex) {
            throw new IllegalArgumentException("Date must be in (YYYY-MM-DD) format");
        }

        this.title = title;
        this.description = description;
        this.date = d;
        this.completion = false;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s", date, title, description);
    }

}
