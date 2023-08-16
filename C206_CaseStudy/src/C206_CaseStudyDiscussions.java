import java.util.ArrayList;

public class C206_CaseStudyDiscussions {

    private static final int OPTION_QUIT = 4;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Discussions> discussionList = new ArrayList<Discussions>();
        discussionList.add(new Discussions("Summer Adventure Ride", "Summer"));

        discussionList.add(new Discussions("Family Fun Bike Rally", "Family!"));

        int option = 0;

        while (option != OPTION_QUIT) {

            C206_CaseStudyDiscussions.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                // View all discussions
                C206_CaseStudyDiscussions.viewAllDiscussions(discussionList);

            } else if (option == 2) {
                C206_CaseStudyDiscussions.setHeader("ADD NEW DISCUSSION");
                Discussions D = inputDiscussions();
                C206_CaseStudyDiscussions.addDiscussions(discussionList, D);
                System.out.println("Discussion added");

            } else if (option == 3) {
                // Delete a discussion
                C206_CaseStudyDiscussions.setHeader("DELETE A DISCUSSION");

                String title = Helper.readString("Enter the name of the discussion to delete > ");
                C206_CaseStudyDiscussions.deleteDiscussion(discussionList, title);

            } else if (option == OPTION_QUIT) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void menu() {
        C206_CaseStudyDiscussions.setHeader("Discussion Menu");
        System.out.println("1. Display Groups");
        System.out.println("2. Add Groups");
        System.out.println("3. Delete Groups");
        System.out.println("4. Quit");
        Helper.line(80, "=");
    }

    public static void setHeader(String header) {
        Helper.line(50, "=");
        System.out.println(header);
        Helper.line(50, "=");
    }

    public static String retrieveAllDiscussions(ArrayList<Discussions> discussionList) {
        String output = "";

        for (int i = 0; i < discussionList.size(); i++) {
            output += String.format("%-25s %-10s \n", discussionList.get(i).getdTitle(), discussionList.get(i).getdTag());

        }

        return output;
    }

    public static void viewAllDiscussions(ArrayList<Discussions> discussionList) {
        System.out.println("DISCUSSION LIST");
        String output = String.format("%-25s %-10s\n", "TITLE", "TAG");
        output += retrieveAllDiscussions(discussionList);
        System.out.println(output);
    }

    public static Discussions inputDiscussions() {
        String dTitle = Helper.readString("Enter Discussion Title > ");
        String dTag = Helper.readString("Enter Discussion Tag > ");

        Discussions D = new Discussions(dTitle, dTag);
        return D;
    }

    public static void addDiscussions(ArrayList<Discussions> discussionList, Discussions D) {
        Discussions item;
        for (int i = 0; i < discussionList.size(); i++) {
            item = discussionList.get(i);
            String name = item.getdTitle();
            if (name.equalsIgnoreCase(D.getdTitle()))
                return;
        }
        if ((D.getdTitle().isEmpty()) || (D.getdTag().isEmpty())) {
            return;
        }

        discussionList.add(D);
    }

    public static void deleteDiscussion(ArrayList<Discussions> discussionList, String dTitle) {
        Discussions discussionToRemove = null;
        for (Discussions discussion : discussionList) {
            if (discussion.getdTitle().equalsIgnoreCase(dTitle)) {
                discussionToRemove = discussion;
                break;
            }
        }

        if (discussionToRemove != null) {
            String confirmation = Helper.readString("Are you sure you want to delete the discussion '" + dTitle + "'? (yes/no) > ");
            if (confirmation.equalsIgnoreCase("yes")) {
                discussionList.remove(discussionToRemove);
                System.out.println("Discussion '" + dTitle + "' has been deleted.");
            } else {
                System.out.println("Deletion of discussion '" + dTitle + "' canceled.");
            }
        } else {
            System.out.println("Discussion '" + dTitle + "' not found.");
        }
    }
}
