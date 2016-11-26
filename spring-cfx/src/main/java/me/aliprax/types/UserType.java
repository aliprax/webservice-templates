package me.aliprax.types;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
        "name",
        "surname"
})
@XmlRootElement
public class UserType {

    @XmlAttribute(name = "title")
    private String title;

    @XmlElement(name = "name", required = true)
    private String name;

    private String surname;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
