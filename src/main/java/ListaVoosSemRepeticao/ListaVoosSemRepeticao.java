package ListaVoosSemRepeticao;

import ListaDuplaDesordenada.ListaDuplaDesordenada;
import Voo.Voo;

public class ListaVoosSemRepeticao extends ListaDuplaDesordenada<Voo>
{
    public ListaVoosSemRepeticao() {
        super();
    }

    @Override
    public void insiraNoFim(Voo voo) throws Exception {
        if(this.existe(voo))
            throw new Exception("Voo já existe!");
        super.insiraNoFim(voo);
    }

    @Override
    public void insiraNoInicio(Voo voo) throws Exception {
        if(this.existe(voo))
            throw new Exception("Voo já existe!");
        super.insiraNoInicio(voo);
    }

    public boolean existe(Voo voo)
    {
        No atual = super.primeiro;
        while(atual != null)
        {
            if(atual.getInfo().getCodigoDestinoDestino().equals(voo.getCodigoDestinoDestino()))
                return true;
        }
        return false;
    }

    public ListaVoosSemRepeticao(ListaVoosSemRepeticao modelo) throws Exception {
        super(modelo);
    }

    public Object clone() {
        ListaVoosSemRepeticao ret = null;
        try
        {
            ret = new ListaVoosSemRepeticao(this);
        }
        catch (Exception ex)
        { }
        return ret;
    }
}
