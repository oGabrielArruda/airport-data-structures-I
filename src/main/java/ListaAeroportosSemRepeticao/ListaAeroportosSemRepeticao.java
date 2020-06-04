package ListaAeroportosSemRepeticao;

import Aeroporto.Aeroporto;
import ListaDuplaDesordenada.ListaDuplaDesordenada;
import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;

public class ListaAeroportosSemRepeticao extends ListaDuplaDesordenada<Aeroporto>
{
    public ListaAeroportosSemRepeticao()
    {
        super();
    }

    public ListaAeroportosSemRepeticao(ListaAeroportosSemRepeticao modelo) throws Exception
    {
        super(modelo);
    }

    public Object clone()
    {
        ListaAeroportosSemRepeticao ret = null;
        try
        {
            ret = new ListaAeroportosSemRepeticao(this);
        }
        catch (Exception ex) {}

        return ret;
    }

    @Override
    public void insiraNoFim(Aeroporto aeroporto) throws Exception {
        if(this.existe(aeroporto))
            throw new Exception("Aeroporto já existe");

        super.insiraNoFim(aeroporto);
    }

    @Override
    public void insiraNoInicio(Aeroporto aeroporto) throws Exception {
        if(this.existe(aeroporto))
            throw new Exception("Aeroporto já existe");
        super.insiraNoInicio(aeroporto);
    }

    public boolean existe(Aeroporto aeroporto)
    {
        if(super.primeiro == null)
            return false;

        No atual = super.primeiro;

        while(atual != null)
        {
            if (atual.getInfo().getCodigo().equals(aeroporto.getCodigo()))
                return true;
            atual = atual.getProx();
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != this.getClass())
            return false;
        ListaAeroportosSemRepeticao listaAeroportos = (ListaAeroportosSemRepeticao) obj;

        No atualThis = super.primeiro;
        No atualLista= super.primeiro;

        while (atualThis!=null && atualLista!=null)
        {
            if (!atualThis.getInfo().getCodigo().equals(atualLista.getInfo().getCodigo()))
                return false;

            atualThis  = atualThis .getProx();
            atualLista = atualLista.getProx();
        }

        if (atualThis!=null)
            return false;

        if (atualLista!=null)
            return false;

        return true;
    }
}
