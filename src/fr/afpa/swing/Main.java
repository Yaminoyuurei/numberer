package fr.afpa.swing;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(new NimbusLookAndFeel());
    Game game = new Game("Devine le Nombre");
    game.setVisible(true);
    game.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Fermer le programme avec [X]
    game.setSize(520, 325);
    game.setLocationRelativeTo(null);//Afficher au milieu de l'ecran
    game.setResizable(false);//Interdire le redimmensionnement
}
}
