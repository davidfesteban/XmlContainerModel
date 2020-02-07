
import java.util.HashMap;
import java.util.Map;

public class XmlContainerModel {

    /**
     * Esta clase se dedica a representar el estado de las vistas que hay, eliminando hacer un modelo
     * por cada vista y supliendo la necesidad de DataBinding.
     *
     * Ejemplo de uso desde el ViewModel: new XmlContainerModel().addEstadoVista("miEstadoDelSwitch", Boolean.FALSE);
     * Activity: miSwitch.setEnabled(xmlContainerModel.<Boolean>get("miEstadoDelSwitch")
     * Tip: "miEstadoDelSwitch" podría reemplazarse por miSwitch.getId()
     */

    private Map<String, TypeWrapper> valoresMapaVista;

    public XmlContainerModel() {
        valoresMapaVista = new HashMap<>();
    }

    public XmlContainerModel addEstadoDeVista(String nombre, String valor) {
        valoresMapaVista.put(nombre, new TypeWrapper<>(valor));
        return this;
    }

    public XmlContainerModel addEstadoDeVista(String nombre, Number valor) {
        valoresMapaVista.put(nombre, new TypeWrapper<>(valor));
        return this;
    }

    public XmlContainerModel addEstadoDeVista(String nombre, Boolean valor) {
        valoresMapaVista.put(nombre, new TypeWrapper<>(valor));
        return this;
    }

    public <T> T get(String clave) {
        TypeWrapper<T> resultado = valoresMapaVista.get(clave);
        return resultado == null? null : resultado.getValor();
    }

    private class TypeWrapper<T> {

        private T valor;

        TypeWrapper(T valor) {
            this.valor = valor;
        }

        T getValor() {
            return valor;
        }
    }
}
