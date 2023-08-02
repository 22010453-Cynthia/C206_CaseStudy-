import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Events> eventsList = new ArrayList<Events>();
		eventsList.add(new Events("Summer Adventure Ride", "9:00 AM ", "15 AUG 2023", "Forest Trails Park",
				"Join us for an exhilarating summer adventure ride ."));

		eventsList.add(new Events("Family Fun Bike Rally", "10:00AM", "5 SEP 2023", "City Park", "Calling all families! ."));

		eventsList.add(new Events("Night Glow Bike Parade", "7:00PM", "20 NOV 2023", "Downtown City Streets",
				"Embrace the magic of the night!"));

		int option = 0;

		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all events
				C206_CaseStudy.viewAllevents(eventsList);
            }else if (option == 2) {
            	C206_CaseStudy.setHeader("ADD NEW EVENTS");
					Events E = inputEvents();
					C206_CaseStudy.addEvents(eventsList, E);
					System.out.println("Event added");

				} else if (option == 3) {
					// Delete an event
					C206_CaseStudy.setHeader("DELETE EVENT");
					String eventName = Helper.readString("Enter the name of the event to delete > ");
					C206_CaseStudy.deleteEvent(eventsList, eventName);
				}   else if (option == 4) {
		            // Update an event
					C206_CaseStudy.setHeader("UPDATE EVENT");
		            String eventNameToUpdate = Helper.readString("Enter the name of the event to update > ");
		            C206_CaseStudy.updateEvent(eventsList, eventNameToUpdate);
		        } else if (option == 5) {
		            System.out.println("Goodbye!");
		        } else {
		            System.out.println("Invalid option. Please try again.");
			}
		}
	}
	

	

	public static void menu() {
		C206_CaseStudy.setHeader("Events Menu");
		System.out.println("1. Display Events");
		System.out.println("2. Add Events");
		System.out.println("3. Delete Events");
		System.out.println("4. Update Events");
		System.out.println("5. Quit");
		Helper.line(80, "=");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String retrieveAllEvents(ArrayList<Events> eventsList) {
		String output = "";

		for (int i = 0; i < eventsList.size(); i++) {
			output += String.format("%-25s %-10s %-15s %-25s %-30s\n", eventsList.get(i).geteName(),
					eventsList.get(i).geteTime(), eventsList.get(i).geteDate(), eventsList.get(i).geteVenue(),
					eventsList.get(i).geteDescription());

		}

		return output;
	}

	public static void viewAllevents(ArrayList<Events> eventsList) {
		System.out.println("EVENTS LIST");
		String output = String.format("%-25s %-10s %-15s %-25s %-30s\n", "NAME", "TIME", "DATE", "VENUE",
				"DESCRIPTION");
		output += retrieveAllEvents(eventsList);
		System.out.println(output);
	}

	public static Events inputEvents() {
		String nName = Helper.readString("Enter Events Name > ");
		String nTime = Helper.readString("Enter Event Time> ");
		String nDate = Helper.readString("Enter Event Date> ");
		String nVenue = Helper.readString("Enter Event Venue > ");
		String nDescription = Helper.readString("Enter Event Description> ");

		Events E = new Events(nName, nTime, nDate, nVenue, nDescription);
		return E;
	}
	
	

	public static void addEvents(ArrayList<Events> EventsList, Events E) {
		Events item;
		for (int i = 0; i < EventsList.size(); i++) {
			item = EventsList.get(i);
			String name = item.geteName();
			if (name.equalsIgnoreCase(E.geteName()))
				return;
		}
		if ((E.geteName().isEmpty()) || (E.geteDescription().isEmpty())) {
			return;
		}

		EventsList.add(E);
	}

	public static void deleteEvent(ArrayList<Events> eventsList, String eName) {
	    Events eventToRemove = null;
	    for (Events event : eventsList) {
	        if (event.geteName().equalsIgnoreCase(eName)) {
	            eventToRemove = event;
	            break;
	        }
	    }

	    if (eventToRemove != null) {
	        eventsList.remove(eventToRemove);
	        System.out.println("Event '" + eName + "' has been deleted.");
	    } else {
	        System.out.println("Event '" + eName + "' not found.");
	    }
	}
	    public static void updateEvent(ArrayList<Events> eventsList, String eName) {
	        Events eventToUpdate = null;

	        for (Events event : eventsList) {
	            if (event.geteName().equalsIgnoreCase(eName)) {
	                eventToUpdate = event;
	                break;
	            }
	        }

	        if (eventToUpdate != null) {
	        	C206_CaseStudy.setHeader("UPDATE EVENTS");

	            // Get updated details from the user
	            String updatedTime = Helper.readString("Enter updated Event Time > ");
	            String updatedDate = Helper.readString("Enter updated Event Date > ");
	            String updatedVenue = Helper.readString("Enter updated Event Venue > ");
	            String updatedDescription = Helper.readString("Enter updated Event Description > ");

	            // Update the event details
	            eventToUpdate.seteTime(updatedTime);
	            eventToUpdate.seteDate(updatedDate);
	            eventToUpdate.seteVenue(updatedVenue);
	            eventToUpdate.seteDescription(updatedDescription);

	            System.out.println("Event '" + eName + "' has been updated.");
	        } else {
	            System.out.println("Event '" + eName + "' not found.");
	        }
	    }

}
