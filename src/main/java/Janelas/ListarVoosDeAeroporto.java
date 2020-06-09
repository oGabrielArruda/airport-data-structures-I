package Janelas;

import AirportManager.AirportManager;
import ListaDuplaDesordenadaSemRepeticao.ListaDuplaDesordenadaSemRepeticao;
import Voo.Voo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarVoosDeAeroporto {
    private JButton btnListar;
    public JPanel panelListar;
    private JTextField txtCodigo;
    private JList list;
    AirportManager manager;

    public ListarVoosDeAeroporto(AirportManager manager) {
        this.manager = manager;
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String codigo = txtCodigo.getText().toUpperCase().trim();
                    ListaDuplaDesordenadaSemRepeticao<Voo> listaVoos = manager.getListaDeVoos(codigo);

                    int qtdVoos = listaVoos.qtd();
                    Voo[] arrVoos = new Voo[qtdVoos];

                    int i = 0;
                    while(qtdVoos > 0)
                    {
                        arrVoos[i] = listaVoos.getDoInicio();
                        listaVoos.removaDoInicio();
                        i++;
                        qtdVoos--;
                    }
                    list.setListData(arrVoos);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });
    }
}
