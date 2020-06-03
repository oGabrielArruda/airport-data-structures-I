package Aeroporto;

import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
import Voo.Voo;

public class Aeroporto
{
    private String codigo;
    private String cidade;
    private ListaDuplaDesordenadaSemRepeticao<Voo> possiveisVoos;

    public Aeroporto(String codigo, String cidade) throws Exception
    {
        if(codigo == null || cidade == null)
            throw new Exception("Informações de aeroporto faltantes!");

        this.setCodigo(codigo);
        this.setCidade(cidade);
        possiveisVoos = new ListaDuplaDesordenadaSemRepeticao<Voo>();
    }

    public void setCidade(String cidade) throws Exception
    {
        if(cidade == null)
            throw new Exception("Cidade de aeroporto inválida");
        this.cidade = cidade;
    }

    public void setCodigo(String codigo) throws Exception
    {
        if(codigo == null)
            throw new Exception("Código de aeroporto inválido");
    }

    public void addVoo(Voo voo) throws Exception
    {
        if(voo == null)
            throw new Exception("Voo nulo");

        possiveisVoos.insiraNoFim(voo);
    }

    /*public void removerVoo(int nmrVoo) throws Exception
    {
        if(nmrVoo == 0)
            throw new Exception("Número de voo inválido!");
        possiveisVoos.remova();
    }*/
    // métodos obrigatórios
}
