package Janelas;

import Aeroporto.Aeroporto;
import AirportManager.AirportManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarAeroporto {
    AirportManager manager;
    private JTextField txtCodigo;
    private JTextField txtCidade;
    private JButton btnAdd;
    private JLabel label;
    public JPanel PainelAdd;


    public AdicionarAeroporto(AirportManager manager) {
        this.manager = manager;

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String codigo = txtCodigo.getText().toUpperCase();
                    Aeroporto aero = new Aeroporto(codigo, txtCidade.getText());
                    adicionarAeroporto(aero);
                    txtCodigo.setText("");
                    txtCidade.setText("");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar aeroporto " + ex.getMessage());
                }
            }
        });
    }

    private void adicionarAeroporto(Aeroporto aero) throws Exception
    {
        manager.addAeroporto(aero);
    }
}
