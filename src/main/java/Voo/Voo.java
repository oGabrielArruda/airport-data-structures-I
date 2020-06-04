package Voo;

public class Voo
{
    private String codigoDestino;
    private int nmrVoo;

    public Voo(String codigoDestino, int nmrVoo) throws Exception
    {
        if(nmrVoo == 0)
            throw new Exception("Informações para voo faltantes!");

        this.codigoDestino = codigoDestino;
        this.nmrVoo = nmrVoo;
    }

    public void setIndiceDestino(String codigoDestino) throws Exception
    {
        this.codigoDestino = codigoDestino;
    }

    public void setNmrVoo(int nmrVoo) throws Exception
    {
        if(nmrVoo == 0)
            throw new Exception("Número do voo incorreto!");
        this.nmrVoo = nmrVoo;
    }

    public String getCodigoDestinoDestino()
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

        if(this.nmrVoo != outroVoo.nmrVoo)
            return false;
        if(!this.codigoDestino.equals(outroVoo.codigoDestino))
            return false;
        return true;
    }

    // métodos obrigatorios
}
