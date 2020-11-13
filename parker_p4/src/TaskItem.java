

public class TaskItem {
    private String title;
    private String date;
    private String description;

    public TaskItem(String title, String date, String description) {
        if (titleIsValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("Title is invalid. Must be at lease 1 character long");
        }

        if (dateIsValid(date)) {
            this.date = date;
        } else {
            throw new InvalidDateException("Date is invalid. Must be in YYY-MM-DD format");
        }

        if (descriptionIsValid(description)) {
            this.description = description;
        } else {
            throw new InvalidDescriptionException("Description is invalid. Must be at lease 1 character long");
        }
    }

    private boolean titleIsValid(String title) {
        return title.length() > 0;
    }

    private boolean dateIsValid(String date) {
        if (date.indexOf("-") == 4 || date.indexOf("-") == 7) {
            return true;
        } else {
            return false;
        }
    }

    private boolean descriptionIsValid(String description) {
        return description.length() > 0;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
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

    class InvalidDescriptionException extends IllegalArgumentException {
        public InvalidDescriptionException(String msg) {
            super(msg);
        }


//    public static String createTaskItem(Scanner sc, ArrayList taskListArray) {
//        TaskItem ti = new TaskItem();
//        String finalTaskItem;
//
//        String itemTitle = ti.getTitle(sc);
//        String itemDueDate = ti.getDueDate(sc);
//        String itemDescription = ti.getDescription(sc);
//
//        finalTaskItem = "[" + itemDueDate + "] " + itemTitle + ": " + itemDescription;
//        return finalTaskItem;
//    }
//
//        public String getTitle(Scanner sc) {
//            boolean incorrectTitle = true;
//            String itemTitle = null;
//
//            sc.nextLine();
//            while (incorrectTitle) {
//                System.out.println("Enter title of your Task: ");
//                itemTitle = sc.nextLine();
//                if (itemTitle.isEmpty()) {
//                    System.out.println("Empty title, please try again.");
//                } else {
//                    incorrectTitle = false;
//                }
//            }
//            return itemTitle;
//        }
//
//        private String getDueDate(Scanner sc) {
//            boolean incorrectDate = true;
//            String dueDate = null;
//
//            while (incorrectDate) {
//                System.out.println("Enter the due date of your Task in [YYYY-MM-DD] format: ");
//                dueDate = sc.nextLine();
//                if (dueDate.isEmpty()) {
//                    System.out.println("Empty due date, please try again.");
//                } else {
//                    incorrectDate = false;
//                }
//            }
//            return dueDate;
//        }
//
//        private String getDescription(Scanner sc) {
//            boolean incorrectDescription = true;
//            String description = null;
//
//            while (incorrectDescription) {
//                System.out.println("Enter a description for your Task: ");
//                description = sc.nextLine();
//                if (description.isEmpty()) {
//                    System.out.println("Empty description, please try again.");
//                } else {
//                    incorrectDescription = false;
//                }
//            }
//
//            return description;
//        }
    }
}





