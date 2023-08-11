
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C206_CaseStudy {
	
	private Connection conn;
	private Statement statement;
	private ResultSet rs;
	
	private String currentUserID;
    private String currentUsername;
	
	public static void main(String[] args) {
		C206_CaseStudy cs = new C206_CaseStudy();
		cs.start();
	} //End of Main Method
			
	public void start() {
		
		try {
			String connectionString = "jdbc:mysql://localhost/chiamxco_forga";
			String userid = "root";
			String password = "";
			
			conn = DriverManager.getConnection(connectionString, userid, password);
			statement = conn.createStatement();
			
			int optionMM = 0; //option tracker for Main Menu
			int optionLM = 0; //option tracker for Login Menu
			int optionGM = 0; //option tracker for Group Menu
			int optionEM = 0; //option tracker for Event Menu
			int optionRM = 0; //option tracker for Registration Menu
			int optionDM = 0; //option tracker for Discussion Menu
			int optionUM = 0; //option tracker for User Menu
			
			while (optionLM != -1) { //Start of WHILE statement 1
				
				loginMenu();
				optionLM = Helper.readInt("Select Option > ");
				if (optionLM == 1) {
					
					//call method: For logging in
					if (login() == true) {
					    System.out.println("Login successful.");
					    // Perform actions after successful login
					} else {
					    System.out.println("Login failed. Invalid username or password.");
					    continue;
					}
									
					while (optionMM != -1) {
						
						mainMenu();
						optionMM = Helper.readInt("Select Option > ");
						if (optionMM == 1) {
							
							while (optionGM != -1) { //Start of WHILE statement 2
								//call group menu
								groupMenu();
								optionGM = Helper.readInt("Select Option > ");
								if (optionGM == 1) {
									
									//calling method: Display Groups user is in
									displayGroup();
								} else if (optionGM == 2) {
								
									//calling method: Add new group
									addGroup();
								} else if (optionGM == 3) {
								
									//calling method: Join Group
									joinGroup();
								} else if (optionGM == 4) {
								
									//calling method: Delete Group user have created
									deleteGroup();
								} else if (optionGM == 5) {
								
									//calling method: Update Group detail user have created
									updateGroup();
								} else if (optionGM == 6) {
								
									//returning to Main Menu
									System.out.println("Returning to Main Menu \n");
									break;
								} else {	
									
									//Checking for invalid number 
									System.out.println("Invalid Number");
								}
							} //End of WHILE statement 2
							
						} else if (optionMM == 2) {
							
							while (optionEM != -1) { //Start of WHILE statement 3
								
								//call event menu
								eventMenu();
								optionEM = Helper.readInt("Select Option > ");
								if (optionEM == 1) {
									
									//calling method: Display all events
									displayEvent();
								} else if (optionEM == 2) {
									
									//calling method: Add new events
									addEvent();
								} else if (optionEM == 3) {
									
									//calling method: Delete events user have made
									deleteEvent();
								} else if (optionEM == 4) {
									
									//calling method: Update event details user have made
									updateEvent();
								} else if (optionEM == 5) {
									
									//returning to Main Menu
									System.out.println("Returning to Main Menu \n");
									break;
								} else {
									
									//Checking for invalid number 
									System.out.println("Invalid Number");
								}
							} //End of WHILE statement 3
							
						} else if (optionMM == 3) {
							
							while (optionRM != -1) { //Start of WHILE statement 4

								//call registration menu
								registrationMenu();
								optionRM = Helper.readInt("Select Option > ");
								if (optionRM == 1) {
									
									//calling method: Display events that user have joined
									displayEventJoined();
								} else if (optionRM == 2) {
									
									//calling method: Register for events
									register();
								} else if (optionRM == 3) {
									
									//calling method: Withdraw events user have joined
									withdraw();
								} else if (optionRM == 4) {
														
									//returning to Main Menu
									System.out.println("Returning to Main Menu \n");
									break;
								} else {
									
									//Checking for invalid number
									System.out.println("Invalid number");
								}
							} //End of WHILE statement 4
							
						} else if (optionMM == 4) {
							
							while (optionDM != -1) { //Start of WHILE statement 5
								
								//call discussion menu
								discussionMenu();
								optionDM = Helper.readInt("Select Option > ");
								if (optionDM == 1) {
									
									//call method: Create discussion in a group user has joined
									createDiscussion();
								} else if (optionDM == 2) {
									
									//call method: View all discussion names in a group
									viewDiscussion();
								} else if (optionDM == 3) {
									
									//call method: Delete discussions user created
									deleteDiscussion();
								} else if (optionDM == 4) {
									
									//returning to Main Menu
									System.out.println("Returning to Main Menu \n");
									break;
								} else {
									
									//Checking for invalid number
									System.out.println("Invalid number");
								}
							} //End of WHILE statement 5
							
						} else if (optionMM == 5) {
							
							while (optionUM != -1) { //Start of WHILE statement 6
								
								//call user menu
								userMenu();
								optionUM = Helper.readInt("Select Option > ");
								if (optionUM == 1) {
									
									//calling method: Displaying all users
									displayUsers();
								} else if (optionUM == 2) {
									
									//calling method: View user bio
									viewBio();
								} else if (optionUM == 3) {
									
									//calling method: Update user bio
									updateBio();
								} else if (optionUM == 4) {
									
									//calling method: Delete user bio
									deleteBio();
								} else if (optionUM == 5 ) {
									
									//returning to Main Menu
									System.out.println("Returning to Main Menu \n");
									break;
								} else {
									
									//Checking for invalid number
									System.out.println("Invalid number");
								}
							} //End of WHILE statement 6
							
						} else if (optionMM == 6) {
							
							//calling logout method and returning to Login Menu
							logout();
							System.out.println("Logging out... \n");
							break;
						} else {

							//Checking for invalid number 
							System.out.println("Invalid Number");
						}
					}
					
				} else if (optionLM == 2) {
					
					//calling method: Creating Account
					createAcc();
					
				} else if (optionLM == 3) {
					
					//calling method: admin login to delete username
					deleteAcc();
					
				} else if (optionLM == 4) {
					
					// System shutdown
					System.out.println("Goodbye :)");
					break;
				} else {
					
					//Checking for invalid number 
					System.out.println("Invalid Number");
				}
				
				
			} //End of WHILE statement 1
		} catch (SQLException se) {
			System.out.println("Error: " + se.getMessage());
		}
		
		

	} //End of Start Method
	
	
	
	//Menus
	
	public void loginMenu() {
		C206_CaseStudy.setHeader("Login/Sign Up Menu");
		System.out.println("1. Login");
		System.out.println("2. Create New Account");
		System.out.println("3. Delete Users (Admin Account only)");
		System.out.println("4. Exit");
		Helper.line(80, "=");
	}
	
	public void mainMenu() {
		C206_CaseStudy.setHeader("Main Menu");
		if (currentUsername != null) {
		System.out.println("Logged in as: " + currentUsername);
		}
		System.out.println("1. Groups");
		System.out.println("2. Events");	
		System.out.println("3. Registration");
		System.out.println("4. Discussions");
		System.out.println("5. Users");
		System.out.println("6. Log out");
		Helper.line(80, "=");
	}
	
	public void groupMenu() {
		C206_CaseStudy.setHeader("Groups Menu");
		System.out.println("1. Display Groups You Are In");
		System.out.println("2. Add New Group");
		System.out.println("3. Join Group");
		System.out.println("4. Delete Groups created by you");
		System.out.println("5. Update Group's details");
		System.out.println("6. Quit");
		Helper.line(80, "=");
	}
	
	public void eventMenu() {
		C206_CaseStudy.setHeader("Events Menu");
		System.out.println("1. Display All Events");
		System.out.println("2. Add Events");
		System.out.println("3. Delete Events");
		System.out.println("4. Update Events");
		System.out.println("5. Quit");
		Helper.line(80, "=");
	}
	
	public void registrationMenu() {
		C206_CaseStudy.setHeader("Registration Menu");
		System.out.println("1. Display Events Joined");
		System.out.println("2. Register for Events");
		System.out.println("3. Withdraw Registration");
		System.out.println("4. Quit");
		Helper.line(80, "=");
	}
	
	public void discussionMenu() {
		C206_CaseStudy.setHeader("Discussion Menu");
		System.out.println("1. Create Discussion in current group");
		System.out.println("2. View All Discussion in current group");
		System.out.println("3. Delete Discussions you have created");
		System.out.println("4. Quit");
		Helper.line(80, "=");
	}

	public void userMenu() {
		C206_CaseStudy.setHeader("User Menu");
		System.out.println("1. Display all Users");
		System.out.println("2. View your bio");
		System.out.println("3. Update your bio");	
		System.out.println("4. Delete your bio");
		System.out.println("5. Quit");
		Helper.line(80, "=");
	}
	
	public static void setHeader(String header) {
		System.out.println("");
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	} 

	
	
	//Methods
	
	private void logout() {
        // Clear user information on logout
        currentUserID = null;
        currentUsername = null;
    }
	
	//Amirul's
	private boolean login() {
	    String username = Helper.readString("Enter Username: ");
	    String password = Helper.readString("Enter Password: ");

	    try {
	        String sql = "SELECT COUNT(*), user_id FROM users WHERE LOWER(username) = '" + username + "' AND BINARY password = '" + password + "'";
	        rs = statement.executeQuery(sql);

	        if (rs.next()) {
	            int count = rs.getInt(1); // Get the count from the first column
	            if (count > 0) {
	                // Store the currentUsername and currentUserID
	                currentUsername = username;
	                currentUserID = rs.getString("user_id");
	                return true;
	            } else {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    } catch (SQLException se) {
	        System.out.println("Error: " + se.getMessage());
	        return false;
	    }
	}
	
	private void createAcc() {
	    String username = Helper.readString("Enter Username: ");
	    String password = Helper.readString("Enter Password: ");
	    String passwordChecker = Helper.readString("Re-enter Password Again: ");
	    
	    // Check if username is not used
	    try {
	        String checkUsernameQuery = "SELECT * FROM users WHERE username = '" + username + "'";
	        ResultSet rs = statement.executeQuery(checkUsernameQuery);
	        
	        if (rs.next()) {
	            System.out.println("Username is already in use. Please choose a different username.");
	            return;
	        }
	    } catch (SQLException se) {
	        System.out.println("Error checking username: " + se.getMessage());
	        return;
	    }
	    
	    // Check if password and passwordChecker match
	    if (!password.equals(passwordChecker)) {
	        System.out.println("Passwords do not match. Please try again.");
	        return;
	    }
	    
	    // Insert new user into users table
	    try {
	        String insertUserQuery = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
	        int rowsAffected = statement.executeUpdate(insertUserQuery);
	        
	        if (rowsAffected > 0) {
	            System.out.println("Account created successfully.");
	        } else {
	            System.out.println("Failed to create account. Please try again.");
	        }
	    } catch (SQLException se) {
	        System.out.println("Error creating account: " + se.getMessage());
	    }
	}
	
	private void deleteAcc() {
	    String adminUsername = Helper.readString("Enter admin username: ");
	    String adminPassword = Helper.readString("Enter admin password: ");
	    
	    // Check if admin credentials are correct
	    if (!adminUsername.equalsIgnoreCase("admin") || !adminPassword.equals("@Admin01")) {
	        System.out.println("Invalid admin credentials. Access denied.");
	        return;
	    }
	    
	    String usernameToDelete = Helper.readString("Enter username to delete: ");
	    String confirm = Helper.readString("Are you sure you want to delete user '" + usernameToDelete + "'? (Y/N): ");
	    
	    // Check if user confirmed the deletion (case-insensitive)
	    if (!confirm.equalsIgnoreCase("Y")) {
	        System.out.println("Deletion cancelled.");
	        return;
	    }
	    
	    // Delete the specified user from the users table
	    try {
	        String deleteUserQuery = "DELETE FROM users WHERE username = '" + usernameToDelete + "'";
	        int rowsAffected = statement.executeUpdate(deleteUserQuery);
	        
	        if (rowsAffected > 0) {
	            System.out.println("User '" + usernameToDelete + "' has been deleted.");
	        } else {
	            System.out.println("User '" + usernameToDelete + "' not found or failed to delete.");
	        }
	    } catch (SQLException se) {
	        System.out.println("Error deleting user: " + se.getMessage());
	    }
	}

	private void displayUsers() {
	    try {
	        String sql = "SELECT * FROM users WHERE LOWER(username) != 'admin'";
	        rs = statement.executeQuery(sql);

	        System.out.println("List of Users:");
	        int count = 1;

	        while (rs.next()) {
	            String username = rs.getString("username");
	            System.out.println(count + ". " + username);
	            count++;
	        }

	    } catch (SQLException se) {
	        System.out.println("Error: " + se.getMessage());
	    }
	}
	
	//Sherya's
	private void viewBio() {
	    try {
	        String sql = "SELECT joined_date, bio FROM users WHERE user_id = '" + currentUserID + "'";
	        rs = statement.executeQuery(sql);

	        if (rs.next()) {
	            String joinedDate = rs.getDate("joined_date").toString();
	            
	            String bio = rs.getString("bio");
	            if (bio == null) {
	                bio = "";
	            }
	            
	            C206_CaseStudy.setHeader("VIEW BIO");
	            System.out.println("Joined Date: " + joinedDate);
	            System.out.println("Bio: " + bio);
	        } else {
	            System.out.println("User not found.");
	        }
	    } catch (SQLException se) {
	        System.out.println("Error: " + se.getMessage());
	    }
	}
	
	private void updateBio() {
	    if (currentUserID != null) {
	        String currentBio = ""; // Initialize an empty bio
	        String bikeBrand = Helper.readString("Enter your Bike Brand: ");
	        if (!bikeBrand.isEmpty()) {
	            currentBio += "Bike Brand: " + bikeBrand + "\n";
	        }

	        String bikeModel = Helper.readString("Enter your Bike Model: ");
	        if (!bikeModel.isEmpty()) {
	            currentBio += "Bike Model: " + bikeModel + "\n";
	        }

	        String bikeColour = Helper.readString("Enter your Bike Colour: ");
	        if (!bikeColour.isEmpty()) {
	            currentBio += "Bike Colour: " + bikeColour + "\n";
	        }

	        String additionalInfo = Helper.readString("Do you want to add any additional information? (Y/N): ");
	        while (additionalInfo.equalsIgnoreCase("Y")) {
	            String info = Helper.readString("Enter additional information: ");
	            if (!info.isEmpty()) {
	                currentBio += info + "\n";
	            }
	            additionalInfo = Helper.readString("Do you want to add more additional information? (Y/N): ");
	        }

	        String updateSql = "UPDATE users SET bio = '" + currentBio + "' WHERE user_id = '" + currentUserID + "'";

	        try {
	            int rowsUpdated = statement.executeUpdate(updateSql);
	            if (rowsUpdated > 0) {
	                System.out.println("Bio updated successfully.");
	            } else {
	                System.out.println("Failed to update bio.");
	            }
	        } catch (SQLException se) {
	            System.out.println("Error updating bio: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}
	
	private void deleteBio() {
	    if (currentUserID != null) {
	        String confirm = Helper.readString("Are you sure you want to delete your bio? (Y/N): ");
	        if (confirm.equalsIgnoreCase("Y")) {
	            String sql = "UPDATE users SET bio = '' WHERE user_id = '" + currentUserID + "'";
	            try {
	                int rowsAffected = statement.executeUpdate(sql);
	                if (rowsAffected > 0) {
	                    System.out.println("Bio deleted successfully.");
	                } else {
	                    System.out.println("Failed to delete bio.");
	                }
	            } catch (SQLException se) {
	                System.out.println("Error deleting bio: " + se.getMessage());
	            }
	        } else {
	            System.out.println("Bio deletion cancelled.");
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	//Cynthia's
	private void displayGroup() {
	    if (currentUserID != null) {
	        try {
	            String sql = "SELECT bg.group_name, bg.description FROM BikingGroups bg JOIN GroupMembers gm ON bg.group_id = gm.group_id " +
	                         "WHERE gm.user_id = '" + currentUserID + "'";
	            
	            rs = statement.executeQuery(sql);
	            
	            System.out.println("Groups You Are In:");
	            int count = 1;
	            
	            while (rs.next()) {
	                String groupName = rs.getString("group_name");
	                String groupDescription = rs.getString("description");
	                System.out.println(count + ". " + groupName);
	                System.out.println("   Description: " + groupDescription + "\n");
	                count++;
	            }
	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	private void addGroup() {
	    if (currentUserID != null) {
	        String groupName = Helper.readString("Enter group name (up to 23 characters): ");
	        String groupDescription = Helper.readString("Enter group description (optional): ");
	        
	        if (!groupName.isEmpty()) {
	            if (groupName.length() <= 23) {
	                try {
	                    // Insert new group into BikingGroups table
	                    String insertGroupQuery = "INSERT INTO BikingGroups (group_name, description, creator_user_id) VALUES ('" + groupName + "', '" + groupDescription + "', '" + currentUserID + "')";
	                    int rowsAffected = statement.executeUpdate(insertGroupQuery);
	                    
	                    if (rowsAffected > 0) {
	                        System.out.println("Group '" + groupName + "' created successfully.");
	                        
	                        // Get the group ID of the newly created group
	                        String getGroupIDQuery = "SELECT group_id FROM BikingGroups WHERE LOWER(group_name) = LOWER('" + groupName + "')";
	                        rs = statement.executeQuery(getGroupIDQuery);

	                        if (rs.next()) {
	                            int groupID = rs.getInt("group_id");

	                            // Join the user to the newly created group
	                            String joinGroupQuery = "INSERT INTO GroupMembers (user_id, group_id) VALUES ('" + currentUserID + "', " + groupID + ")";
	                            int joinRowsAffected = statement.executeUpdate(joinGroupQuery);

	                            if (joinRowsAffected > 0) {
	                                System.out.println("You have been added to the group.");
	                            } else {
	                                System.out.println("Failed to join the group.");
	                            }
	                        } else {
	                            System.out.println("Failed to retrieve group ID.");
	                        }
	                    } else {
	                        System.out.println("Failed to create group. Please try again.");
	                    }
	                } catch (SQLException se) {
	                    System.out.println("Error creating group: " + se.getMessage());
	                }
	            } else {
	                System.out.println("Group name must be only up to 23 characters.");
	            }
	        } else {
	            System.out.println("Group name cannot be empty. Group creation cancelled.");
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}
	
	private void joinGroup() {
	    if (currentUserID != null) {
	        try {
	            String selectGroupsQuery = "SELECT B.group_id, B.group_name, U.username AS group_owner " +
	                                      "FROM BikingGroups B " +
	                                      "JOIN Users U ON B.creator_user_id = U.user_id";
	            rs = statement.executeQuery(selectGroupsQuery);

	            System.out.println("List of Groups:");
	            System.out.printf("%-3s %-25s %s %n", "No.", "Group Name", "Group Owner");
	            int count = 1;

	            while (rs.next()) {
	                String groupName = rs.getString("group_name");
	                String groupOwner = rs.getString("group_owner");

	                System.out.printf("%-3d %-25s %s %n", count, groupName, groupOwner);
	                count++;
	            }

	            String selectedGroupName = Helper.readString("\nEnter the group name you want to join: ");

	            // Check if the user is already in the selected group
	            String checkMembershipQuery = "SELECT * FROM GroupMembers WHERE user_id = '" + currentUserID + "' AND group_id = (SELECT group_id FROM BikingGroups WHERE group_name = '" + selectedGroupName + "')";
	            ResultSet membershipRS = statement.executeQuery(checkMembershipQuery);

	            if (membershipRS.next()) {
	                System.out.println("You are already a member of the selected group.");
	            } else {
	                // Get group ID based on selected group name
	                String getGroupIDQuery = "SELECT group_id FROM BikingGroups WHERE group_name = '" + selectedGroupName + "'";
	                ResultSet groupIDRS = statement.executeQuery(getGroupIDQuery);

	                if (groupIDRS.next()) {
	                    String groupID = groupIDRS.getString("group_id");

	                    // Insert user into GroupMembers
	                    String joinGroupQuery = "INSERT INTO GroupMembers (user_id, group_id) VALUES ('" + currentUserID + "', '" + groupID + "')";
	                    int rowsAffected = statement.executeUpdate(joinGroupQuery);

	                    if (rowsAffected > 0) {
	                        System.out.println("You have successfully joined the group.");
	                    } else {
	                        System.out.println("Failed to join the group. Please try again.");
	                    }
	                } else {
	                    System.out.println("Selected group not found.");
	                }
	            }

	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	private void deleteGroup() {
	    if (currentUserID != null) {
	        try {
	            String displayGroupsQuery;
	            
	            if (currentUsername.toLowerCase().contains("admin")) {
	                // Admin user can view all groups
	                displayGroupsQuery = "SELECT group_name FROM BikingGroups";
	            } else {
	                // Non-admin user can only view groups they've created
	                displayGroupsQuery = "SELECT group_name FROM BikingGroups WHERE creator_user_id = '" + currentUserID + "'";
	            }
	            
	            rs = statement.executeQuery(displayGroupsQuery);
	            
	            System.out.println("Groups available for deletion:");
	            int count = 1;
	            
	            while (rs.next()) {
	                String groupName = rs.getString("group_name");
	                System.out.println(count + ". " + groupName);
	                count++;
	            }
	            
	            String groupNameToDelete = Helper.readString("Enter the name of the group you want to delete: ");
	            
	            // Check if the current user is the creator of the group
	            String checkCreatorQuery = "SELECT creator_user_id FROM BikingGroups WHERE group_name = '" + groupNameToDelete + "'";
	            rs = statement.executeQuery(checkCreatorQuery);
	            
	            if (rs.next()) {
	                String groupCreatorID = rs.getString("creator_user_id");
	                
	                if (groupCreatorID.equals(currentUserID) || currentUsername.toLowerCase().contains("admin")) {
	                    String confirm = Helper.readString("Are you sure you want to delete the group '" + groupNameToDelete + "'? (Y/N): ");
	                    
	                    if (confirm.equalsIgnoreCase("Y")) {
	                        // Get the group ID of the group to delete
	                        String getGroupIDQuery = "SELECT group_id FROM BikingGroups WHERE group_name = '" + groupNameToDelete + "'";
	                        rs = statement.executeQuery(getGroupIDQuery);
	                        
	                        if (rs.next()) {
	                            int groupID = rs.getInt("group_id");
	                            
	                            // Remove all users from the group
	                            String removeUsersQuery = "DELETE FROM GroupMembers WHERE group_id = " + groupID;
	                            int removeUsersRowsAffected = statement.executeUpdate(removeUsersQuery);
	                            
	                            if (removeUsersRowsAffected >= 0) {
	                                // Delete the group
	                                String deleteGroupQuery = "DELETE FROM BikingGroups WHERE group_name = '" + groupNameToDelete + "'";
	                                int rowsAffected = statement.executeUpdate(deleteGroupQuery);
	                                
	                                if (rowsAffected > 0) {
	                                    System.out.println("Group '" + groupNameToDelete + "' and its members have been deleted.");
	                                } else {
	                                    System.out.println("Failed to delete the group.");
	                                }
	                            } else {
	                                System.out.println("Failed to remove users from the group.");
	                            }
	                        } else {
	                            System.out.println("Group not found.");
	                        }
	                    } else {
	                        System.out.println("Group deletion cancelled.");
	                    }
	                } else {
	                    System.out.println("You do not have permission to delete this group.");
	                }
	            } else {
	                System.out.println("Group not found.");
	            }
	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	private void updateGroup() {
	    if (currentUserID != null) {
	        try {
	            String displayGroupsQuery = "SELECT group_name, description FROM BikingGroups WHERE creator_user_id = '" + currentUserID + "'";
	            rs = statement.executeQuery(displayGroupsQuery);

	            System.out.println("Groups available for updating:");
	            int count = 1;

	            while (rs.next()) {
	                String groupName = rs.getString("group_name");
	                String groupDescription = rs.getString("description");
	                System.out.println(count + ". " + groupName + " - " + groupDescription);
	                count++;
	            }

	            String groupNameToUpdate = Helper.readString("Enter the name of the group you want to update: ");
	            
	            // Check if the current user is the creator of the group
	            String checkCreatorQuery = "SELECT creator_user_id FROM BikingGroups WHERE group_name = '" + groupNameToUpdate + "'";
	            rs = statement.executeQuery(checkCreatorQuery);

	            if (rs.next()) {
	                String groupCreatorID = rs.getString("creator_user_id");

	                if (groupCreatorID.equals(currentUserID)) {
	                    String newDescription = Helper.readString("Enter the new description for the group: ");

	                    String updateGroupQuery = "UPDATE BikingGroups SET description = '" + newDescription + "' WHERE group_name = '" + groupNameToUpdate + "'";
	                    int rowsAffected = statement.executeUpdate(updateGroupQuery);

	                    if (rowsAffected > 0) {
	                        System.out.println("Group description updated successfully.");
	                    } else {
	                        System.out.println("Failed to update group description.");
	                    }
	                } else {
	                    System.out.println("You do not have permission to update this group.");
	                }
	            } else {
	                System.out.println("Group not found.");
	            }
	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}
	
	//Yubi's
	private void displayEvent() {
	    try {
	        String sql = "SELECT event_name, start_datetime, end_datetime, location, description FROM Events";
	        rs = statement.executeQuery(sql);
	        
	        System.out.println("All Events:");
	        int count = 1;
	        
	        while (rs.next()) {
	            String eventName = rs.getString("event_name");
	            String startDate = rs.getString("start_datetime");
	            String endDate = rs.getString("end_datetime");
	            String location = rs.getString("location");
	            String eventDescription = rs.getString("description");
	            
	            System.out.println("Event " + count + ":");
	            System.out.println("Event Name: " + eventName);
	            System.out.println("Start Date & Time: " + startDate);
	            System.out.println("End Date & Time: " + endDate);
	            System.out.println("Location: " + location);
	            System.out.println("Description: " + eventDescription);
	            System.out.println();
	            
	            count++;
	        }
	    } catch (SQLException se) {
	        System.out.println("Error: " + se.getMessage());
	    }
	}
	
	private void addEvent() {
	    if (currentUserID != null) {
	        String eventName = Helper.readString("Enter event name: ");
	        String startDateTime = Helper.readString("Enter start date & time (YYYY-MM-DD HH:MM): ");
	        String endDateTime = Helper.readString("Enter end date & time (YYYY-MM-DD HH:MM): ");
	        String location = Helper.readString("Enter location: ");
	        String eventDescription = Helper.readString("Enter event description (optional): ");
	        
	        if (!eventName.isEmpty() && !startDateTime.isEmpty() && !endDateTime.isEmpty() && !location.isEmpty()) {
	            try {
	                String insertEventQuery = "INSERT INTO Events (event_name, start_datetime, end_datetime, location, description, organizer_user_id) VALUES ('" + eventName + "', '" + startDateTime + "', '" + endDateTime + "', '" + location + "', '" + eventDescription + "', '" + currentUserID + "')";
	                int rowsAffected = statement.executeUpdate(insertEventQuery);
	                
	                if (rowsAffected > 0) {
	                    System.out.println("Event '" + eventName + "' created successfully.");
	                } else {
	                    System.out.println("Failed to create event. Please try again.");
	                }
	            } catch (SQLException se) {
	                System.out.println("Error creating event: " + se.getMessage());
	            }
	        } else {
	            System.out.println("Event details cannot be empty. Event creation cancelled.");
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	private void deleteEvent() {
	    if (currentUserID != null) {
	        String checkAdminQuery = "SELECT username FROM Users WHERE user_id = '" + currentUserID + "' AND username LIKE '%admin%'";
	        String selectEventsQuery;

	        try {
	            rs = statement.executeQuery(checkAdminQuery);

	            if (rs.next()) {
	                // User is an admin, can delete any event
	                selectEventsQuery = "SELECT event_id, event_name FROM Events";
	            } else {
	                // User is not an admin, show events created by the user
	                selectEventsQuery = "SELECT event_id, event_name FROM Events WHERE organizer_user_id = '" + currentUserID + "'";
	            }

	            rs = statement.executeQuery(selectEventsQuery);

	            System.out.println("Events:");
	            int count = 1;

	            while (rs.next()) {
	                String eventID = rs.getString("event_id");
	                String eventName = rs.getString("event_name");
	                System.out.println(count + ". " + eventName + " (ID: " + eventID + ")");
	                count++;
	            }

	            int eventToDeleteID = Helper.readInt("\nEnter the ID of the event you want to delete: ");
	            String checkOrganizerQuery = "SELECT organizer_user_id FROM Events WHERE event_id = " + eventToDeleteID;

	            rs = statement.executeQuery(checkOrganizerQuery);

	            if (rs.next()) {
	                String organizerID = rs.getString("organizer_user_id");

	                if (organizerID.equals(currentUserID) || currentUserID.contains("admin")) {
	                    String confirm = Helper.readString("Are you sure you want to delete the event? (Y/N): ");

	                    if (confirm.equalsIgnoreCase("Y")) {
	                        // Remove participants from the event
	                        String removeParticipantsQuery = "DELETE FROM EventParticipants WHERE event_id = " + eventToDeleteID;
	                        int participantsRemoved = statement.executeUpdate(removeParticipantsQuery);

	                        // Delete the event
	                        String deleteEventQuery = "DELETE FROM Events WHERE event_id = " + eventToDeleteID;
	                        int rowsAffected = statement.executeUpdate(deleteEventQuery);

	                        if (rowsAffected > 0) {
	                            System.out.println("Event deleted successfully.");
	                        } else {
	                            System.out.println("Failed to delete event.");
	                        }
	                    } else {
	                        System.out.println("Event deletion cancelled.");
	                    }
	                } else {
	                    System.out.println("You do not have permission to delete this event.");
	                }
	            } else {
	                System.out.println("Event not found.");
	            }
	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	private void updateEvent() {
	    if (currentUserID != null) {
	        String selectEventsQuery = "SELECT event_id, event_name FROM Events WHERE organizer_user_id = '" + currentUserID + "'";
	        
	        try {
	            rs = statement.executeQuery(selectEventsQuery);

	            System.out.println("Events You Have Created:");
	            int count = 1;

	            while (rs.next()) {
	                String eventID = rs.getString("event_id");
	                String eventName = rs.getString("event_name");
	                System.out.println(count + ". " + eventName + " (ID: " + eventID + ")");
	                count++;
	            }

	            int eventToUpdateID = Helper.readInt("\nEnter the ID of the event you want to update: ");
	            String checkOrganizerQuery = "SELECT organizer_user_id FROM Events WHERE event_id = " + eventToUpdateID;

	            rs = statement.executeQuery(checkOrganizerQuery);

	            if (rs.next()) {
	                String organizerID = rs.getString("organizer_user_id");

	                if (organizerID.equals(currentUserID)) {
	                    String newStartDatetime = Helper.readString("Enter new start datetime (yyyy-MM-dd HH:mm:ss) [Leave blank to keep current]: ");
	                    String newEndDatetime = Helper.readString("Enter new end datetime (yyyy-MM-dd HH:mm:ss) [Leave blank to keep current]: ");
	                    String newLocation = Helper.readString("Enter new location [Leave blank to keep current]: ");
	                    String newDescription = Helper.readString("Enter new description [Leave blank to keep current]: ");

	                    String updateEventQuery = "UPDATE Events SET";

	                    if (!newStartDatetime.isEmpty()) {
	                        updateEventQuery += " start_datetime = '" + newStartDatetime + "',";
	                    }
	                    if (!newEndDatetime.isEmpty()) {
	                        updateEventQuery += " end_datetime = '" + newEndDatetime + "',";
	                    }
	                    if (!newLocation.isEmpty()) {
	                        updateEventQuery += " location = '" + newLocation + "',";
	                    }
	                    if (!newDescription.isEmpty()) {
	                        updateEventQuery += " description = '" + newDescription + "',";
	                    }

	                    // Remove trailing comma if any changes were made
	                    if (updateEventQuery.endsWith(",")) {
	                        updateEventQuery = updateEventQuery.substring(0, updateEventQuery.length() - 1);
	                    }

	                    updateEventQuery += " WHERE event_id = " + eventToUpdateID;

	                    int rowsAffected = statement.executeUpdate(updateEventQuery);

	                    if (rowsAffected > 0) {
	                        System.out.println("Event updated successfully.");
	                    } else {
	                        System.out.println("Failed to update event.");
	                    }
	                } else {
	                    System.out.println("You do not have permission to update this event.");
	                }
	            } else {
	                System.out.println("Event not found.");
	            }
	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

		
	//Weaver's 
	private void displayEventJoined() {
	    if (currentUserID != null) {
	        try {
	            String sql = "SELECT e.event_name, e.start_datetime, e.end_datetime, e.location, e.description " +
	                         "FROM Events e " +
	                         "JOIN EventParticipants ep ON e.event_id = ep.event_id " +
	                         "WHERE ep.user_id = '" + currentUserID + "'";
	            
	            rs = statement.executeQuery(sql);
	            
	            System.out.println("Events You Have Joined:");
	            int count = 1;
	            
	            while (rs.next()) {
	                String eventName = rs.getString("event_name");
	                String startDate = rs.getString("start_datetime");
	                String endDate = rs.getString("end_datetime");
	                String location = rs.getString("location");
	                String eventDescription = rs.getString("description");
	                
	                System.out.println("Event " + count + ":");
	                System.out.println("Event Name: " + eventName);
	                System.out.println("Start Date & Time: " + startDate);
	                System.out.println("End Date & Time: " + endDate);
	                System.out.println("Location: " + location);
	                System.out.println("Description: " + eventDescription);
	                System.out.println();
	                
	                count++;
	            }
	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	private void register() {
	    if (currentUserID != null) {
	        try {
	            String selectEventsQuery = "SELECT event_id, event_name FROM Events";
	            rs = statement.executeQuery(selectEventsQuery);

	            System.out.println("Available Events:");
	            int count = 1;

	            while (rs.next()) {
	                String eventID = rs.getString("event_id");
	                String eventName = rs.getString("event_name");
	                System.out.println(count + ". " + eventName + " (ID: " + eventID + ")");
	                count++;
	            }

	            int eventToJoinID = Helper.readInt("\nEnter the ID of the event you want to join: ");
	            String checkParticipantQuery = "SELECT * FROM EventParticipants WHERE user_id = '" + currentUserID + "' AND event_id = " + eventToJoinID;

	            rs = statement.executeQuery(checkParticipantQuery);

	            if (rs.next()) {
	                System.out.println("You are already registered for this event.");
	            } else {
	                String insertParticipantQuery = "INSERT INTO EventParticipants (user_id, event_id) VALUES ('" + currentUserID + "', " + eventToJoinID + ")";
	                int rowsAffected = statement.executeUpdate(insertParticipantQuery);

	                if (rowsAffected > 0) {
	                    System.out.println("You have successfully registered for the event.");
	                } else {
	                    System.out.println("Failed to register for the event. Please try again.");
	                }
	            }
	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	private void withdraw() {
	    if (currentUserID != null) {
	        try {
	            String selectEventsQuery = "SELECT e.event_id, e.event_name " +
	                                       "FROM Events e " +
	                                       "JOIN EventParticipants ep ON e.event_id = ep.event_id " +
	                                       "WHERE ep.user_id = '" + currentUserID + "'";
	            rs = statement.executeQuery(selectEventsQuery);

	            System.out.println("Events You Are Registered For:");
	            int count = 1;

	            while (rs.next()) {
	                String eventID = rs.getString("event_id");
	                String eventName = rs.getString("event_name");
	                System.out.println(count + ". " + eventName + " (ID: " + eventID + ")");
	                count++;
	            }

	            int eventToWithdrawID = Helper.readInt("\nEnter the ID of the event you want to withdraw from: ");

	            // Check if the user is the creator of the event
	            String isEventCreatorQuery = "SELECT * FROM Events WHERE event_id = " + eventToWithdrawID + " AND organizer_user_id = '" + currentUserID + "'";
	            rs = statement.executeQuery(isEventCreatorQuery);

	            if (rs.next()) {
	                System.out.println("As the creator of the event, you cannot withdraw from it.");
	            } else {
	                String deleteParticipantQuery = "DELETE FROM EventParticipants WHERE user_id = '" + currentUserID + "' AND event_id = " + eventToWithdrawID;
	                int rowsAffected = statement.executeUpdate(deleteParticipantQuery);

	                if (rowsAffected > 0) {
	                    System.out.println("You have successfully withdrawn from the event.");
	                } else {
	                    System.out.println("Failed to withdraw from the event. Please try again.");
	                }
	            }
	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	//Ella's
	private void createDiscussion() {
	    if (currentUserID != null) {
	        try {
	            // Display groups the user is in
	            String selectGroupsQuery = "SELECT gm.group_id, bg.group_name FROM GroupMembers gm JOIN BikingGroups bg ON gm.group_id = bg.group_id WHERE gm.user_id = '" + currentUserID + "'";
	            ResultSet groupsRS = statement.executeQuery(selectGroupsQuery);

	            System.out.println("Groups You Are In:");
	            int count = 1;

	            while (groupsRS.next()) {
	                int groupID = groupsRS.getInt("group_id");
	                String groupName = groupsRS.getString("group_name");
	                System.out.println(count + ". " + groupName);
	                count++;
	            }

	            int selectedGroupNumber = Helper.readInt("Enter the group number you want to create a discussion in: ");
	            
	            // Get the group ID based on the selected group number
	            String getGroupIDQuery = "SELECT group_id FROM GroupMembers WHERE user_id = '" + currentUserID + "' LIMIT 1 OFFSET " + (selectedGroupNumber - 1);
	            ResultSet groupIDRS = statement.executeQuery(getGroupIDQuery);

	            if (groupIDRS.next()) {
	                int selectedGroupID = groupIDRS.getInt("group_id");
	                
	                String discussionTitle = Helper.readString("Enter discussion title: ");
	                
	                String insertDiscussionQuery = "INSERT INTO Discussions (group_id, user_id, title) VALUES (" + selectedGroupID + ", '" + currentUserID + "', '" + discussionTitle + "')";
	                int discussionRowsAffected = statement.executeUpdate(insertDiscussionQuery);
	                
	                if (discussionRowsAffected > 0) {
	                    System.out.println("Discussion created successfully.");
	                    
	                    // Ask user if they want to add a comment
	                    String addComment = Helper.readString("Do you want to add a comment to this discussion? (Y/N): ");
	                    if (addComment.equalsIgnoreCase("Y")) {
	                        // Get the discussion ID of the newly created discussion
	                        String getDiscussionIDQuery = "SELECT MAX(discussion_id) AS max_id FROM Discussions";
	                        ResultSet discussionIDRS = statement.executeQuery(getDiscussionIDQuery);

	                        if (discussionIDRS.next()) {
	                            int discussionID = discussionIDRS.getInt("max_id");
	                            String commentContent = Helper.readString("Enter comment content: ");
	                            
	                            String insertCommentQuery = "INSERT INTO Comments (discussion_id, user_id, content) VALUES (" + discussionID + ", '" + currentUserID + "', '" + commentContent + "')";
	                            int commentRowsAffected = statement.executeUpdate(insertCommentQuery);
	                            
	                            if (commentRowsAffected > 0) {
	                                System.out.println("Comment added successfully.");
	                            } else {
	                                System.out.println("Failed to add comment.");
	                            }
	                        } else {
	                            System.out.println("Failed to retrieve discussion ID.");
	                        }
	                    }
	                } else {
	                    System.out.println("Failed to create discussion. Please try again.");
	                }
	            } else {
	                System.out.println("Invalid group number.");
	            }
	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	private void viewDiscussion() {
	    if (currentUserID != null) {
	        try {
	            String selectGroupQuery = "SELECT G.group_name, D.discussion_id, D.title " +
	                                      "FROM BikingGroups G " +
	                                      "JOIN GroupMembers GM ON G.group_id = GM.group_id " +
	                                      "JOIN Discussions D ON G.group_id = D.group_id " +
	                                      "WHERE GM.user_id = '" + currentUserID + "'";
	            ResultSet discussionsRS = statement.executeQuery(selectGroupQuery);

	            System.out.println("Discussion List:");
	            System.out.printf("%-3s %-25s %s %n", "No.", "Group Name", "Discussion Name");
	            int count = 1;

	            while (discussionsRS.next()) {
	                String groupName = discussionsRS.getString("group_name");
	                int discussionID = discussionsRS.getInt("discussion_id");
	                String discussionTitle = discussionsRS.getString("title");

	                System.out.printf("%-3d %-25s %s %n", count, groupName, discussionTitle);
	                count++;
	            }

	            discussionsRS.close(); // Close discussionsRS after processing

	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}

	private void deleteDiscussion() {
	    if (currentUserID != null) {
	        try {
	            String selectQuery = "SELECT D.discussion_id, D.title, D.user_id AS author_id, G.creator_user_id " +
	                                 "FROM Discussions D " +
	                                 "JOIN BikingGroups G ON D.group_id = G.group_id " +
	                                 "WHERE D.user_id = '" + currentUserID + "' OR G.creator_user_id = '" + currentUserID + "'";
	            ResultSet discussionsRS = statement.executeQuery(selectQuery);

	            System.out.println("Discussion List:");
	            System.out.printf("%-3s %-30s %s%n", "No.", "Discussion ID", "Discussion Title");

	            int count = 1;
	            while (discussionsRS.next()) {
	                int discussionID = discussionsRS.getInt("discussion_id");
	                String discussionTitle = discussionsRS.getString("title");

	                System.out.printf("%-3d %-30d %s%n", count, discussionID, discussionTitle);

	                count++;
	            }

	            System.out.println();

	            int selectedDiscussionID = Helper.readInt("Enter the ID of the discussion to delete: ");

	            // Close the discussionsRS ResultSet before executing new query
	            discussionsRS.close();

	            // Query to get discussion info for deletion
	            String selectDiscussionQuery = "SELECT D.discussion_id, D.user_id AS author_id, G.creator_user_id " +
	                                           "FROM Discussions D " +
	                                           "JOIN BikingGroups G ON D.group_id = G.group_id " +
	                                           "WHERE D.discussion_id = " + selectedDiscussionID;
	            ResultSet discussionRS = statement.executeQuery(selectDiscussionQuery);

	            if (discussionRS.next()) {
	                int discussionID = discussionRS.getInt("discussion_id");
	                String authorID = discussionRS.getString("author_id");
	                String groupOwnerID = discussionRS.getString("creator_user_id");

	                if (currentUserID.equals(authorID) || currentUserID.equals(groupOwnerID)) {
	                    String confirm = Helper.readString("Are you sure you want to delete the discussion? (Y/N): ");

	                    if (confirm.equalsIgnoreCase("Y")) {
	                        // Delete comments first
	                        String deleteCommentsQuery = "DELETE FROM Comments WHERE discussion_id = " + discussionID;
	                        statement.executeUpdate(deleteCommentsQuery);

	                        // Delete the discussion
	                        String deleteDiscussionQuery = "DELETE FROM Discussions WHERE discussion_id = " + discussionID;
	                        int rowsAffected = statement.executeUpdate(deleteDiscussionQuery);

	                        if (rowsAffected > 0) {
	                            System.out.println("Discussion and its comments deleted successfully.");
	                        } else {
	                            System.out.println("Failed to delete the discussion. Please try again.");
	                        }
	                    } else {
	                        System.out.println("Discussion deletion cancelled.");
	                    }
	                } else {
	                    System.out.println("You do not have permission to delete this discussion.");
	                }
	            } else {
	                System.out.println("Discussion not found.");
	            }

	            // Close the discussionRS ResultSet
	            discussionRS.close();

	        } catch (SQLException se) {
	            System.out.println("Error: " + se.getMessage());
	        }
	    } else {
	        System.out.println("You are not logged in.");
	    }
	}









	
	
} //End of Class