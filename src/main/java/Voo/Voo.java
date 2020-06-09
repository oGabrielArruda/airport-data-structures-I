package Voo;

import java.util.Objects;

public class Voo
{
    private String codigoDestino;
    private int nmrVoo;

    public Voo(String codigoDestino, int nmrVoo) throws Exception
    {
        this.setCodigoDestino(codigoDestino);
        this.setNmrVoo(nmrVoo);
    }

    public void setCodigoDestino(String codigoDestino) throws Exception
    {
        if(codigoDestino == null || codigoDestino.length() != 3)
            throw new Exception("Código do destino inválido");
        this.codigoDestino = codigoDestino;
    }

    public void setNmrVoo(int nmrVoo) throws Exception
    {
        if(nmrVoo <= 0)
            throw new Exception("Número do voo incorreto!");
        this.nmrVoo = nmrVoo;
    }

    public String getCodigoDestino()
    {
        return new String(this.codigoDestino);
    }

    public int getNmrVoo()
    {
        return this.nmrVoo;
    }

    public String toString()
    {
        String ret = "";
        ret += "Código Destino: " + this.codigoDestino;
        ret += "\n Número do Voo: " + this.nmrVoo;

        return ret;
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(obj.getClass() != this.getClass())
            return false;
        if(this == obj)
            return true;

        Voo outroVoo = (Voo) obj;

        if(this.nmrVoo == outroVoo.nmrVoo)
            return true;
        if(!this.codigoDestino.equals(outroVoo.codigoDestino))
            return false;
        return true;
    }

    public int hashCode()
    {
        int ret = 345;
        ret = ret*13 + codigoDestino.hashCode();
        ret = ret*13 + new Integer(nmrVoo).hashCode();

        if(ret < 0)
            ret = -ret;
        return ret;
    }

    public Voo(Voo modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo nulo");
        this.codigoDestino = modelo.codigoDestino;
        this.nmrVoo = modelo.nmrVoo;
    }

    public Object clone(Voo modelo)
    {
        Voo ret = null;
        try
        {
          ret = new Voo(this);
        }
        catch (Exception ex)
        {}
        return ret;
    }
}
