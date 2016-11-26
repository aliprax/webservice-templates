package me.aliprax.types;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "helloCount")
public class HelloCountType {

    private Integer count;

    public HelloCountType() {

    }

    public HelloCountType(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
