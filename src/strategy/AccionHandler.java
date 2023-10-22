package src.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccionHandler{

    private static final List<Accion> listOptions = List.of(new AccionCrear(),
            new AccionClonar(),
            new AccionEliminar(),
            new AccionRegistro(),
            new AccionFiltrar(),
            new AccionMaxDoor(),
            new AccionConvertMap(),
            new AccionEliminarColor());

    public static Map<Integer, Accion> getStrategy() {
        Map<Integer, Accion> strategy = new HashMap<>();
        for (Accion accion  : listOptions) {
            strategy.put(accion.getOpcion(), accion);
        }
        return strategy;
    }
}
