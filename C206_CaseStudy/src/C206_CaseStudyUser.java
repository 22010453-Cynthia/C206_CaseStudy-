import java.util.ArrayList;

public class C206_CaseStudyUser implements CreateUser {

	  private static final String ENTER_AN_OPTION = "Enter an option > ";
	private static final String GOODBYE = "Goodbye!";
	private static final String INVALID_OPTION_PLEASE_TRY_AGAIN = "Invalid option. Please try again.";
	private static final String ENTER_YOUR_EMAIL = "Enter your Email: ";
	private static final String ENTER_YOUR_PASSWORD = "Enter your password: ";
	private static final String LOGIN_FAILED_PLEASE_TRY_AGAIN = "Login failed. Please try again.";
	private static final String LOGIN_SUCCESSFUL = "Login successful!";
	private static final String INVALID_EMAIL_ADDRESS_PLEASE_ENTER_A_VALID_EMAIL = "Invalid email address! Please enter a valid email.";
	private static final String ENTER_EMAIL_ADDRESS = "Enter email address > ";
	private static final int VALID_PASSWORD_LENGTH = 8;
	public static void main(String[] args) {
	        ArrayList<user> userList = new ArrayList<user>();
	        userList.add(new user("John", "john@gmail.com", "password1", "I like to ride at MBS "));
	        userList.add(new user("Mary", "mary@gmail.com", "password2", "I like to ride at ECP"));
	        userList.add(new user("Sam", "sam@gmail.com", "password3", "I like to ride below HDB"));

	        boolean loggedIn = false;
	        int option;

	        while (true) {
	            displayWelcomePage();
	            option = Helper.readInt(ENTER_AN_OPTION);
	            switch (option) {
	                case 1:
	                    createUser(userList);
	                    break;
	                case 2:
	                    loggedIn = login(userList);
	                    if (loggedIn) {
	                        while (true) {
	                            displayUsersMenu();
	                            option = Helper.readInt(ENTER_AN_OPTION);
	                            if (option == 5) {
	                                
	                                break; // Exit the program after logging out
	                            } else {
	                                handleUserMenuOption(option, userList);
	                            }
	                        }
	                    }
	                    break;
	                case 3:
	                    System.out.println(GOODBYE);
	                    return; // Exit the program
	                default:
	                    System.out.println(INVALID_OPTION_PLEASE_TRY_AGAIN);
	            }
	        }
	    }

    public static boolean login(ArrayList<user> userList) { 
        String ugmail = Helper.readString(ENTER_YOUR_EMAIL);
        String upassword = Helper.readString(ENTER_YOUR_PASSWORD);
    
        for (user user : userList) {
            if (user.getUgmail().equalsIgnoreCase(ugmail) && user.getUpassword().equals(upassword)) {
                System.out.println(LOGIN_SUCCESSFUL);
                return true;
            }
        }
    
        System.out.println(LOGIN_FAILED_PLEASE_TRY_AGAIN);
        return false;
    }
    

    public static void createUser(ArrayList<user> userList) { 
        String uName = Helper.readString("Enter username > ");
        String email;
        String password;
        String description;

        while (true) {
            email = Helper.readString(ENTER_EMAIL_ADDRESS);
            if (!validEmail(email)) {
                System.out.println(INVALID_EMAIL_ADDRESS_PLEASE_ENTER_A_VALID_EMAIL);
            } else {
                break;
            }
        }

        while (true) {
            password = Helper.readString("Enter strong password > ");
            if (!validPassword(password)) {
                System.out.println("Invalid password! Password must have at least 8 characters.");
            } else {
                break;
            }
        }

        description = Helper.readString("Enter your biography > ");
        userList.add(new user(uName, email, password, description));
        System.out.println("Account created successfully.");
    }


    public static void displayWelcomePage() {
        System.out.println("========================================");
        System.out.println("*** WELCOME TO BIKER COMMUNITY PORTAL ***");
        System.out.println("========================================");
        System.out.println("1. Create Account");
        System.out.println("2. Login");
        System.out.println("3. Quit");
    }

    public static void displayUsersMenu() {
        setHeader("Users Menu");
        System.out.println("1. Display Users");
        System.out.println("2. Add User");
        System.out.println("3. Delete User");
        System.out.println("4. Update User");
        System.out.println("5. Back to Main Page");
        Helper.line(80, "=");
    }

