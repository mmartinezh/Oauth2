package com.github.arocketman.entities;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role extends BaseEntity{

    private String name;
    Role(){}
    public Role (String name) {this.name=name;}
    public String getName() {return name;}
    public void setName(String name) {this.name=name;}
}
