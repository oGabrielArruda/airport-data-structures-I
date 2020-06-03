package Janelas;

import com.sun.glass.ui.Cursor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialWindow {
    private JFrame frame;
    private JButton btnAddAeroporto;
    private JPanel panelMain;
    private JButton cadastrarVooButton;
    private JButton removerVooButton;
    private JButton listaVooDeDeterminadoButton;
    private JButton listarTodosOsVoosButton;

    public InitialWindow() {
       initialize();
    }


    private void initialize() {
        frame = new JFrame("App");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        btnAddAeroporto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello world!");
            }
        });
    }

}
