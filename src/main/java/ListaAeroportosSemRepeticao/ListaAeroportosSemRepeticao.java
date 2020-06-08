package ListaAeroportosSemRepeticao;

import Aeroporto.Aeroporto;
import ListaDuplaDesordenada.ListaDuplaDesordenada;
import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
import ListaVoosSemRepeticao.ListaVoosSemRepeticao;
import Voo.Voo;

import java.util.List;

public class ListaAeroportosSemRepeticao extends ListaDuplaDesordenadaSemRepeticao<Aeroporto>
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
    public boolean existe(Aeroporto aeroporto) {
        No atual = super.primeiro;
        while(atual != null)
        {
            if(atual.getInfo().getCodigo().equals(aeroporto.getCodigo()))
                return true;
            atual = atual.getProx();
        }
        return false;
    }

    public void insiraVoo(String codigoOrigem, Voo voo) throws Exception
    {
        if(!this.existe(new Aeroporto(codigoOrigem, "foo")))
            throw new Exception("Aeroporto de origem inexistente");
        if(!this.existe(new Aeroporto(voo.getCodigoDestinoDestino(), "bar")))
            throw new Exception("Aeroporto de destino inexistente");
        if(this.existeVoo(voo))
            throw new Exception("Voo já existente");

        No aeroportoOrigem = this.buscaAeroporto(codigoOrigem);
        aeroportoOrigem.getInfo().addVoo(voo);
    }

    /**
     * Remove o voo determinado pelo número
     * Primeiro procura-se o aeroporto que tem tal voo
     * Caso não seja achado, lança-se exceção
     * Se achado, chama-se o método remover voo da classe aeroporto
     * @param nmrVoo nmr do voo
     * @throws Exception se o voo não existir em nenhum aeroporto
     */
    public void removerVoo(int nmrVoo) throws Exception
    {
        No atual = super.primeiro;
        while (atual != null)
        {
            ListaDuplaDesordenadaSemRepeticao<Voo> listaVoo = atual.getInfo().getPossiveisVoos();
            if(listaVoo.existe(new Voo("foo", nmrVoo)))
                break;
            atual = atual.getProx();
        }
        if(atual == null)
            throw new Exception("Voo inexistente");

        atual.getInfo().removerVoo(nmrVoo);
    }

    protected No buscaAeroporto(String codigo) throws Exception
    {
        No atual = super.primeiro;
        while(atual != null)
        {
            if(atual.getInfo().getCodigo().equals(codigo))
                break;
            atual = atual.getProx();
        }
        if(atual == null)
            throw new Exception("Aeroporto de origem inexistente");
        return atual;
    }

    protected boolean existeVoo(Voo voo)
    {
        No atual = super.primeiro;
        while(atual != null)
        {
            if(atual.getInfo().getPossiveisVoos().existe(voo))
                return true;
            atual = atual.getProx();
        }
        return false;
    }

}
