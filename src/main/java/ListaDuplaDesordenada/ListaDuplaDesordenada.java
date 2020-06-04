package ListaDuplaDesordenada;

import java.lang.reflect.Method;

public class ListaDuplaDesordenada<X>
{
    protected class No
    {
        private No ante;
        private X info;
        private No prox;

        public No(No anterior, X info, No prox)
        {
            this.ante = anterior;
            this.info = info;
            this.prox = prox;
        }
        public No(X info)
        {
            this.ante = null;
            this.info = info;
            this.prox = null;
        }

        public X getInfo()
        {
            return this.info;
        }

        public No getProx()
        {
            return this.prox;
        }

        public No getAnte()
        {
            return this.ante;
        }

        public void setAnte(No ante)
        {
            this.ante = ante;
        }
        public void setProx(No prox)
        {
            this.prox = prox;
        }
        public void setInfo(X info)
        {
            this.info = info;
        }
    }

    protected No primeiro, ultimo;

    public ListaDuplaDesordenada() {}

    protected X meuCloneDeX(X x)
    {
        X ret = null;
        try
        {
            Class<?> classe = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method method = classe.getMethod("clone", tipoDosParms);
            Object[] parms = null;
            ret = (X)method.invoke(x, parms);
        }
        catch (Exception ex)
        { }
        return ret;
    }

    protected X tryGetClone(X x)
    {
        X ret = null;
        if(x instanceof Cloneable)
            ret = meuCloneDeX(x);
        else
            ret = x;
        return ret;
    }

    public void insiraNoInicio(X x) throws Exception
    {
        if(x == null)
            throw new Exception("Informação nula");

        X info = tryGetClone(x);

        if(this.primeiro == null)
        {
            this.primeiro = new No(info);
            this.ultimo = this.primeiro;
            return;
        }

        this.primeiro.setAnte(new No(null, info, this.primeiro));
        this.primeiro = this.primeiro.getAnte();
    }

    public void insiraNoFim(X x) throws Exception
    {
        if(x == null)
            throw new Exception("Informação nula");

        X info = tryGetClone(x);

        if(this.primeiro == null)
        {
            this.primeiro = new No(info);
            this.ultimo = this.primeiro;
            return;
        }

        this.ultimo.setProx(new No(this.ultimo, info, null));
        this.ultimo = this.ultimo.getProx();
    }

    public void removaDoFim() throws Exception
    {
        if(this.primeiro == null)
            throw new Exception("Lista vazia");
        if(this.primeiro == this.ultimo)
        {
            this.primeiro = null;
            this.ultimo = null;
        }
        this.ultimo = this.ultimo.getAnte();
        this.ultimo.setProx(null);
    }

    public void removaDoInicio() throws Exception
    {
        if(this.primeiro == null)
            throw new Exception("Lista vazia");
        if(this.primeiro == this.ultimo)
        {
            this.primeiro = null;
            this.ultimo = null;
        }
        this.primeiro = this.primeiro.getProx();
        this.primeiro.setAnte(null);
    }

    public void remova(X x) throws Exception
    {
        if(x == null)
            throw new Exception("Elemento para a remoção nulo!");

        if(this.primeiro == null)
            throw new Exception("Lista vazia!");

        if(this.primeiro.getInfo().equals(x))
        {
            if(this.primeiro == this.ultimo)
            {
                this.primeiro = null;
                this.ultimo = null;
                return;
            }
            this.primeiro = this.primeiro.getProx();
            this.primeiro.setAnte(null);
        }

        No atual = this.primeiro;
        while(atual.getProx() != null)
        {
            if(atual.getProx().getInfo().equals(x))
            {
                atual.setProx(atual.getProx().getProx());
                atual.getProx().setAnte(atual);
                break;
            }
            atual = atual.getProx();
        }
    }

    public boolean existe(X x)
    {
        if(this.primeiro == null)
            return false;

        No atual = this.primeiro;

        while(atual != null)
        {
            if (atual.getInfo().equals(x))
                return true;
            atual = atual.getProx();
        }
        return false;
    }

    public int getQtd ()
    {
        No  atual=this.primeiro;
        int ret  =0;

        while (atual!=null)
        {
            ret++;
            atual = atual.getProx();
        }

        return ret;
    }

    public X getDoInicio () throws Exception
    {
        if (this.primeiro==null)
            throw new Exception ("Nada a obter");

        X ret = tryGetClone(this.primeiro.getInfo());

        return ret;
    }

    public X getDoFim () throws Exception
    {
        if (this.primeiro==null)
            throw new Exception ("Nada a obter");

        X ret = tryGetClone(this.ultimo.getInfo());

        return ret;
    }

    public boolean isvazia ()
    {
        return this.primeiro==null;
    }

    public int qtd()
    {
        No atual = this.primeiro;
        int qtd = 0;
        while(atual != null)
        {
            qtd++;
            atual = atual.getProx();
        }
        return qtd;
    }

    public String toString()
    {
        String ret = "[ ";
        No atual = this.primeiro;
        while(atual != null)
        {
            ret += atual.getInfo() + " ";
            atual = atual.getProx();
        }

        ret += "]";
        return ret;
    }

    public int hashCode ()
    {
        final int PRIMO = 13;

        int ret=666;

        for (No atual=this.primeiro;
             atual!=null;
             atual=atual.getProx())
            ret = 17*ret + atual.getInfo().hashCode();

        if (ret<0) ret = -ret;

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass()!=obj.getClass())
            return false;

        ListaDuplaDesordenada<X> lista =
                (ListaDuplaDesordenada<X>)obj;

        No atualThis =this .primeiro;
        No atualLista=lista.primeiro;

        while (atualThis!=null && atualLista!=null)
        {
            if (!atualThis.getInfo().equals(atualLista.getInfo()))
                return false;

            atualThis  = atualThis .getProx();
            atualLista = atualLista.getProx();
        }

        if (atualThis!=null)
            return false;

        if (atualLista!=null)
            return false;

        return true;
    }

    public ListaDuplaDesordenada (ListaDuplaDesordenada<X> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.primeiro==null)
            return;

        this.primeiro = new No (modelo.primeiro.getInfo());

        No atualDoThis   = this  .primeiro;
        No atualDoModelo = modelo.primeiro.getProx();

        while (atualDoModelo!=null)
        {
            atualDoThis.setProx (new No (atualDoThis,atualDoModelo.getInfo(),null));
            atualDoThis   = atualDoThis  .getProx ();
            atualDoModelo = atualDoModelo.getProx ();
        }

        this.ultimo = atualDoThis;
    }

    public Object clone ()
    {
        ListaDuplaDesordenada<X> ret=null;

        try
        {
            ret = new ListaDuplaDesordenada (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }

}
