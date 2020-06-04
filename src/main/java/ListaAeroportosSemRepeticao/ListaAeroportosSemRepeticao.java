package ListaAeroportosSemRepeticao;

import Aeroporto.Aeroporto;
import ListaDuplaDesordenada.ListaDuplaDesordenada;
import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
import Voo.Voo;

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
        if(this.existe(aeroporto.getCodigo()))
            throw new Exception("Aeroporto já existe");

        super.insiraNoFim(aeroporto);
    }

    @Override
    public void insiraNoInicio(Aeroporto aeroporto) throws Exception {
        if(this.existe(aeroporto.getCodigo()))
            throw new Exception("Aeroporto já existe");
        super.insiraNoInicio(aeroporto);
    }

    public void insiraVoo(String codigoOrigem, Voo voo) throws Exception
    {
        No atual = super.primeiro;
        while(atual != null)
        {
            if(atual.getInfo().getCodigo().equals(codigoOrigem))
                break;
            atual = atual.getProx();
        }
        if(atual == null)
            throw new Exception("Aeroporto de origem inexistente");

        atual.getInfo().addVoo(voo);
    }

    public boolean existe(String codigo)
    {
        if(super.primeiro == null)
            return false;

        No atual = super.primeiro;

        while(atual != null)
        {
            if (atual.getInfo().getCodigo().equals(codigo))
                return true;
            atual = atual.getProx();
        }
        return false;
    }

}
