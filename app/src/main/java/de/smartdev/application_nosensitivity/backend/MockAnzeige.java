package de.smartdev.application_nosensitivity.backend;

/**
 * Created by Andi on 17.11.2015.
 */
public class MockAnzeige {

    public Anzeige createMock1() {
        Anzeige anzeige1 = new Anzeige();
        anzeige1.setAnzeigentxt("Lorem ipsum dolor sit amet, consectetur, adipisci velit, …");
        anzeige1.setTags("Veganer; Halal");
        anzeige1.setAdresse("Musterstraße 1");
        anzeige1.setId(1897865);
        anzeige1.setUserAnzeigeId(000001);
        anzeige1.setLifetime(90);
        return anzeige1;
    }

    public Anzeige createMock2() {
        Anzeige anzeige1 = new Anzeige();
        anzeige1.setAnzeigentxt("Lorem ipsum dolor sit amet, consectetur, adipisci velit, …");
        anzeige1.setTags("Veganer; Asiatisch");
        anzeige1.setAdresse("Musterstraße 2");
        anzeige1.setId(1897890);
        anzeige1.setUserAnzeigeId(000002);
        anzeige1.setLifetime(60);
        return anzeige1;
    }
}
