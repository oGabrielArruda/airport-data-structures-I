package Janelas;

import Aeroporto.Aeroporto;
import AirportManager.AirportManager;
import ListaAeroportosSemRepeticao.ListaAeroportosSemRepeticao;
import ListaDuplaDesordenada.ListaDuplaDesordenada;
import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
import Voo.Voo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ListarTodosVoos {
    public JPanel panelListar;
    private JButton btnListar;
    private JTextArea txtArea;
    private JList list;
    private AirportManager manager;

    public ListarTodosVoos(AirportManager manager) {
        this.manager = manager;
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    txtArea.setFont(new Font("Consolas", Font.BOLD, 16));
                    ListaAeroportosSemRepeticao listaAeroportos = manager.getListaDeAeroportos();
                    listarVoos(listaAeroportos);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });
    }

    protected void listarVoos(ListaAeroportosSemRepeticao listaAeroportos) throws Exception
    {
        for(int i = listaAeroportos.qtd(); i > 0; i--)
        {
            Aeroporto aeroportoOrigem = listaAeroportos.getDoInicio();
            listarAeroportoOrigem(aeroportoOrigem);
            listarVoosDoAeroporto(aeroportoOrigem.getPossiveisVoos());
            listaAeroportos.removaDoInicio();
        }
    }

    protected void listarAeroportoOrigem(Aeroporto aeroportoOrigem)
    {
        String codigoOrigem = aeroportoOrigem.getCodigo();
        txtArea.append("  Aeropoto de Origem: " + codigoOrigem + "\n");
    }

    protected void listarVoosDoAeroporto(ListaDuplaDesordenada<Voo> listaVoos) throws Exception
    {
        for(int j = listaVoos.qtd(); j > 0; j--)
        {
            Voo voo = listaVoos.getDoInicio();
            txtArea.append("       Destino: " + voo.getCodigoDestino());
            txtArea.append("    Número: " + voo.getNmrVoo() + "\n");
            listaVoos.removaDoInicio();
        }
        txtArea.append("\n");
    }
}
