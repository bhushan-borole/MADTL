package com.example.sqlitecrudoperations;

public class Employee {
    int id;
    String name;
    String dept;
    String sal;
    String join;

    public Employee(int id, String name, String dept, String sal, String join) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.sal = sal;
        this.join = join;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }
}
