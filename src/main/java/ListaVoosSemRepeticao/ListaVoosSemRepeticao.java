package ListaVoosSemRepeticao;

import ListaDuplaDesordenada.ListaDuplaDesordenada;
import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
import Voo.Voo;

public class ListaVoosSemRepeticao extends ListaDuplaDesordenadaSemRepeticao<Voo>
{
    public ListaVoosSemRepeticao() {
        super();
    }

    @Override
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
