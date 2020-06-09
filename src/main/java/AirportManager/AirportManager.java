package AirportManager;

import Aeroporto.Aeroporto;
import Janelas.InitialWindow;
import ListaAeroportosSemRepeticao.ListaAeroportosSemRepeticao;
import ListaDuplaDesordenada.ListaDuplaDesordenada;
import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
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

    public ListaDuplaDesordenadaSemRepeticao<Voo> getListaDeVoos(String codigoAeroporto) throws Exception
    {
        return listaAeroportos.getListaDeVoos(codigoAeroporto);
    }

    public ListaAeroportosSemRepeticao getListaDeAeroportos() throws Exception
    {
        return new ListaAeroportosSemRepeticao(listaAeroportos);
    }
}
