import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactItem {
    private Pattern p;
    private Matcher m;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        if(contactIsValid(firstName, lastName, phoneNumber, emailAddress)) {
            if(phoneNumberIsValid(phoneNumber)) {
                this.phoneNumber = phoneNumber;
            } else {
                throw new InvalidPhoneNumberException("Phone Number must be in (xxx-xxx-xxxx) format, or otherwise left blank");
            }
            if(emailIsValid(emailAddress)) {
                this.emailAddress = emailAddress;
            } else {
                throw new InvalidEmailAddressException("Email Address must be in (x@<domain>.<TLD>) format, or otherwise left blank");
            }
            this.firstName = firstName;
            this.lastName = lastName;
        } else {
            throw new InvalidContactException("You must enter at least one set of information");
        }
    }

    private boolean contactIsValid(String firstName, String lastName, String phoneNumber, String emailAddress) {
        if (firstName.length() == 0 & lastName.length() == 0 & phoneNumber.length() == 0 & emailAddress.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean phoneNumberIsValid(String phoneNumber) {
        if (phoneNumber.isBlank()) {
            return true;
        } else {
            String regex = "^(\\d{3}[-]){2}\\d{4}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phoneNumber);
            return m.matches();
        }
    }

    private boolean emailIsValid(String emailAddress) {
        if (emailAddress.isBlank()) {
            return true;
        } else {
            String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
       // Previous regex attempts learning the library:
//        String regex = "\b[A-Za-z0-9._%+-]+@[A-Z0-9.-]+.[A-Za-z]{2,}\b";
//        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9]+\.[A-Za-z]{2,}$"; 
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(emailAddress);
            return m.matches();
        }
    }
    class InvalidContactException extends IllegalArgumentException {
        public InvalidContactException(String msg) { super(msg); }
    }

    class InvalidPhoneNumberException extends IllegalArgumentException {
        public InvalidPhoneNumberException(String msg) { super(msg); }
    }

    class InvalidEmailAddressException extends IllegalArgumentException {
        public InvalidEmailAddressException(String msg) { super(msg); }
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s \n Phone Number: %s \n Email Address: %s ", firstName, lastName, phoneNumber, emailAddress);
    }
}
