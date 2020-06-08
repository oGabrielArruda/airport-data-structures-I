package Janelas;

import AirportManager.AirportManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverVoo {
    private JButton btnRemover;
    public JPanel panelRemove;
    private JTextField txtNumeroVoo;
    private AirportManager manager;

    public RemoverVoo(AirportManager manager) {
        this.manager = manager;

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int nmrVoo = Integer.parseInt(txtNumeroVoo.getText().trim());
                    manager.removerVoo(nmrVoo);
                    txtNumeroVoo.setText("");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }

            }
        });
    }
}
