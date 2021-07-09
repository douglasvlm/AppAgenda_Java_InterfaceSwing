package Poo;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Class Agenda
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */

public class Agenda {
    private int id_agenda;
        private int id_event;
            private int id_discipline;
                private int id_time;
                    private String days;
                        private String note;
                            private String eveName;
                                private String disName;
                                    private String time;
                                    
                                        

    public int getId_agenda() {
        return id_agenda;
    }

    public String getEveName() {
        return eveName;
    }

    public void setEveName(String eveName) {
        this.eveName = eveName;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_discipline() {
        return id_discipline;
    }

    public void setId_discipline(int id_discipline) {
        this.id_discipline = id_discipline;
    }

    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }   
    
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String nowFormatado = now.format(formatter);
    SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");
    
    public String getMeuDataChooser(JDateChooser jd){
        if(jd.getDate() != null){
            return Format.format(jd.getDate());
        }else{
            return nowFormatado;
        }
    }
}
