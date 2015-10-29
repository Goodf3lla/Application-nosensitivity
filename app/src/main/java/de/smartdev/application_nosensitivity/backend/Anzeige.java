package de.smartdev.application_nosensitivity.backend;

/**
 * Created by Andi on 26.10.2015.
 */
public class Anzeige {

    public String anzeigentxt;
    public String tags;
    public String adresse;
    public int lifetime;
    private int id;

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public String getAnzeigentxt() {
        return anzeigentxt;
    }

    public void setAnzeigentxt(String anzeigentxt) {
        this.anzeigentxt = anzeigentxt;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

