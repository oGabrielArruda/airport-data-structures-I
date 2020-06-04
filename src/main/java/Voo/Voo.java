package Voo;

public class Voo
{
    private int indiceDestino;
    private int nmrVoo;

    public Voo(int indiceDestino, int nmrVoo) throws Exception
    {
        if(nmrVoo == 0)
            throw new Exception("Informações para voo faltantes!");

        this.indiceDestino = indiceDestino;
        this.nmrVoo = nmrVoo;
    }

    public void setIndiceDestino(int indiceDestino) throws Exception
    {
        this.indiceDestino = indiceDestino;
    }

    public void setNmrVoo(int nmrVoo) throws Exception
    {
        if(nmrVoo == 0)
            throw new Exception("Número do voo incorreto!");
        this.nmrVoo = nmrVoo;
    }

    public void getIndiceDestino()
    {
        return indiceDestino;
    }

    public void getNmrVoo()
    {
        return NmrVoo;
    }

    // métodos obrigatorios
}
