package ListaDuplaDesordenadaSemRepeticao;

import ListaDuplaDesordenada.ListaDuplaDesordenada;

public class ListaDuplaDesordenadaSemRepeticao<X> extends ListaDuplaDesordenada<X>
{
    public ListaDuplaDesordenadaSemRepeticao()
    {
        super();
    }

    // clone e construtor de copia

    @Override
    public void insiraNoFim(X x) throws Exception
    {
        if(super.existe(x))
            throw new Exception("Informação já existente");
        super.insiraNoFim(x);
    }

    @Override
    public void insiraNoInicio(X x) throws Exception {
        if(super.existe(x))
            throw new Exception("Informação já existente");
        super.insiraNoInicio(x);
    }

    public ListaDuplaDesordenadaSemRepeticao (ListaDuplaDesordenadaSemRepeticao<X> modelo) throws Exception
    {
        super (modelo);
    }

    public Object clone ()
    {
        ListaDuplaDesordenadaSemRepeticao<X> ret=null;

        try
        {
            ret = new ListaDuplaDesordenadaSemRepeticao (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }
}
