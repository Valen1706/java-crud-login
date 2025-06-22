package model;


public class Person {

    private int id;
    private String firstN;
    private String middleN;
    private String lastN;
    private String gender;
    private String address;

    public Person(int id, String firstN, String middleN, String lastN, String gender, String address ){
        this.id = id;
        this.firstN = firstN;
        this.middleN = middleN;
        this.lastN = lastN;
        this.gender = gender;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstN;
    }

    public String getMiddlename() {
        return middleN;
    }

    public String getLastname() {
        return lastN;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstN(String fName) {
        this.firstN = fName;
    }

    public void setMiddleN(String mName) {
        this.middleN = mName;
    }

    public void setLastN(String lName) {
        this.lastN = lName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
