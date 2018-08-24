import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.util.Arrays;




public class TypeTutor extends JFrame //implements KeyListener
{
    private final String noticeWord = "Type some test using your keyboard. The keys you press will be highlighted and the text will be displayed.";
    private final String noticeWordLine2 = "Note: Clicking the buttons with your mouse will not perform any action.";

    private final JTextArea noticeTextArea;
    private final JTextArea userTypeArea;
    private static final String[] firstLineKeyStr = {"`","1","2","3","4","5","6","7","8","9","0","-","=","Backspace"}; 
    private static final String[] secLineKeyStr = {"Tab","Q","W","E","R","T","Y","U","I","O","P","{","}","\\"};
    private static final String[] thirdLineKeyStr = {"Caps","A","S","D","F","G","H","J","K","L",";","\'","Enter"};
    private static final String[] forthLineKeyStr = {"Shift","Z","X","C","V","B","N","M",",",".","/","^"};
    private static final String[] fifthLineKeyStr = {"","<","v",">"};

    //private final JPanel virtualKey;
    private final JPanel buttonFirstLinePanel;
    private final JPanel buttonSecLinePanel;
    private final JPanel buttonThirdLinePanel;
    private final JPanel buttonForthLinePanel;
    private final JPanel buttonFifthLinePanel;

    private final JButton[] firstLineButton;
    private final JButton[] secLineButton;
    private final JButton[] thirdLineButton;
    private final JButton[] forthLineButton;
    private final JButton[] fifthLineButton;

    public static void main(String[] args)
    {
        TypeTutor mytutor = new TypeTutor();
        mytutor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mytutor.setSize(1400, 800);
        mytutor.setVisible(true);

    }



