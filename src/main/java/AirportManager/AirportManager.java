package AirportManager;

import Aeroporto.Aeroporto;
import Janelas.InitialWindow;
import ListaAeroportosSemRepeticao.ListaAeroportosSemRepeticao;

public class AirportManager
{
    private ListaAeroportosSemRepeticao listaAeroportos;

    public AirportManager()
    {
        listaAeroportos = new ListaAeroportosSemRepeticao();
    }

    protected void addAeroporto(Aeroporto aeroporto) throws Exception
    {
        if(aeroporto == null)
            throw new Exception("Aeroporto inválido");

        listaAeroportos.insiraNoFim(aeroporto);
    }
}
