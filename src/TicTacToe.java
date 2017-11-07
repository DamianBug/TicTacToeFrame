import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Damian on 06.11.2017.
 */
public class TicTacToe extends JFrame implements ActionListener {

    private int counter;
    private ArrayList<JButton> buttons = new ArrayList<>();

    public TicTacToe(){
        setTitle("Kółko i krzyżyk");
        setLayout(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++){
            JButton button = new JButton(" ");
            button.addActionListener(this);
            add(button);
            buttons.add(button);
        }
        setSize(new Dimension(600, 600));
        setVisible(true);
    }

    public boolean isWinner(){
        if (isWinner(0, 1, 2)){
            return true;
        }
        if (isWinner(3, 4,5)){
            return true;
        }
        if (isWinner(6, 7,8)){
            return true;
        }
        if (isWinner(0, 3, 6)){
            return true;
        }
        if (isWinner(1, 4, 7)){
            return true;
        }
        if (isWinner(2, 5, 8)){
            return  true;
        }
        if (isWinner(0, 4, 6)){
            return true;
        }
        return false;
    }

    public boolean isWinner(int i, int j, int k){
        System.out.println(buttons.get(i).getText());
            if (buttons.get(i).getText().equals(" ")){
                return false;
        }
        if (buttons.get(i).getText().equals(buttons.get(j).getText()) &&
                buttons.get(j).getText().equals(buttons.get(k).getText())){
                return true;
        }else {
            return false;
        }
    }

    public void setAllDisable(){
        for (JButton button : buttons){
            button.setEnabled(false);
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToe();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (counter % 2 == 0){
            button.setText("X");
        }else {
            button.setText("O");
        }
        counter++;
        button.setEnabled(false);
        if (isWinner()){
            JOptionPane.showMessageDialog(null, "Koniec gry");
            setAllDisable();
        }else {
            if (counter == 9)
            JOptionPane.showMessageDialog(null,"Koniec gry nikt nie wygrał");
        }
        System.out.println("Kliknięcie");
    }
}

