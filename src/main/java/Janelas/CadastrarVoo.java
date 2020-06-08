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
                    String codigoDest = txtCodigoDestino.getText().toUpperCase();
                    String codOrigem = txtCodigoOrigem.getText().toUpperCase();

                    Voo voo = new Voo(codigoDest, Integer.parseInt(txtNmr.getText()));
                    cadastrarVoo(codOrigem, voo);

                    limparCampos();
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar voo " + ex.getMessage());
                }
            }
        });
    }

    private void limparCampos()
    {
        txtCodigoDestino.setText("");
        txtCodigoOrigem.setText("");
        txtNmr.setText("");
    }

    private void cadastrarVoo(String cidadeOrigem, Voo voo) throws Exception
    {
        manager.addVoo(cidadeOrigem, voo);
    }
}
