
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Individual_Weaver {
	
	private Connection conn;
	private Statement statement;
	private ResultSet rs;
	
	private String currentUserID;
    private String currentUsername;
	
	public static void main(String[] args) {
		Individual_Weaver cs = new Individual_Weaver();
		cs.start();
	} //End of Main Method
			
	public void start() {
        try {
            String connectionString = "jdbc:mysql://localhost/chiamxco_forga";
            String userid = "root";
            String password = "";

            conn = DriverManager.getConnection(connectionString, userid, password);
            statement = conn.createStatement();

            int optionMM = 0;
            int optionLM = 0;
            int optionRM = 0;

            while (optionLM != -1) {
                loginMenu();
                optionLM = Helper.readInt("Select Option > ");
                if (optionLM == 1) {
                    if (login()) {
                        System.out.println("Login successful.");
                        while (optionMM != -1) {
                            mainMenu();
                            optionMM = Helper.readInt("Select Option > ");
                            if (optionMM == 1) {
                                optionRM = 0; // Reset registration menu option
                                while (optionRM != -1) {
                                    registrationMenu();
                                    optionRM = Helper.readInt("Select Option > ");
                                    if (optionRM == 1) {
                                        displayEventJoined();
                                    } else if (optionRM == 2) {
                                        register();
                                    } else if (optionRM == 3) {
                                        withdraw();
                                    } else if (optionRM == 4) {
                                        System.out.println("Returning to Main Menu\n");
                                        break;
                                    } else {
                                        System.out.println("Invalid number");
                                    }
                                }
                            } else if (optionMM == 2) {
                                logout();
                                System.out.println("Logging out...\n");
                                break;
                            } else {
                                System.out.println("Invalid Number");
                            }
                        }
                    } else {
                        System.out.println("Login failed. Invalid username or password.");
                    }
                } else if (optionLM == 2) {
                    System.out.println("Goodbye :)");
                    break;
                } else {
                    System.out.println("Invalid Number");
                }
            }
        } catch (SQLException se) {
            System.out.println("Error: " + se.getMessage());
        }
    }
	
	
	
	//Menus
	
	public void loginMenu() {
		Individual_Weaver.setHeader("Login/Sign Up Menu");
		System.out.println("Username: admin\n Password: @Admin01");		
		System.out.println("");
		System.out.println("1. Login");
		System.out.println("2. Exit");
		Helper.line(80, "=");
	}
	
	public void mainMenu() {
		Individual_Weaver.setHeader("Main Menu");
		if (currentUsername != null) {
		System.out.println("Logged in as: " + currentUsername);
		}	
		System.out.println("1. Registration");
		System.out.println("2. Log out");
		Helper.line(80, "=");
	}
	
	public void registrationMenu() {
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

	//Methods
	
	private void logout() {
        // Clear user information on logout
        currentUserID = null;
        currentUsername = null;
    }
	
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

} //End of Class