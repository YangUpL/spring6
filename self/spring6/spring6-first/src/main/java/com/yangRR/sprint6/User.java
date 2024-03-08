package com.yangRR.sprint6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class User {

    private String[] hobbies;
    private List<Student> list;
    private Map<String,Student> map;

    public void setMap(Map<String, Student> map) {
        this.map = map;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void add(){
        System.out.println("add");
    }

    public void print(){
        System.out.println(Arrays.toString(hobbies));
        System.out.println(list);
        for (Map.Entry<String, Student> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-"  + entry.getValue());
        }
    }
}
