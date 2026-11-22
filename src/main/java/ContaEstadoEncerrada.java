import java.util.ArrayList;
import java.util.List;

public class ContaEstadoEncerrada implements ContaEstado{
    private static ContaEstadoEncerrada instance = new ContaEstadoEncerrada();

    private ContaEstadoEncerrada() {}

    public static ContaEstadoEncerrada getInstance() {
        return instance;
    }

    @Override
    public String getNomeEstado() {
        return "Encerrada";
    }
}
