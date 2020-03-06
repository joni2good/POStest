import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class interMain {
    private JPanel MainMenu;
    private JButton Pepper;
    private JTextPane totalField;
    private JButton Pig;
    private JButton Apple;
    private JButton HardCandy;
    private JButton minus;
    private JButton plus;
    private JTextField amountField;
    private JTextPane bonField;
    private JButton pay;
    private JButton clear;
    private JButton Cow;
    private JButton Fish;
    private JButton Chicken;
    private JButton Banana;
    private JButton Pineapple;
    private JButton Orange;
    private JButton Salad;
    private JButton Cucumber;
    private JButton Carrot;
    private JButton GummyWorms;
    private JButton Bubblegum;
    private JButton GummyBears;
    private String strTempAmount;
    private int tempAmount;
    private int amount = 0;
    private int prodPick = 0;
    private int prodAmount = 16;
    private double total = 0.00;
    private boolean pmPick = false;
    private ArrayList<String> prodList = new ArrayList();
    private ArrayList<Integer> prodListCount = new ArrayList();
    private Document doc = bonField.getDocument();
    private Document doc2 = totalField.getDocument();
    private DecimalFormat df = new DecimalFormat("#.00");

    private interMain() {
        //this is a test branch
        //this is a second test branch

        for(int i = 0; i <= prodAmount; i++){
            prodListCount.add(0);
        }

        Pig.addActionListener(e -> {
            prodPick = 1;
            doAction();
        });

        Cow.addActionListener(e -> {
            prodPick = 2;
            doAction();
        });

        Fish.addActionListener(e -> {
            prodPick = 3;
            doAction();
        });

        Chicken.addActionListener(e -> {
            prodPick = 4;
            doAction();
        });

        Apple.addActionListener(e -> {
            prodPick = 5;
            doAction();
        });

        Banana.addActionListener(e -> {
            prodPick = 6;
            doAction();
        });

        Orange.addActionListener(e -> {
            prodPick = 7;
            doAction();
        });

        Pineapple.addActionListener(e -> {
            prodPick = 8;
            doAction();
        });

        Pepper.addActionListener(e -> {
            prodPick = 9;
            doAction();
        });

        Cucumber.addActionListener(e -> {
            prodPick = 10;
            doAction();
        });

        Salad.addActionListener(e -> {
            prodPick = 11;
            doAction();
        });

        Carrot.addActionListener(e -> {
            prodPick = 12;
            doAction();
        });

        GummyWorms.addActionListener(e -> {
            prodPick = 13;
            doAction();
        });

        HardCandy.addActionListener(e -> {
            prodPick = 14;
            doAction();
        });

        Bubblegum.addActionListener(e -> {
            prodPick = 15;
            doAction();
        });

        GummyBears.addActionListener(e -> {
            prodPick = prodAmount;
            doAction();
        });

        plus.addActionListener(e -> {
            getPlus();
            pmPick = true;
        });

        minus.addActionListener(e -> {
            getMinus();
            pmPick = false;
        });

        clear.addActionListener(e -> {
            try {
                total = 0;
                Collections.fill(prodListCount, 0);
                prodList.clear();
                if (total == 0) {
                    doc.remove(0, doc.getLength());
                    doc2.remove(0, doc2.getLength());
                    doc2.insertString(doc2.getLength(), "0.00 $", null);
                } else {
                    doc2.remove(0, doc2.getLength());
                    doc2.insertString(doc2.getLength(), df.format(total) + " $", null);
                }
            }catch (Exception E){
                JOptionPane.showMessageDialog(null, "Something went wrong. Error msg 4.");
            }
        });

        pay.addActionListener(e -> {
            try {
                total = 0;
                Collections.fill(prodListCount, 0);
                prodList.clear();
                if (total == 0) {
                    doc.remove(0, doc.getLength());
                    doc2.remove(0, doc2.getLength());
                    doc2.insertString(doc2.getLength(), "", null);
                } else {
                    doc2.remove(0, doc2.getLength());
                    doc2.insertString(doc2.getLength(), df.format(total) + " $", null);
                }
            }catch (Exception E){
                JOptionPane.showMessageDialog(null, "Something went wrong. Error msg 4.");
            }
        });

    }

    private String getPick(int Pick) {
        if (Pick == 1) {
            return "Pig";
        } else if (Pick == 2) {
            return "Cow";
        } else if (Pick == 3) {
            return "Fish";
        } else if (Pick == 4) {
            return "Chicken";
        }  else if (Pick == 5) {
            return "Apple";
        } else if (Pick == 6) {
            return "Banana";
        } else if (Pick == 7) {
            return "Orange";
        } else if (Pick == 8) {
            return "Pineapple";
        } else if (Pick == 9) {
            return "Pepper";
        } else if (Pick == 10) {
            return "Cucumber";
        } else if (Pick == 11) {
            return "Salad";
        } else if (Pick == 12) {
            return "Carrot";
        } else if (Pick == 13) {
            return "Gummy worms";
        } else if (Pick == 14) {
            return "Hard candy";
        } else if (Pick == 15) {
            return "Bubblegum";
        } else if (Pick == 16) {
            return "Gummy bears";
        } else if (Pick == 0) {
            return "???";
        }else{
            return "???";
        }
    }

    private double getTotal(){
        return (prodListCount.get(0) * 9.95) + (prodListCount.get(1) * 7.95) + (prodListCount.get(2) * 4.5) + (prodListCount.get(3) * 40.5) + (prodListCount.get(4) * 0.25) + (prodListCount.get(5) * 0.25) + (prodListCount.get(6) * 0.5) + (prodListCount.get(7) * 2.5) + (prodListCount.get(8) * 0.75) + (prodListCount.get(9) * 0.95) + (prodListCount.get(10) * 2) + (prodListCount.get(11) * 1.5) + (prodListCount.get(12) * 1.5) + (prodListCount.get(13) * 0.5) + (prodListCount.get(14)) + (prodListCount.get(15) * 0.5);
    }

    private void getPlus(){
        try {
            if(amountField.getText().equals("")) {
                amount = 1;
            }else{
                strTempAmount = amountField.getText();
                amount = Integer.parseInt(strTempAmount);
            }
            for(int i = 0; i < prodListCount.size(); i++){
                if(prodPick == i + 1 && !prodList.contains(getPick(prodPick))){
                    prodList.add(getPick(prodPick));
                    tempAmount = prodListCount.get(i) + amount;
                    prodListCount.set(i, tempAmount);
                    break;
                }else if(prodPick == i + 1 && prodList.contains(getPick(prodPick))){
                    tempAmount = prodListCount.get(i) + amount;
                    prodListCount.set(i, tempAmount);
                    break;
                }else if(prodPick == 0 && !prodList.contains(getPick(prodPick))){
                    prodList.add(getPick(prodPick));
                    tempAmount = prodListCount.get(prodAmount) + amount;
                    prodListCount.set(prodAmount, tempAmount);
                    break;
                }else if(prodPick == 0 && prodList.contains(getPick(prodPick))){
                    tempAmount = prodListCount.get(prodAmount) + amount;
                    prodListCount.set(prodAmount, tempAmount);
                    break;
                }
            }
        }catch (Exception E){
            JOptionPane.showMessageDialog(null, "Something went wrong. Error msg 1.");
        }
        printInfo();
    }

    private void getMinus(){
        try {
            if(amountField.getText().equals("")) {
                amount = 1;
            }else{
                strTempAmount = amountField.getText();
                amount = Integer.parseInt(strTempAmount);
            }
            for(int i = 0; i < prodListCount.size(); i++){
                if(prodPick == i + 1){
                    tempAmount = prodListCount.get(i) - amount;
                    if(tempAmount <= 0) {
                        prodListCount.set(i, 0);
                        for (int e = 0; e < prodList.size(); e++) {
                            if(prodList.get(e).equals(getPick(prodPick))){
                                prodList.remove(e);
                            }
                        }
                        break;
                    }else{
                        prodListCount.set(i, tempAmount);
                        break;
                    }
                }else if(prodPick == 0){
                    tempAmount = prodListCount.get(prodAmount) - amount;
                    if(tempAmount <= 0) {
                        prodListCount.set(prodAmount, 0);
                        for (int e = 0; e < prodList.size(); e++) {
                            if(prodList.get(e).equals(getPick(0))){
                                prodList.remove(e);
                            }
                        }
                        break;
                    }else{
                        prodListCount.set(prodAmount, tempAmount);
                        break;
                    }
                }
            }
        }catch (Exception E){
            JOptionPane.showMessageDialog(null, "Something went wrong. Error msg 3.");
        }
        printInfo();
    }

    private void doAction(){
        if(pmPick){
            getPlus();
        }else{
            getMinus();
        }
    }

    private void printInfo(){
        try{
            doc.remove(0, doc.getLength());
            for(int i = 0; i < prodListCount.size(); i++){
                if(prodList.contains(getPick(i + 1))){
                    doc.insertString(doc.getLength(), getPick(i + 1) + " x " + prodListCount.get(i), null);
                    doc.insertString(doc.getLength(), "\n", null);
                }
            }
            total = getTotal();
            if(total == 0){
                doc2.remove(0, doc2.getLength());
                doc2.insertString(doc2.getLength(), "0.00 $", null);
            }else{
                doc2.remove(0, doc2.getLength());
                doc2.insertString(doc2.getLength(), df.format(total) + " $", null);
            }
        }catch (BadLocationException B) {
            JOptionPane.showMessageDialog(null, "Something went wrong. Error msg 2.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("POS System");
        frame.setContentPane(new interMain().MainMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}