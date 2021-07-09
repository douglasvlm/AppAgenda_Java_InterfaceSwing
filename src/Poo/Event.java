package Poo;
/**
 * Class Event
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */
public class Event {
    private int id_event;
        private String name;

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getName() {
        if(name.trim().isEmpty()){
           name = null;
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}