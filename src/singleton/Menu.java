package src.singleton;

import src.factory.Juguete;
import src.strategy.Accion;
import src.strategy.AccionHandler;
import src.utils.KeyBoard;

import java.util.*;
import java.util.stream.IntStream;

public final class Menu {

    // en vez de crear la instancia en getInstance, también se puede hacer aca.
    private static Menu instance; // Carga Eager.
    private static final Set<Juguete> juguetes = new LinkedHashSet<>();
    private static final Map<Integer, Accion> strategy = AccionHandler.getStrategy();
    private static final int exit_option = 0;
    private Menu() {}

    public static Menu getInstance() {
        if(instance == null) { // Carga Lazy.
            instance = new Menu();
        }
        return instance;
    }

    public void showMenu() {
        System.out.println("""
                                    
                    \t\t\tProject 1.03.25
                    \t\t----------------------
                    """);
        int op;
        do {
            System.out.print("""
                                    
                                        =================================================
                                        |                  == MENU ==                   |
                                        |     1º Crear juguete.                         |
                                        |     2º Clonar juguete.                        |
                                        |     3º Eliminar juguete.                      |
                                        |     4º Registro juguete.                      |
                                        |     5º Filtrar por juguete.                   |
                                        |     6º Carrito con mayor numero de puertas    |
                                        |     7º Convertir Set a Map                    |
                                        |     8º Eliminar por color                     |
                                        |                                               |
                                        |     0º Finalizar...                           |
                                        =================================================
                            
                            """);
            do {
                try {
                    op = KeyBoard.Int("Ingrese su opción");
                }catch (InputMismatchException e) {
                    System.out.println("\n\t\t * ERROR - Digite un numero *\n");
                    continue;
                }
                break;
            }while (true);

            Accion accion = strategy.get(op);
            if (op == exit_option) { continue; }
            if (accion == null) {
                System.out.println("\n\t\t * Opción desconocida *");
            }else {
                accion.aplicar();
            }
        } while (op != exit_option);
    }
    public static Set<Juguete> getJugetes() {
        return juguetes;
    }

    public static void OrganizarIds() { // Método que organiza id con IntStream :D
        Iterator<Juguete> jugueteIterator = juguetes.iterator();
        IntStream.range(1, juguetes.size()+1)
                .forEach(index -> jugueteIterator.next().setId(index));
    }
}
