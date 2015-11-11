package de.smartdev.application_nosensitivity.backend;


/**
 * Created by lukas on 10.11.15.
 */
public class Anzeige {

    private String anzeigenText;
    private String tags;
    private String adresse;
    private int lifetime;
    private long userAnzeigeId;
    private long id;


    public long getId() { return  id;}

    public void setId(long id) { this.id = id;}



    public String getAnzeigentxt() {
        return anzeigenText;
    }

    public void setAnzeigentxt(String anzeigentxt) {
        this.anzeigenText = anzeigentxt;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public long getUserAnzeigeId(){return userAnzeigeId; }

    public void setUserAnzeigeId(long id_u){this.userAnzeigeId = id_u;}


}
