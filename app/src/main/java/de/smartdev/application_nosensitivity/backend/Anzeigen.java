package de.smartdev.application_nosensitivity.backend;

/**
 * Created by lukas on 08.12.15.
 */
public class Anzeigen {

    public static abstract class AnzeigeInfo {
        public static final String ANZEIGE_ID = "anzeige_id";
        public static final String ANZEIGE_TEXT = "anzeige_text";
        public static final String ANZEIGE_TAGS = "anzeige_tags";
        public static final String ANZEIGE_ADRESSE = "anzeige_adresse";
        public static final String ANZEIGE_LIFETIME = "anzeige_lifetime";
        public static final String ANZEIGE_USERS_ANZEIGE_ID = "users_anzeige_id";

        public static final String TABLE_NAME = "anzeige_info";

    }
}
