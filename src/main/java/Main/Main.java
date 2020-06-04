package Main;

import AirportManager.AirportManager;
import Janelas.InitialWindow;

import javax.swing.*;

public class Main
{
    public static void main (String[] args)
    {
        try
        {
            AirportManager manager = new AirportManager();
            InitialWindow init = new InitialWindow(manager);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
