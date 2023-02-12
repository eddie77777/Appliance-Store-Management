package Panels;

import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrigorificPanel extends JPanel {

    private JList listaFrogrifice;
    private JList ListaProduse;
    private JLabel lblidProdus;
    private JTextField tfldid_produs;
    private JLabel lblProprietati;
    private JTextArea textProprietati;
    private JButton btnBak;
    private JButton btnAdaugare;

    public FrigorificPanel()
    {
        //construct preComponents
        String[] listaFrogrificeItems = {"Item 1", "Item 2", "Item 3"};
        String[] ListaProduseItems = {"Item 1", "Item 2", "Item 3"};

        //construct components
        listaFrogrifice = new JList (listaFrogrificeItems);
        ListaProduse = new JList (ListaProduseItems);
        lblidProdus = new JLabel ("id_Produs:");
        tfldid_produs = new JTextField (1);
        lblProprietati = new JLabel ("Proprietati:");
        textProprietati = new JTextArea (5, 5);
        btnBak = new JButton ("<<");
        btnAdaugare = new JButton ("Adaugare");

        //adjust size and set layout
        setPreferredSize (new Dimension(944, 574));
        setLayout (null);

        //add components
        add (listaFrogrifice);
        add (ListaProduse);
        add (lblidProdus);
        add (tfldid_produs);
        add (lblProprietati);
        add (textProprietati);
        add (btnBak);
        add (btnAdaugare);

        //set component bounds (only needed by Absolute Positioning)
        listaFrogrifice.setBounds (445, 0, 500, 250);
        ListaProduse.setBounds (445, 325, 500, 250);
        lblidProdus.setBounds (0, 85, 100, 25);
        tfldid_produs.setBounds (0, 110, 200, 25);
        lblProprietati.setBounds (0, 135, 100, 25);
        textProprietati.setBounds (0, 160, 200, 100);
        btnBak.setBounds (0, 0, 50, 25);
        btnAdaugare.setBounds (0, 335, 100, 25);

        btnBak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Main.changeCurrentPanel(new MainPanel());
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

    }
}
