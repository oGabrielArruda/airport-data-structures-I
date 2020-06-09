package Aeroporto;

import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
import Voo.Voo;

public class Aeroporto implements Cloneable
{
    private String codigo;
    private String cidade;
    private ListaDuplaDesordenadaSemRepeticao<Voo> possiveisVoos;

    public Aeroporto(String codigo, String cidade) throws Exception
    {
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
        if(codigo == null || codigo.length() != 3)
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

    public ListaDuplaDesordenadaSemRepeticao<Voo> getPossiveisVoos()
    {
        ListaDuplaDesordenadaSemRepeticao<Voo> list = null;
        try
        {
             list = new ListaDuplaDesordenadaSemRepeticao<Voo>(this.possiveisVoos);
        }
        catch (Exception ex){}
        return list;

    }

    public void addVoo(Voo voo) throws Exception
    {
        if(voo == null)
            throw new Exception("Voo nulo");

        possiveisVoos.insiraNoFim(voo);
    }

    public void removerVoo(int nmrVoo) throws Exception
    {
        if(nmrVoo <= 0)
            throw new Exception("Voo inválido");

        Voo vooToRemove = new Voo("foo", nmrVoo);

        if(!this.possiveisVoos.existe(vooToRemove))
            throw new Exception("Voo inexistente");

        this.possiveisVoos.remova(vooToRemove);
    }
    public String toString()
    {
        String ret = "Código aeroporto: " + this.codigo;
        ret += "\n Cidade: " + cidade;
        ret += "\n Voos: " + this.possiveisVoos + "\n";

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
        if(this.codigo.equals(outroAeroporto.codigo))
            return false;
        if(!this.cidade.equals(outroAeroporto.cidade))
            return false;
        if(!this.possiveisVoos.equals(outroAeroporto.possiveisVoos))
            return false;

        return true;
    }

    public int hashCode()
    {
        int ret = 345;
        ret = ret*13 + this.codigo.hashCode();
        ret = ret*13 + this.cidade.hashCode();
        ret = ret*13 + possiveisVoos.hashCode();
        if(ret < 0)
            ret = -ret;
        return ret;
    }

    public Aeroporto(Aeroporto modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo nulo!");

        this.codigo = modelo.codigo;
        this.cidade = modelo.cidade;
        this.possiveisVoos = modelo.possiveisVoos;
    }

    public Object clone()
    {
        Aeroporto ret = null;
        try
        {
            ret = new Aeroporto(this);
        }
        catch (Exception ex)
        {}
        return ret;
    }
}
