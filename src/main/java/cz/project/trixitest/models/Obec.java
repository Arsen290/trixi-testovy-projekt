package cz.project.trixitest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Obec {
    @Id
    private int code;
    private String name;

    public Obec(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Obec() {

    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
