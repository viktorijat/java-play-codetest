package io.customers.board.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Customer {

    @Id
    private Long id;
    private String name;

    @JsonDeserialize(using = CustomJsonDeserializer.class)
    @JsonSerialize(using = CustomJsonSerializer.class)
    private DateTime duetime;

    @JsonDeserialize(using = CustomJsonDeserializer.class)
    @JsonSerialize(using = CustomJsonSerializer.class)
    private DateTime jointime;

    public Customer() {
    }

    public Customer(Long id, String name, DateTime duetime, DateTime jointime) {
        this.id = id;
        this.name = name;
        this.duetime = duetime;
        this.jointime = jointime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getDuetime() {
        return duetime;
    }

    public void setDuetime(DateTime duetime) {
        this.duetime = duetime;
    }

    public DateTime getJointime() {
        return jointime;
    }

    public void setJointime(DateTime jointime) {
        this.jointime = jointime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duetime='" + duetime + '\'' +
                ", jointime='" + jointime + '\'' +
                '}';
    }
}
