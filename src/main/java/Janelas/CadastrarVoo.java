package Janelas;

import AirportManager.AirportManager;
import Voo.Voo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarVoo {
    AirportManager manager;
    private JTextField txtCodigoOrigem;
    private JTextField txtCodigoDestino;
    private JTextField txtNmr;
    private JButton btnAdd;
    public JPanel PanelAdd;


    public CadastrarVoo(AirportManager manager) {
        this.manager = manager;

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Voo voo = new Voo(txtCodigoDestino.getText(), Integer.parseInt(txtNmr.getText()));
                    cadastrarVoo(txtCodigoOrigem.getText(), voo);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar voo " + ex.getMessage());
                }
            }
        });
    }

    private void cadastrarVoo(String cidadeOrigem, Voo voo) throws Exception
    {
        manager.addVoo(cidadeOrigem, voo);
    }
}
