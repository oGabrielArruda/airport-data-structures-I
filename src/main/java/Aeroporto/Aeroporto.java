package Aeroporto;

import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
import ListaVoosSemRepeticao.ListaVoosSemRepeticao;
import Voo.Voo;

public class Aeroporto
{
    private String codigo;
    private String cidade;
    private ListaVoosSemRepeticao possiveisVoos;

    public Aeroporto(String codigo, String cidade) throws Exception
    {
        if(codigo == null || cidade == null)
            throw new Exception("Informações de aeroporto faltantes!");

        this.setCodigo(codigo);
        this.setCidade(cidade);
        possiveisVoos = new ListaVoosSemRepeticao();
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
        this.codigo = codigo;
    }

    public String getCodigo()
    {
        return new String(this.codigo);
    }

    public String getCidade()
    {
        return new String(this.cidade);
    }

    public void addVoo(Voo voo) throws Exception
    {
        if(voo == null)
            throw new Exception("Voo nulo");

        possiveisVoos.insiraNoFim(voo);
    }

    public String toString()
    {
        String ret = "Código aeroporto: " + this.codigo;
        ret += "\n Cidade: " + cidade;
        ret += "\n Voos: " + this.possiveisVoos;

        return ret;
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        if(this.getClass() != obj.getClass())
            return false;

        Aeroporto outroAeroporto = (Aeroporto)obj;
        if(!this.codigo.equals(outroAeroporto.codigo))
            return false;
        if(!this.cidade.equals(outroAeroporto.cidade))
            return false;
        if(!this.possiveisVoos.equals(outroAeroporto.possiveisVoos))
            return false;

        return true;
    }
    /*public void removerVoo(int nmrVoo) throws Exception
    {
        if(nmrVoo == 0)
            throw new Exception("Número de voo inválido!");
        possiveisVoos.remova();
    }*/
    // métodos obrigatórios
}
