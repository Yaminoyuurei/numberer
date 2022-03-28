package fr.afpa.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame implements ActionListener {
    private static JLabel life;
    private static JTextField text2;
    private static JLabel text3;
    private static JLabel text4;
    private static JLabel text5;
    private static JButton valide;
    private static JLabel check;
    private static JButton resetbtn;
    private static JPanel item;
    private static JButton newGame;
    private static JPanel menu;
    private static JTextField nbMaxText;
    private static JTextField nbLifeText;
    private static JLabel errorCheck;

    public Window(String title) {
        super(title);
        JPanel contentPane = (JPanel) this.getContentPane();//Creation du Panel Parent

        contentPane.add(mainMenu());
    }

    private JPanel mainMenu() {
        setSize(260,280);
        menu = new JPanel(new GridLayout(1, 1));


        JPanel left = new JPanel(new FlowLayout(FlowLayout.CENTER));
        left.setBackground(Color.black);
        menu.add(left);

        JLabel nbMax = new JLabel("<html><h4>Valeur aléatoire max :</h4></html>");
        nbMax.setForeground(Color.white);
        left.add(nbMax);

        nbMaxText = new JTextField("1000");
        nbMaxText.setPreferredSize(new Dimension(150, 30));
        nbMaxText.setBackground(Color.DARK_GRAY);
        nbMaxText.setForeground(Color.white);
        left.add(nbMaxText);

        JLabel nbLife = new JLabel("<html><h4>Nombre de tentatives : (Max 12)</h4></html>");
        nbLife.setForeground(Color.white);
        left.add(nbLife);

        nbLifeText = new JTextField("8");
        nbLifeText.setPreferredSize(new Dimension(150, 30));
        nbLifeText.setBackground(Color.DARK_GRAY);
        nbLifeText.setForeground(Color.white);
        left.add(nbLifeText);

        errorCheck = new JLabel("");
        errorCheck.setForeground(Color.white);


        newGame = new JButton("<html><h4>Jouer</h4><html>");
        newGame.setPreferredSize(new Dimension(100, 30));
        newGame.setBackground(Color.DARK_GRAY);
        newGame.setForeground(Color.white);
        newGame.addActionListener(this);
        left.add(newGame);
        left.add(errorCheck);
        return menu;
    }

    private JPanel game() {
        setSize(520,280);
        item = new JPanel(new GridLayout(1, 2));

        JPanel left = new JPanel(null);
        left.setBackground(Color.black);
        item.add(left);

        JPanel right = new JPanel(new GridLayout(1, 3));
        right.setBackground(Color.DARK_GRAY);
        item.add(right);
        resetbtn = new JButton("<html><h5>⏪</h5></html>");
        resetbtn.setHorizontalAlignment(JLabel.CENTER);
        resetbtn.setBorder(null);
        resetbtn.setBackground(Color.DARK_GRAY);
        resetbtn.setForeground(Color.white);
        resetbtn.setBounds(2, 2, 25, 25);
        resetbtn.addActionListener(this);
        ;
        left.add(resetbtn);

        life = new JLabel(Value.autoLife());
        life.setBounds(30, -2, (520 / 2) - 30, 30);
        left.add(life);

        JLabel text1 = new JLabel("<html><h4>Trouver un nombre entre 0 et " + Value.getValeurRandomMax() + "</h4></html>");
        text1.setBounds(0, 35, 520 / 2, 30);
        text1.setBorder(null);
        text1.setHorizontalAlignment(JLabel.CENTER);
        text1.setForeground(Color.white);
        left.add(text1);

        check = new JLabel("<html><h2>Entrer un Nombre.</h2></html>");
        check.setBounds(0, 110, 520 / 2, 100);
        check.setHorizontalAlignment(JLabel.CENTER);
        check.setForeground(Color.white);
        //
        text2 = new JTextField("");
        text2.setBounds(20, 80, 100, 30);
        text2.setPreferredSize(new Dimension(100, 30));
        text2.setBackground(Color.DARK_GRAY);
        text2.setForeground(Color.white);
        text2.addActionListener(this);
        left.add(text2);

        //Tableau des Historique
        JPanel col1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        col1.setBackground(Color.DARK_GRAY);
        right.add(col1);
        text3 = new JLabel("<html><h4>");
        text3.setHorizontalAlignment(0);
        text3.setForeground(Color.white);
        col1.add(text3);

        JPanel col2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        col2.setBackground(Color.DARK_GRAY);
        right.add(col2);
        text4 = new JLabel("<html><h4>");
        text4.setForeground(Color.white);
        col2.add(text4);

        JPanel col3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        col3.setBackground(Color.DARK_GRAY);
        right.add(col3);
        text5 = new JLabel("<html><h4>");
        text5.setForeground(Color.white);
        col3.add(text5);

        valide = new JButton("<html><h4>Tester</h4><html>");
        valide.setBounds(130, 80, 100, 30);
        valide.setBackground(Color.DARK_GRAY);
        valide.setForeground(Color.white);
        valide.addActionListener(this);
        left.add(valide);
        left.add(check);

        return item;
    }

    @Override
    public void actionPerformed(ActionEvent ex) {
        if (ex.getSource() == valide | ex.getSource() == text2)
            if (!Value.isEndGame()) {
                String test = Value.testNumber(text2.getText());
                switch (test) {
                    case "-":
                        life.setText(Value.autoLife());
                        text3.setText(text3.getText() + "(" + Value.getNbTentative() + ")<br>");
                        text4.setText(text4.getText() + text2.getText() + "<br>");
                        text5.setText(text5.getText() + "C'est moins<br>");
                        check.setText("<html><h2><font color ='yellow'>C'est moins.</font></h2></html>");
                        text2.setText("");
                        break;
                    case "+":
                        life.setText(Value.autoLife());
                        text3.setText(text3.getText() + "(" + Value.getNbTentative() + ")<br>");
                        text4.setText(text4.getText() + text2.getText() + "<br>");
                        text5.setText(text5.getText() + "C'est plus<br>");
                        check.setText("<html><h2><font color ='yellow'>C'est plus.</font></h2></html>");
                        text2.setText("");
                        break;
                    case "=":
                        life.setText(Value.autoLife());
                        text3.setText(text3.getText() + "(" + Value.getNbTentative() + ")<br>");
                        text4.setText(text4.getText() + text2.getText() + "<br>");
                        text5.setText(text5.getText() + "C'est gagné<br>");
                        check.setText("<html><h2><font color ='green'>Bien joué.<br>Le nombre étais bien " + Value.getValeurRandom() + ".</font></h2></html>");
                        text2.setText("");
                        valide.setText("<html><h4>Rejouer</h4><html>");
                        Value.setEndGame(true);
                        break;
                    default:
                        check.setText("<html><h2><font color ='red'>Valeur invalide.</font></h2></html>");
                        text2.setText("");
                        break;
                }
                if (Value.getLife() == 0) {
                    life.setText(Value.autoLife());
                    text2.setText("");
                    check.setText("<html><h2><font color ='red'>GAME OVER<br>Le nombre étais : " + Value.getValeurRandom() + ".</font></h2></html>");
                    valide.setText("<html><h4>Rejouer</h4><html>");
                    Value.setEndGame(true);
                }
            } else {
                Value.reInit();
                life.setText(Value.autoLife());
                text3.setText("<html><h4>");
                text4.setText("<html><h4>");
                text5.setText("<html><h4>");
                check.setText("<html><h2>Entrer un Nombre.</h2></html>");
                valide.setText("<html><h4>Tester</h4><html>");
                Value.setEndGame(false);
            }
        if (ex.getSource() == resetbtn) {
            getContentPane().remove(item);
            getContentPane().add(mainMenu());
            getContentPane().validate();
        }
        if (ex.getSource() == newGame) {
            switch (Value.init(nbMaxText.getText(), nbLifeText.getText())) {
                case 0:
                    errorCheck.setText("<html><h4 font color='red'>Revérifier les valeurs rentrés</h4></html>");
                    break;
                case 1:
                    Value.reInit();
                    getContentPane().remove(menu);
                    getContentPane().add(game());
                    getContentPane().validate();
                    break;
                case 2:
                    errorCheck.setText("<html><h4 font color='red'>Le nombre de vie n'est pas cohérant</h4></html>");
                    break;
            }
        }
    }
}