package imy320_android_assignment.personalassistant;

public class ToDoItem {

    private String eventDate;
    private String eventToDo;



    public ToDoItem(String eventDate, String eventToDo) {
        super();
        this.eventDate = eventDate;
        this.eventToDo = eventToDo;
    }
    public String getEventDate() {
        return eventDate;
    }
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
    public String getEventToDo() {
        return eventToDo;
    }
    public void setEventToDo(String eventToDo) {
        this.eventToDo = eventToDo;
    }

}

