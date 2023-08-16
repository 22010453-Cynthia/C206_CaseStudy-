public class Registration {
    private String attendeeName;
    private String attendeeEmail;
    private Events event;

    public Registration(String attendeeName, String attendeeEmail, Events event) {
        this.attendeeName = attendeeName;
        this.attendeeEmail = attendeeEmail;
        this.event = event;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public String getAttendeeEmail() {
        return attendeeEmail;
    }

    public void setAttendeeEmail(String attendeeEmail) {
        this.attendeeEmail = attendeeEmail;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }
}