    public TypeTutor()
    {
        super("Typing Application");

        Box mainLayout = Box.createVerticalBox();

        //Top: notice words
        noticeTextArea = new JTextArea(noticeWord+"\n"+noticeWordLine2);
        noticeTextArea.setEditable(false);
        mainLayout.add(noticeTextArea);
        //Middle: Type area
        userTypeArea = new JTextArea(40,15);
        mainLayout.add(new JScrollPane(userTypeArea));
        userTypeArea.addKeyListener(
            new KeyListener()
                {
                    @Override
                    public void keyTyped(KeyEvent event)
                    {
                        char typeKey = event.getKeyChar();
                        
                        if (typeKey==VK_BACK_SPACE) {
                            JOptionPane.showMessageDialog(null, "??? was typed");
                        }
                        
                        
                        if (Character.isLetter(typeKey))
                            typeKey = Character.toUpperCase(typeKey);
                        
                        
                        String typeChar = Character.toString(typeKey);
                        if (Arrays.asList(firstLineKeyStr).contains(typeChar)) {
                            firstLineButton[Arrays.asList(firstLineKeyStr).indexOf(typeChar)].setBackground(Color.red);
                        }
                        else if (Arrays.asList(secLineKeyStr).contains(typeChar)) {
                            secLineButton[Arrays.asList(secLineKeyStr).indexOf(typeChar)].setBackground(Color.red);
                        }
                        else if (Arrays.asList(thirdLineKeyStr).contains(typeChar)) {
                            thirdLineButton[Arrays.asList(thirdLineKeyStr).indexOf(typeChar)].setBackground(Color.red);
                        }
                        else if (Arrays.asList(forthLineKeyStr).contains(typeChar)) {
                            forthLineButton[Arrays.asList(forthLineKeyStr).indexOf(typeChar)].setBackground(Color.red);
                        }
                        else if (Arrays.asList(fifthLineKeyStr).contains(typeChar)) {
                            fifthLineButton[Arrays.asList(fifthLineKeyStr).indexOf(typeChar)].setBackground(Color.red);
                        }
                        else {
                            
                            //JOptionPane.showMessageDialog(null, "??? was typed");
                            //if (typeChar==" ")
                                //firstLineButton[Arrays.asList(firstLineKeyStr).indexOf(" ")].setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, String.format("%s %d was typed.",typeChar,typeKey));
                        }
                    }

                    @Override
                    public void keyPressed(KeyEvent event)
                    {
                        //Do nothing
                        //JOptionPane.showMessageDialog(null, "B was typed");
                        
                    }

                    @Override
                    public void keyReleased(KeyEvent event)
                    {
                        char typeKey = event.getKeyChar();
                        typeKey = Character.toUpperCase(typeKey);
                        String typeChar = Character.toString(typeKey);
                        if (Arrays.asList(firstLineKeyStr).contains(typeChar)) {
                            firstLineButton[Arrays.asList(firstLineKeyStr).indexOf(typeChar)].setBackground(new JButton().getBackground());
                        }
                        else if (Arrays.asList(secLineKeyStr).contains(typeChar)) {
                            secLineButton[Arrays.asList(secLineKeyStr).indexOf(typeChar)].setBackground(new JButton().getBackground());
                        }
                        else if (Arrays.asList(thirdLineKeyStr).contains(typeChar)) {
                            thirdLineButton[Arrays.asList(thirdLineKeyStr).indexOf(typeChar)].setBackground(new JButton().getBackground());
                        }
                        else if (Arrays.asList(forthLineKeyStr).contains(typeChar)) {
                            forthLineButton[Arrays.asList(forthLineKeyStr).indexOf(typeChar)].setBackground(new JButton().getBackground());
                        }
                        else if (Arrays.asList(fifthLineKeyStr).contains(typeChar)) {
                            fifthLineButton[Arrays.asList(fifthLineKeyStr).indexOf(typeChar)].setBackground(new JButton().getBackground());
                        }
                        else {
                            
                            //JOptionPane.showMessageDialog(null, "??? was typed");
                            //JOptionPane.showMessageDialog(null, String.format("%s %d was typed.",typeChar,Arrays.asList(thirdLineButton).indexOf(typeChar)));
                        }
                        
                    }
                }
        );

        //Bottom: virtual key
        Box bottomLayout = Box.createVerticalBox();

        //First line
        //Box firstLineKey = Box.createHorizontalBox();
        buttonFirstLinePanel = new JPanel();
        buttonFirstLinePanel.setLayout(new GridLayout(1, firstLineKeyStr.length, 2, 2));
        firstLineButton = new JButton[firstLineKeyStr.length];
        for (int i=0; i<firstLineKeyStr.length; i++) {
            firstLineButton[i] = new JButton(firstLineKeyStr[i]);
            buttonFirstLinePanel.add(firstLineButton[i]);
        }
        //bottomLayout.add(firstLineKey);
        bottomLayout.add(buttonFirstLinePanel);
        
        //Sec line
        buttonSecLinePanel = new JPanel();
        buttonSecLinePanel.setLayout(new GridLayout(1, secLineKeyStr.length, 2, 2));
        secLineButton = new JButton[secLineKeyStr.length];
        for (int i=0; i<secLineKeyStr.length; i++) {
            secLineButton[i] = new JButton(secLineKeyStr[i]);
            buttonSecLinePanel.add(secLineButton[i]);
        }
        bottomLayout.add(buttonSecLinePanel);
        //Third line
        buttonThirdLinePanel = new JPanel();
        buttonThirdLinePanel.setLayout(new GridLayout(1, thirdLineKeyStr.length, 2, 2));
        thirdLineButton = new JButton[thirdLineKeyStr.length];
        for (int i=0; i<thirdLineKeyStr.length; i++) {
            thirdLineButton[i] = new JButton(thirdLineKeyStr[i]);
            buttonThirdLinePanel.add(thirdLineButton[i]);
        }
        bottomLayout.add(buttonThirdLinePanel);
        //Forth line
        buttonForthLinePanel = new JPanel();
        buttonForthLinePanel.setLayout(new GridLayout(1, forthLineKeyStr.length, 2, 2));
        forthLineButton = new JButton[forthLineKeyStr.length];
        for (int i=0; i<forthLineKeyStr.length; i++) {
            forthLineButton[i] = new JButton(forthLineKeyStr[i]);
            buttonForthLinePanel.add(forthLineButton[i]);
        }
        bottomLayout.add(buttonForthLinePanel);
        //Fifth line
        buttonFifthLinePanel = new JPanel();
        buttonFifthLinePanel.setLayout(new GridLayout(1, fifthLineKeyStr.length, 2, 2));
        fifthLineButton = new JButton[fifthLineKeyStr.length];
        for (int i=0; i<fifthLineKeyStr.length; i++) {
            fifthLineButton[i] = new JButton(fifthLineKeyStr[i]);
            buttonFifthLinePanel.add(fifthLineButton[i]);
        }
        bottomLayout.add(buttonFifthLinePanel);

        mainLayout.add(bottomLayout);
        add(mainLayout);
        //addKeyListener(this);
    }
/*
    @Override
    public void keyTyped(KeyEvent event)
    {
        JOptionPane.showMessageDialog(null, "A was typed");
        JButton activateButton = (JButton)event.getSource();
        activateButton.setBackground(Color.red);
    }

    @Override
    public void keyPressed(KeyEvent event)
    {
        //Do nothing
    }

    @Override
    public void keyReleased(KeyEvent event)
    {
        //Do nothing
    }
*/
}