package bank_mangement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField cardTextField;
    JButton login,signup,Clear;
    JPasswordField pinTextField;
    Login(){
        //set Background
        getContentPane().setBackground(Color.WHITE);

        //top Border text
        setTitle("AUTOMATED TELLER MACHINE");

        //disable default layout
        setLayout(null);

        //set Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //setImage size
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jLabel = new JLabel(i3);
        //Set image location
        jLabel.setBounds(100,20,100,100);
        add(jLabel);

        //setText
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(300,40,500,50);
        add(text);

        //Text
        JLabel CardNo = new JLabel("CARD NO. : ");
        CardNo.setFont(new Font("Raleway",Font.BOLD,30));
        CardNo.setBounds(200,150,200,50);
        add(CardNo);

        //TextField
        cardTextField = new JTextField();
        cardTextField.setBounds(400,150,250,40);
        cardTextField.setFont(new Font("Arial",Font.BOLD,20));
        add(cardTextField);

        //Text
        JLabel PIN = new JLabel("PIN : ");
        PIN.setFont(new Font("Raleway",Font.BOLD,30));
        PIN.setBounds(200,240,200,50);
        add(PIN);

        //TextField
         pinTextField = new JPasswordField();
        pinTextField.setBounds(400,240,250,40);

        add(pinTextField);

        //login
         login = new JButton("LOGIN");
        login.setBounds(400,320,100,35);
        login.setBackground(Color.BLACK);
       login.addActionListener(this);
        login.setForeground(Color.WHITE);
        add(login);

        //Clear
        Clear = new JButton("CLEAR");
        Clear.setBounds(550,320,100,35);
        Clear.setBackground(Color.BLACK);
        Clear.addActionListener(this);
        Clear.setForeground(Color.WHITE);
        add(Clear);

        //signup
          signup = new JButton("SIGN UP");
       signup.setBounds(400,380,250,35);
        signup.setBackground(Color.BLACK);
        signup.addActionListener(this);
        signup.setForeground(Color.WHITE);
        add(signup);



        setResizable(false);

        setSize(900,520);
        setLocation(250,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == Clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (actionEvent.getSource() == login) {
            String pin = pinTextField.getText();
            String card = cardTextField.getText();
            conn cn = new conn();
            String query = "select * from login where car_no = '"+card+"' and pin = '"+pin+"'";
          try {
              ResultSet rs = cn.s.executeQuery(query);


              if (rs.next()){
                  setVisible(false);
                  new transaction(card);
              }

              else{
                  JOptionPane.showMessageDialog(null,"Incorrect Card No or pin");
              }

          } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
          }


        } else if (actionEvent.getSource() == signup) {
                setVisible(false);
                new SignUP_Main();
        }
    }

    public static void main(String[] args) {
        new Login();
    }



}
