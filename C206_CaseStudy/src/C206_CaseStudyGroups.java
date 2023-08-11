import java.util.ArrayList;

public class C206_CaseStudyGroups {

	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<group> groupsList = new ArrayList<group>();
		groupsList.add(new group("Summer Adventure Ride",  "we love biking!"));

		groupsList.add(new group("Family Fun Bike Rally", "Sharing competitive biking tips :D"));

		groupsList.add(new group("Night Glow Bike Parade","Making friends."));

		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudyGroups.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all groups
				C206_CaseStudyGroups.viewAllgroup(groupsList);

			} else if (option == 2) {
				C206_CaseStudyGroups.setHeader("ADD NEW GROUP");
				group G = inputgroup();
				C206_CaseStudyGroups.addgroup(groupsList, G);
				System.out.println("Group added");

			} else if (option == 3) {
				// Delete an group
				C206_CaseStudy.setHeader("DELETE Group");

				String groupName = Helper.readString("Enter the name of the group to delete > ");
				C206_CaseStudyGroups.deletegroup(groupsList, groupName);

			} else if (option == 4) {
				// Update an group
				C206_CaseStudyGroups.setHeader("UPDATE GROUP");
				String groupNameToUpdate = Helper.readString("Enter the name of the group to update > ");
				C206_CaseStudyGroups.updategroup(groupsList, groupNameToUpdate);

			} else if (option == OPTION_QUIT) {
				System.out.println("Goodbye!");

			} else {
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	public static void menu() {
		C206_CaseStudyGroups.setHeader("Groups Menu");
		System.out.println("1. Display Groups");
		System.out.println("2. Add Groups");
		System.out.println("3. Delete Groups");
		System.out.println("4. Update Groups");
		System.out.println("5. Quit");
		Helper.line(80, "=");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String retrieveAllGroups(ArrayList<group> groupsList) {
		String output = "";

		int size_ofgrouplist = groupsList.size();
		for (int i = 0; i < size_ofgrouplist; i++) {
			output += String.format("%-25s %-10s \n", groupsList.get(i).getgName(), groupsList.get(i).getgDescription());

		}

		return output;
	}

	public static void viewAllgroup(ArrayList<group> groupsList) {
		System.out.println("GROUP LIST");
		String output = String.format("%-25s %-10s\n", "NAME", "DESCRIPTION");
		output += retrieveAllGroups(groupsList);
		System.out.println(output);
	}

	public static group inputgroup() {
		String gName = Helper.readString("Enter Group Name > ");
		String gDescription = Helper.readString("Enter Group Description> ");

		group G = new group(gName, gDescription);
		return G;
	}

	public static void addgroup(ArrayList<group> groupList, group G) {
		group item;
		String getgName = G.getgName();
		for (int i = 0; i < groupList.size(); i++) {
			item = groupList.get(i);
			String name = item.getgName();
			if (name.equalsIgnoreCase(getgName))
				return;
		}
		if ((getgName.isEmpty()) || (G.getgDescription().isEmpty())) {
			return;
		}

		groupList.add(G);
	}

	public static void deletegroup(ArrayList<group> groupList, String gName) {
		group groupToRemove = null;
        for (group group : groupList) {
            if (group.getgName().equalsIgnoreCase(gName)) {
            	groupToRemove = group;
                break;
            }
        }

           if (groupToRemove != null) {
                char Confirmation = Helper.readChar("Are You Sure? Enter (Y or N) > ");
                if (Confirmation == 'Y' || Confirmation == 'y') {
                	groupList.remove(groupToRemove);
                    System.out.println("Group '" + gName + "' has been deleted.");
                
                }
            } else {
                System.out.println("Group '" + gName + "' not found.");
            }
        }

	public static void updategroup(ArrayList<group> groupList, String gName) {
		group groupToUpdate = null;

		for (group group : groupList) {
			if (group.getgName().equalsIgnoreCase(gName)) {
				groupToUpdate = group;
				break;
			}
		}

		if (groupToUpdate != null) {
			C206_CaseStudyGroups.setHeader("UPDATE GROUP");

			// Get updated details from the user
			String updatedName = Helper.readString("Enter updated Group Name> ");
			String updatedDescription = Helper.readString("Enter updated Group Description > ");

			// Update the group details
			groupToUpdate.setgName(updatedName);
			groupToUpdate.setgDescription(updatedDescription);

			System.out.println("Group '" + gName + "' has been updated.");
		} else {
			System.out.println("Group '" + gName + "' not found.");
		}
	}

}
