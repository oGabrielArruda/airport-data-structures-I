package ListaAeroportosSemRepeticao;

import Aeroporto.Aeroporto;
import ListaDuplaDesordenada.ListaDuplaDesordenada;
import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
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

    /**
     * Verifica se um aeroporto já existe.
     * Percorre-se cada nó da lista e verifica-se o código do aeroporto atual.
     * Isso é feito para não permitir códigos iguais de aeroporto,
     * e permitir dois ou mais aeroportos em uma mesma cidade.
     * @param aeroporto aeropoto que deseja-se saber se existe
     * @return se o aeroporto existe.
     */
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

    /**
     * Insere o voo em determinado aeroporto
     * @param codigoOrigem codigo do aeroporto de origem do voo.
     * @param voo objeto da classe Voo contendo o codigo do destino e número do voo;
     * @throws Exception caso o aeroporto ou o voo sejam inválidos, caso o número do voo já exista
     * ou se houver algum problema com o funcionamento da lista.
     */
    public void insiraVoo(String codigoOrigem, Voo voo) throws Exception
    {
        if(!this.existe(new Aeroporto(codigoOrigem, "foo")))
            throw new Exception("Aeroporto de origem inexistente");
        if(!this.existe(new Aeroporto(voo.getCodigoDestino(), "bar")))
            throw new Exception("Aeroporto de destino inexistente");
        if(this.existeNmrVoo(voo.getNmrVoo()))
            throw new Exception("Voo já existente");
        if(codigoOrigem.equals(voo.getCodigoDestino()))
            throw new Exception("Voo inválido");

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


    /**
     * Pega a lista de voos de um aeroporto de determinado código;
     * @param codigoAeroporto código do aeroporto que se quer pegar os voos
     * @return a lista de voos.
     * @throws Exception caso ocorra algum erro com a lista
     */
    public ListaDuplaDesordenadaSemRepeticao<Voo> getListaDeVoos(String codigoAeroporto) throws Exception
    {
        if(codigoAeroporto == null || codigoAeroporto.length() != 3)
            throw new Exception("Código de aeroporto inválido");
        No aeropoto = this.buscaAeroporto(codigoAeroporto);
        return aeropoto.getInfo().getPossiveisVoos();
    }

    /**
     * Busca o nó do aeroporto de determinado código.
     * Percorre-se a lista de aeroportos e verifica-se o código
     * de cada um desses.
     * @param codigo código do aeroporto buscado
     * @return o Nó do aeropoto
     * @throws Exception caso a lista esteja vazia
     */
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

    /**
     * Verifica se algum aeroporto tem determinado voo.
     * Percorre-se todos os aeroportos com o 'atual', e depois percorre-se a lista
     * de voos de tal aeroporto, pegando sempre seu primeiro item e eliminando-o
     * em seguida.
     * @param nmr numero do voo procurado
     * @return se existe um voo com esse número
     * @throws Exception caso a lista esteja vazia
     */
    protected boolean existeNmrVoo(int nmr) throws Exception
    {
        No atual = super.primeiro;
        while(atual != null)
        {
            ListaDuplaDesordenadaSemRepeticao<Voo> listaVoos = atual.getInfo().getPossiveisVoos();
            for(int qtd = listaVoos.qtd(); qtd > 0; qtd--)
            {
                if(listaVoos.getDoInicio().getNmrVoo() == nmr)
                    return true;
                listaVoos.removaDoInicio();
            }
            atual = atual.getProx();
        }
        return false;
    }

}
