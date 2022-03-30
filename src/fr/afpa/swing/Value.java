package fr.afpa.swing;

import java.net.URL;
import java.util.Random;

public class Value {
    // Propriété
    private static int life;
    private static int lifeMax;
    private static boolean endGame = false;
    private static boolean gameStart = false;
    private static int valeurRandomMax;
    private static int nbTentative = 0;
    private static int valeurRandom;
    private static Random random = new Random();
    private static String tentativeRt;

    // Methodes
    public static int init(String random,int life){
        System.out.println("Valeur 1 : "+random+" Valeur 2 : "+life);
        if (checkInt(random)){
            valeurRandomMax = Integer.parseInt(random);
            lifeMax = life;
            return 1;
        }
        else {
            System.out.println("Erreur de syntaxe");
            return 0;
        }
    }
    public static void reInit() {
        life = lifeMax;
        nbTentative = 0;
        valeurRandom = random.nextInt(valeurRandomMax + 1);
        System.out.println("Valeur généré = " + valeurRandom);
    }

    private static boolean checkInt(String numberCheck) {
        try {
            int valeurConv = Integer.parseInt(numberCheck);
        } catch (NumberFormatException e) {
            System.out.println("(" + numberCheck + ") n'est pas un nombre");
            return false;
        }
        return true;
    }


    public static String testNumber(String valeurChoisis) {
        if (checkInt(valeurChoisis)) {
            int valeurConv = Integer.parseInt(valeurChoisis);
            if (valeurConv > valeurRandom) {
                System.out.println("C'est moins");
                life--;
                nbTentative++;
                return "-";
            } else if (valeurConv < valeurRandom) {
                System.out.println("C'est plus");
                life--;
                nbTentative++;
                return "+";
            } else {
                System.out.println("Bien joué vous avez trouver la bonne valeur");
                nbTentative++;
                return "=";
            }
        }
        else {
            return "?";
        }
    }

    public static String autoLife() {
        tentativeRt = "<html><h2><font color ='red'>";
        for (int i = 0; i < life; i++) {
            tentativeRt += "❤";
        }
        tentativeRt += "</font><font color ='#424242'>";
        for (int i = life; i < lifeMax; i++) {
            tentativeRt += "❤";
        }
        tentativeRt += "</font></h2></html>";
        return tentativeRt;
    }

    // Setter getter
    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        Value.life = life;
    }

    public static int getValeurRandom() {
        return valeurRandom;
    }

    public static void setValeurRandom(int valeurRandom) {
        Value.valeurRandom = valeurRandom;
    }

    public static int getNbTentative() {
        return nbTentative;
    }

    public static void setNbTentative(int nbTentative) {
        Value.nbTentative = nbTentative;
    }

    public static boolean isEndGame() {
        return endGame;
    }

    public static void setEndGame(boolean endGame) {
        Value.endGame = endGame;
    }

    public static int getLifeMax() {
        return lifeMax;
    }

    public static void setLifeMax(int lifeMax) {
        Value.lifeMax = lifeMax;
    }

    public static int getValeurRandomMax() {
        return valeurRandomMax;
    }

    public static void setValeurRandomMax(int valeurRandomMax) {
        Value.valeurRandomMax = valeurRandomMax;
    }

    public static boolean isGameStart() {
        return gameStart;
    }

    public static void setGameStart(boolean gameStart) {
        Value.gameStart = gameStart;
    }
}




