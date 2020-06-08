package AirportManager;

import Aeroporto.Aeroporto;
import Janelas.InitialWindow;
import ListaAeroportosSemRepeticao.ListaAeroportosSemRepeticao;
import Voo.Voo;

public class AirportManager
{
    private ListaAeroportosSemRepeticao listaAeroportos;

    public AirportManager()
    {
        listaAeroportos = new ListaAeroportosSemRepeticao();
    }

    public void addAeroporto(Aeroporto aeroporto) throws Exception
    {
        listaAeroportos.insiraNoFim(aeroporto);
        System.out.println(listaAeroportos);
    }

    public void addVoo(String codigoOrigem, Voo voo) throws Exception
    {
        listaAeroportos.insiraVoo(codigoOrigem, voo);
        System.out.println(listaAeroportos);
    }

    public void removerVoo(int nmrVoo) throws Exception
    {
        listaAeroportos.removerVoo(nmrVoo);
        System.out.println(listaAeroportos);
    }
}
