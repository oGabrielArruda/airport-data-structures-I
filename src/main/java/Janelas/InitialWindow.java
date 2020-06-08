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
        frame.setSize(600, 400);
        frame.setVisible(true);

        btnAddAeroporto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addAirport = new JFrame("AddAirport");
                addAirport.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                addAirport.setContentPane(new AdicionarAeroporto(manager).PainelAdd);
                addAirport.pack();
                addAirport.setSize(600, 400);
                addAirport.setVisible(true);
            }
        });

        cadastrarVooButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addVoo = new JFrame("CadastrarVoo");
                addVoo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                addVoo.setContentPane(new CadastrarVoo(manager).PanelAdd);
                addVoo.pack();
                addVoo.setSize(600, 400);
                addVoo.setVisible(true);
            }
        });

        removerVooButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame removerVoo = new JFrame("RemoverVoo");
                removerVoo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                removerVoo.setContentPane(new RemoverVoo(manager).panelRemove);
                removerVoo.pack();
                removerVoo.setSize(600, 400);
                removerVoo.setVisible(true);
            }
        });

        listaVooDeDeterminadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame listarVoos = new JFrame("ListarVoosDeAeroporto");
                listarVoos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                listarVoos.setContentPane(new ListarVoosDeAeroporto(manager).panelListar);
                listarVoos.pack();
                listarVoos.setSize(600, 400);
                listarVoos.setVisible(true);
            }
        });
    }

}
