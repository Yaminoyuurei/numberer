package fr.afpa.swing;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(new NimbusLookAndFeel());
    Window window = new Window("Devine le Nombre");
    window.setVisible(true);
    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Fermer le programme avec [X]
    window.setSize(260, 280);
    window.setLocationRelativeTo(null);//Afficher au milieu de l'ecran
    window.setResizable(false);//Interdire le redimmensionnement
}
}
