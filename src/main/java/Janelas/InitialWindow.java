package Janelas;

import Aeroporto.Aeroporto;
import AirportManager.AirportManager;
import ListaDuplaDesordenada.ListaDuplaDesordenada;
import Voo.Voo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InitialWindow extends AirportManager {
    AirportManager manager;

    private JFrame frame;
    private JButton btnAddAeroporto;
    private JPanel panelAddAirport;
    private JButton cadastrarVooButton;
    private JButton removerVooButton;
    private JButton listaVooDeDeterminadoButton;
    private JButton listarTodosOsVoosButton;

    public InitialWindow(AirportManager manager) {
       this.manager = manager;
       initialize();
    }


    private void initialize() {
        frame = new JFrame("App");
        frame.setContentPane(panelAddAirport);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        btnAddAeroporto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addAirport = new JFrame("AddAirport");
                addAirport.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                addAirport.setContentPane(new AdicionarAeroporto(manager).PainelAdd);
                addAirport.pack();
                addAirport.setVisible(true);
            }
        });

        cadastrarVooButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addAirport = new JFrame("CadastrarVoo");
                addAirport.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                addAirport.setContentPane(new CadastrarVoo(manager).PanelAdd);
                addAirport.pack();
                addAirport.setVisible(true);
            }
        });
    }

}
