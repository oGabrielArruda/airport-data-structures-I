package Janelas;

import Aeroporto.Aeroporto;
import AirportManager.AirportManager;
import ListaAeroportosSemRepeticao.ListaAeroportosSemRepeticao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ListarTodosVoos {
    public JPanel panelListar;
    private JButton btnListar;
    private JList list;
    private AirportManager manager;

    public ListarTodosVoos(AirportManager manager) {
        this.manager = manager;
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    ListaAeroportosSemRepeticao listaAeroportos = manager.getListaDeAeroportos();
                    int qtdAeroportos = listaAeroportos.qtd();


                    Aeroporto[] aeroportos = new Aeroporto[qtdAeroportos];
                    for(int i = 0; qtdAeroportos > 0; qtdAeroportos--)
                    {
                        aeroportos[i] = listaAeroportos.getDoInicio();
                        listaAeroportos.removaDoInicio();
                        i++;
                    }
                    list.setListData(aeroportos);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });
    }
}
