package fr.afpa.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Game extends JFrame implements ActionListener, ChangeListener {
    private static JLabel life;
    private static JLabel rulesLabel;
    private static JTextField text2;
    private static JLabel text3;
    private static JLabel text4;
    private static JLabel text5;
    private static JButton valide;
    private static JLabel check;
    private static JButton resetbtn;
    private static JPanel item;
    private static JButton newGame;
    private static JTextField nbMaxText;
    private static JSlider nbLifeSlider;
    private static JLabel errorCheck;
    private static JLabel nbMax;
    private static JLabel nbLife;

    public Game(String title) {
        super(title);
        ArrayList<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon("icons/shuffle16.png").getImage());
        icons.add(new ImageIcon("icons/shuffle32.png").getImage());
        icons.add(new ImageIcon("icons/shuffle64.png").getImage());
        icons.add(new ImageIcon("icons/shuffle128.png").getImage());
        setIconImages(icons);
        JPanel contentPane = (JPanel) this.getContentPane();//Creation du Panel Parent
        Value.init("1000",8);
        Value.reInit();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(toolbar(), BorderLayout.NORTH);
        contentPane.add(game(), BorderLayout.CENTER);

    }

    private JToolBar toolbar() {
        JToolBar toolbar = new JToolBar();
        toolbar.setBackground(Color.BLACK);
        toolbar.setFloatable(false);



        newGame = new JButton(new ImageIcon("icons/new.png"));
        newGame.setToolTipText("Relancer avec les paramètres actuels");
        newGame.addActionListener(this);
        newGame.setBorderPainted(false);
        toolbar.add(newGame);

        toolbar.addSeparator();

        nbMax = new JLabel(" Valeur max : ");
        nbMax.setForeground(Color.white);
        toolbar.add(nbMax);

        nbMaxText = new JTextField();
        nbMaxText.setPreferredSize(new Dimension(100,25));
        nbMaxText.setBackground(Color.darkGray);
        nbMaxText.setForeground(Color.white);
        if (Value.getValeurRandomMax() == 0) {
            nbMaxText.setText("1000");
        } else {
            nbMaxText.setText("" + Value.getValeurRandomMax());
        }
        toolbar.add(nbMaxText);

        toolbar.addSeparator();

        nbLife = new JLabel("<html><font color ='red';size='+1'> ❤ </font><font color='white';size='+1'> 8</font></html>");
        nbLife.setPreferredSize(new Dimension(50,30));
        nbLife.setForeground(Color.white);
        toolbar.add(nbLife);

        nbLifeSlider = new JSlider(JSlider.HORIZONTAL,1,14,8);
        nbLifeSlider.setPreferredSize(new Dimension(100,25));
        nbLifeSlider.addChangeListener(this);
        if (Value.getLifeMax() == 0){
            nbLifeSlider.setValue(8);
        }else{
            nbLifeSlider.setValue(Value.getLifeMax());
        }
        nbLifeSlider.setBackground(Color.darkGray);
        nbLifeSlider.setForeground(Color.white);
        toolbar.add(nbLifeSlider);

        return toolbar;
    }

    private JPanel game() {
        item = new JPanel(new GridLayout(1, 2));

        JPanel left = new JPanel(null);
        left.setBackground(Color.black);
        item.add(left);

        JPanel right = new JPanel(new GridLayout(1, 3));
        right.setBackground(Color.DARK_GRAY);
        item.add(right);

        life = new JLabel(Value.autoLife());
        life.setBounds(2, -2, (520 / 2), 30);
        left.add(life);

        rulesLabel = new JLabel("<html><h4>Trouver un nombre entre 0 et " + Value.getValeurRandomMax() + "</h4></html>");
        rulesLabel.setBounds(0, 35, 520 / 2, 30);
        rulesLabel.setBorder(null);
        rulesLabel.setHorizontalAlignment(JLabel.CENTER);
        rulesLabel.setForeground(Color.white);
        left.add(rulesLabel);

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
        if (ex.getSource() == newGame) {
            switch (Value.init(nbMaxText.getText(), nbLifeSlider.getValue())) {
                case 0:
                    JOptionPane.showMessageDialog(null,"Revérifier les valeurs rentrés","Erreur",JOptionPane.ERROR_MESSAGE);
                    break;
                case 1:
                    Value.reInit();
                    life.setText(Value.autoLife());
                    rulesLabel.setText("<html><h4>Trouver un nombre entre 0 et " + Value.getValeurRandomMax() + "</h4></html>");
                    text3.setText("<html><h4>");
                    text4.setText("<html><h4>");
                    text5.setText("<html><h4>");
                    check.setText("<html><h2>Entrer un Nombre.</h2></html>");
                    valide.setText("<html><h4>Tester</h4><html>");
                    break;
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource()==nbLifeSlider){
            nbLife.setText("<html><font color ='red';size='+1'> ❤ </font><font color='white';size='+1'> "+nbLifeSlider.getValue()+"</font></html>");
        }
    }
}