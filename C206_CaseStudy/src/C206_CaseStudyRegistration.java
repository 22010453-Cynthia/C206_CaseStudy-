import java.util.ArrayList;

public class C206_CaseStudyRegistration {

    public static void main(String[] args) {
        ArrayList<Registration> regList = new ArrayList<Registration>();

        int option = 0;

        while (option != -1) {
            registrationMenu();
            option = Helper.readInt("Enter Option: ");

            if (option == 1) {
            	displayRegistration(regList);
            } else if (option == 2) {
                addRegistration(regList);
            } else if (option == 3) {
                deleteRegistration(regList);
            } else if (option == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid Number. Try Again");
            }
        } // End of WHILE statement
    } // End of Main Method

    // Other methods ...

    public static String displayRegistration(ArrayList<Registration> regList) {
        StringBuilder output = new StringBuilder();

        if (regList.isEmpty()) {
            output.append("No registrations found.");
        } else {
            for (Registration registration : regList) {
                output.append("Attendee Name: ").append(registration.getAttendeeName()).append("\n");
                output.append("Attendee Email: ").append(registration.getAttendeeEmail()).append("\n");
                output.append("Event Name: ").append(registration.getEvent().geteName()).append("\n");
                output.append("Event Time: ").append(registration.getEvent().geteTime()).append("\n");
                output.append("Event Date: ").append(registration.getEvent().geteDate()).append("\n");
                output.append("Event Venue: ").append(registration.getEvent().geteVenue()).append("\n");
                output.append("Event Description: ").append(registration.getEvent().geteDescription()).append("\n");
                output.append("------------------------\n");
            }
        }

        return output.toString();
    }

    public static void addRegistration(ArrayList<Registration> regList) {
        setHeader("Register for Events");
        Registration newRegistration = inputRegistration();
        regList.add(newRegistration);
        System.out.println("Registration added successfully.");
    }

    public static void deleteRegistration(ArrayList<Registration> regList) {
        setHeader("Withdraw Registration");
        String input = Helper.readString("Enter the name or event of the registration to withdraw: ");
        boolean removed = false;

        for (Registration registration : regList) {
            if (registration.getAttendeeName().equalsIgnoreCase(input) || registration.getEvent().geteName().equalsIgnoreCase(input)) {
                regList.remove(registration);
                removed = true;
                System.out.println("Registration withdrawn successfully.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Registration not found.");
        }
    }

    // Other methods ...

    public static Registration inputRegistration() {
        String attendeeName = Helper.readString("Enter your name: ");
        String attendeeEmail = Helper.readString("Enter your email: ");
        // Collect event details from the user
        String eventName = Helper.readString("Enter the name of the event you want to register for: ");
        String eventTime = Helper.readString("Enter the time of the event: ");
        String eventDate = Helper.readString("Enter the date of the event: ");
        String eventVenue = Helper.readString("Enter the venue of the event: ");
        String eventDescription = Helper.readString("Enter the description of the event: ");

        Events event = new Events(eventName, eventTime, eventDate, eventVenue, eventDescription);
        Registration newRegistration = new Registration(attendeeName, attendeeEmail, event);
        return newRegistration;
    }
    
  //Menu
  	public static void registrationMenu() {
  		Individual_Weaver.setHeader("Registration Menu");
  		System.out.println("1. Display Events Joined");
  		System.out.println("2. Register for Events");
  		System.out.println("3. Withdraw Registration");
  		System.out.println("4. Quit");
  		Helper.line(80, "=");
  	}
  	
  	public static void setHeader(String header) {
  		System.out.println("");
  		Helper.line(80, "-");
  		System.out.println(header);
  		Helper.line(80, "-");
  	}
}
