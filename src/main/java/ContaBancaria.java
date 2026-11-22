import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private ContaEstado estado;
    private List<ContaEstado> mementos = new ArrayList<>();

    public ContaEstado getEstado() {
        return this.estado;
    }

    public void setEstado(ContaEstado estado) {
        this.estado = estado;
        this.mementos.add(this.estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > this.mementos.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.estado = this.mementos.get(indice);
    }

    public List<ContaEstado> getEstados() {
        return this.mementos;
    }
}
