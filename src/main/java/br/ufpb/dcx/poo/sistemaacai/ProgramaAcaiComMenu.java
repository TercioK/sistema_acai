package br.ufpb.dcx.poo.sistemaacai;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ProgramaAcaiComMenu {
    public static void main(String [] args) {
        JFrame sistemaMenu = new AcaiUserMenu();

        sistemaMenu.setVisible(true);
        WindowListener fechadorJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };
        sistemaMenu.addWindowListener(fechadorJanelaPrincipal);
    }
}