    public static void handleUserMenuOption(int option, ArrayList<user> userList) {
        switch (option) {
            case 1:
                viewAlluser(userList);
                //viewAllUser(userList);
                break;
            case 2:
                setHeader("ADD NEW User");
                user U = inputuser();
                adduser(userList, U);
                System.out.println("User added");
                break;
            case 3:
                setHeader("DELETE User");
                String userName = Helper.readString("Enter the name of the user to delete > ");
                deleteuser(userList, userName);
                break;
            case 4:
                setHeader("UPDATE USER");
                String userNameToUpdate = Helper.readString("Enter the name of the user to update > ");
                updateuser(userList, userNameToUpdate);
                break;
            case 5:
                // Do nothing, will exit the loop and log out
                break;
            default:
                System.out.println(INVALID_OPTION_PLEASE_TRY_AGAIN);
        }
    }
    
	public static boolean validPassword(String password) {
		return password.length() >= VALID_PASSWORD_LENGTH;
	}
	public static boolean validEmail(String email) {
		return email.contains("@") && email.contains(".");
	}



	public static void menu() {
		C206_CaseStudyUser.setHeader("Users Menu");
		System.out.println("1. Display Users");
		System.out.println("2. Add User");
		System.out.println("3. Delete User");
		System.out.println("4. Update User");
		System.out.println("5. Quit");
		Helper.line(80, "=");
	}		

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String retrieveAllUser(ArrayList<user> userList) {
		String output = "";

		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%-20s %-30s %-35s  \n", userList.get(i).getuName(), userList.get(i).getUbio(), userList.get(i).getUgmail()) ;

		}

		return output;
	}

	public static void viewAlluser(ArrayList<user> userList) {
		System.out.println("USER LIST");
		String output = String.format("%-20s %-30s %-35s \n", "NAME", "BIO", "GMAIL");
		output += retrieveAllUser(userList);
		System.out.println(output);
	}

	
	
	
	
	//public static void viewAllUser(ArrayList<user> userList) {
	  //  System.out.println("USER LIST");
	    //System.out.printf("%-20s %-30s %-35s\n", "NAME", "BIO", "GMAIL");

	    //for (user u : userList) {
	     //   System.out.printf("%-20s %-30s %-35s\n", u.getuName(), u.getUbio(), u.getUgmail());
	    //}
	//}

	
	
	
	
	
	
	
	

	public static user inputuser() {
		String uName = Helper.readString("Enter username > ");
		String Ugmail = Helper.readString("Enter email address> ");
		String Upassword = Helper.readString("Enter strong password> ");
		String Ubio = Helper.readString("Enter your biography> ");
		
			user U = new user(uName, Ugmail, Upassword, Ubio);
			return U;
		}



		public static void adduser(ArrayList<user> userList, user U) {
			user item;
			for (int i = 0; i < userList.size(); i++) {
				item = userList.get(i);
				String name = item.getuName();
				if (name.equalsIgnoreCase(U.getuName()))
					return;
			}
			if ((U.getuName().isEmpty()) || (U.getUbio().isEmpty()) || (U.getUgmail().isEmpty()) || (U.getUpassword().isEmpty())) {
				return;
			}

			userList.add(U);
		}
		
		public static void deleteuser(ArrayList<user> userList, String uName) {
			user userToRemove = null;
			for (user user : userList) {
				if (user.getuName().equalsIgnoreCase(uName)) {
					userToRemove = user;
					break;
				}
			}

			   if (userToRemove != null) {
		            String passwordConfirmation = Helper.readString("Enter your password to confirm deletion for " + uName + ":");
		            if (passwordConfirmation.equals(userToRemove.getUpassword())) {
		                userList.remove(userToRemove);
		                System.out.println("User '" + uName + "' has been deleted.");
		            } else {
		                System.out.println("Password incorrect. User '" + uName + "' not deleted.");
		            }
		        } else {
		            System.out.println("User '" + uName + "' not found.");
		        }
		    }
		//ask user password to update
		public static void updateuser(ArrayList<user> userList, String uName) {
			user userToUpdate = null;

			for (user user : userList) {
				if (user.getuName().equalsIgnoreCase(uName)) {
					userToUpdate = user;
					break;
				}
			}

			if (userToUpdate != null) {
				C206_CaseStudyUser.setHeader("UPDATE USER");

				// Get updated details from the user
				String updatedName = Helper.readString("Enter updated User Name> ");
				String updatedBio = Helper.readString("Enter updated User Bio > ");
				String updatedgmail = Helper.readString("Enter updated User Gmail > ");
				String updatedpassword = Helper.readString("Enter updated User Password > ");

				// Update the user details
				userToUpdate.setuName(updatedName);
				userToUpdate.setUbio(updatedBio);
				userToUpdate.setUgmail(updatedgmail);
				userToUpdate.setUpassword(updatedpassword);

				System.out.println("User '" + uName + "' has been updated.");
			} else {
				System.out.println("User '" + uName + "' not found.");
			}
		}

	}
//