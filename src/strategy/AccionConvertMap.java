package src.strategy;

import src.factory.Juguete;
import src.singleton.Menu;

import java.util.Map;
import java.util.stream.Collectors;

public class AccionConvertMap implements Accion{
    @Override
    public void aplicar() {
        System.out.println("\n\t   -------------------------");
        System.out.println("\t\tCONVERTIR SET A MAPA\n");

        Map<Long, Juguete> juguetesMap = Menu.getJugetes().stream()
                .collect(Collectors.toMap(juguete -> Long.valueOf(juguete.getId()), juguete -> juguete));

        juguetesMap.forEach((key, value) -> System.out.printf("\t[Key -> %s : Value -> %s%n", key, value));
    }

    @Override
    public int getOpcion() {
        return 7;
    }
}
