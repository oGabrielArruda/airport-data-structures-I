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
}
