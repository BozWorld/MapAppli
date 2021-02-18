package fr.epsi.epsiproject;

import org.json.JSONObject;

public class Student {

    private String avatar_URL;
    private String description;
    private String nom;
    private String prenom;
    private String email;
    private String group;
    private String url_String;

    public Student(JSONObject o){
        avatar_URL = o.optString("avatar_URL","");
        description = o.optString("Description","");
        nom = o.optString("name","");
        prenom = o.optString("prenom","");
        email = o.optString("email","");
        group = o.optString("group","");
        url_String = o.optString("url_String","");
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

    public String geturl_String() {
        return url_String;
    }

    public void seturl_String(String url_string) {
        this.url_String = url_string;
    }

}
