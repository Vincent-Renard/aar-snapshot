import persistance.PersistanceEngine;

/**
 * @autor Vincent
 * @date 14/10/2020
 */

public class Main {

    public static void main(String ... args) {
        PersistanceEngine pe = new PersistanceEngine();
        pe.insertClient("Riri","Duck","8 rue bp");
        pe.insertClient("FiFi","Duck","8 rue bp");
        pe.insertClient("Loulou","Duck","8 rue bp");

    }
}
