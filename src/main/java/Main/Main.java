package Main;

import Janelas.InitialWindow;

import javax.swing.*;

public class Main
{
    public static void main (String[] args)
    {
        try
        {
            InitialWindow init = new InitialWindow();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
