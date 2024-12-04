package edu.jsp.httpsopratons;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class BookInfo {
    @Id
    private int id;
    private String bname;
    private String type;
    private int pages;
    private double price;
    private String aname;
}
