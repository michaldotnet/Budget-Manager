package Repository;

import java.util.*;

public class MapaTypow {

    public static final Map<Integer, String> mapaTypowZakupow;
    static{
        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "Food");
        mapa.put(2, "Clothes");
        mapa.put(3, "Entertainment");
        mapa.put(4, "Other");

        mapaTypowZakupow = Collections.unmodifiableMap(mapa);
    }
}
