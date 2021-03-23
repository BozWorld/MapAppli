package fr.epsi.epsiproject.Student;

import org.json.JSONObject;

public class Student {

    private String avatar_URL;
    private String description;
    private String nom;
    private String prenom;
    private String email;
    private String group;

    public Student(JSONObject o){
        avatar_URL = o.optString("avatar_URL","");
        description = o.optString("Description","");
        nom = o.optString("nom","");
        prenom = o.optString("Prenom","");
        email = o.optString("email","");
        group = o.optString("group","");
    }

    public String getAvatar_URL(){
        return avatar_URL;
    }

    public void setAvatar_URL(String avatar){
        this.avatar_URL = avatar;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description =description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String email) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getgroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}
