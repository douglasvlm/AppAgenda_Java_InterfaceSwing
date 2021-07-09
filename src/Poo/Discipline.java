package Poo;

/**
 * Class Discipline
 * @version 1.1
 * @since 2019/2021
 * @author Douglas 
 */
public class Discipline {
    private int id_disicipline;
        private String name;

    public int getId_disicipline() {
        return id_disicipline;
    }

    public void setId_disicipline(int id_disicipline) {
        this.id_disicipline = id_disicipline;
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
