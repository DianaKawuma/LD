package imy320_android_assignment.personalassistant;

public class Event {

    private String eventHeading;
    private String eventDate;
    private String eventNote;


    public Event(String eventHeading, String eventDate, String eventNote) {
        super();
        this.eventHeading = eventHeading;
        this.eventDate = eventDate;
        this.eventNote = eventNote;
    }

    public String getEventHeading() {
        return eventHeading;
    }
    public void setEventHeading(String eventHeading) {
        this.eventHeading = eventHeading;
    }

    public String getEventDate() {
        return eventDate;
    }
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
    public String getEventNote() {
        return eventNote;
    }
    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }



}

