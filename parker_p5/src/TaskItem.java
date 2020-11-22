import java.time.LocalDate;

public class TaskItem {
    private String title;
    private String description;
    private String date;
    private LocalDate d;
    private boolean completion;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public boolean isComplete() {
        return completion;
    }

    public void complete(boolean completion) {
        this.completion = completion;
    }

    public TaskItem(String title, String description, String date) {
        if (titleIsValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("Title is invalid. Must be at lease 1 character long");
        }
        if (dateIsValid(date)) {
            this.date = d.toString();
        } else {
            throw new InvalidDateException("Date is invalid. Must be in YYY-MM-DD format");
        }
        this.description = description;
        this.completion = false;
    }

    private boolean titleIsValid(String title) {
        return title.length() > 0;
    }

    private boolean dateIsValid(String date) {
        try {
            d = LocalDate.parse(date);
            return true;
        } catch (java.time.format.DateTimeParseException ex) {
            return false;
        }
    }

    class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
    }

    class InvalidDateException extends IllegalArgumentException {
        public InvalidDateException(String msg) {
            super(msg);
        }
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s: %s", date, title, description);
    }

}
