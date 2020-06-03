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
}
