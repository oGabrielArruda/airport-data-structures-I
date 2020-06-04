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
        if(aeroporto == null)
            throw new Exception("Aeroporto inválido");

        listaAeroportos.insiraNoFim(aeroporto);
        System.out.println(listaAeroportos);
    }

    public void addVoo(String codigoOrigem, Voo voo) throws Exception
    {
        if(!listaAeroportos.existe(voo.getCodigoDestinoDestino()))
            throw new Exception("Destino inexistente");
        listaAeroportos.insiraVoo(codigoOrigem, voo);
        System.out.println(listaAeroportos);
    }
}
