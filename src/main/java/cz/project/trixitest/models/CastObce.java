package cz.project.trixitest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "partlocation")
public class CastObce {
    @Id
    private int code; // Code of the part locality
    private String name;
    private int obecCode; // Code of the locality

    public CastObce(int code, String name, int obecCode) {
        this.code = code;
        this.name = name;
        this.obecCode = obecCode;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getObecCode() {
        return obecCode;
    }
}