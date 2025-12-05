package BMS;

import javax.swing.*;
import java.awt.*;

public class BankingFrontend {

    public static void main(String[] args) {
        new BankingFrontend();
    }

    JFrame frame;
    CardLayout layout;
    JPanel mainPanel;

    public BankingFrontend() {
        frame = new JFrame("Banking System UI");
        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        mainPanel.add(welcomeScreen(), "welcome");
        mainPanel.add(registerScreen(), "register");
        mainPanel.add(loginScreen(), "login");
        mainPanel.add(dashboardScreen(), "dashboard");
        mainPanel.add(accountOpsScreen(), "ops");

        frame.add(mainPanel);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        layout.show(mainPanel, "welcome");
    }

    // ---------------------------- 1. WELCOME SCREEN -----------------------------

    JPanel welcomeScreen() {
        JPanel p = new JPanel(new GridLayout(4,1,10,10));
        p.setBorder(BorderFactory.createEmptyBorder(40,30,40,30));

        JLabel title = new JLabel("WELCOME TO BANKING SYSTEM", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        p.add(title);

        JButton reg = new JButton("Register");
        JButton log = new JButton("Login");
        JButton exit = new JButton("Exit");

        reg.addActionListener(e -> layout.show(mainPanel, "register"));
        log.addActionListener(e -> layout.show(mainPanel, "login"));
        exit.addActionListener(e -> System.exit(0));

        p.add(reg);
        p.add(log);
        p.add(exit);

        return p;
    }

    // ---------------------------- 2. REGISTER SCREEN -----------------------------

    JPanel registerScreen() {
        JPanel p = new JPanel(new GridLayout(6,1,10,10));
        p.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        JLabel t = new JLabel("REGISTER USER", JLabel.CENTER);
        t.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField name = new JTextField();
        name.setBorder(BorderFactory.createTitledBorder("Full Name"));

        JTextField email = new JTextField();
        email.setBorder(BorderFactory.createTitledBorder("Email"));

        JPasswordField pass = new JPasswordField();
        pass.setBorder(BorderFactory.createTitledBorder("Password"));

        JButton submit = new JButton("Register");
        JButton back = new JButton("Back");

        submit.addActionListener(e ->
                JOptionPane.showMessageDialog(null, "User Registered (connect backend manually)")
        );

        back.addActionListener(e -> layout.show(mainPanel, "welcome"));

        p.add(t);
        p.add(name);
        p.add(email);
        p.add(pass);
        p.add(submit);
        p.add(back);

        return p;
    }

    // ---------------------------- 3. LOGIN SCREEN -----------------------------

    JPanel loginScreen() {
        JPanel p = new JPanel(new GridLayout(5,1,10,10));
        p.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        JLabel t = new JLabel("USER LOGIN", JLabel.CENTER);
        t.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField email = new JTextField();
        email.setBorder(BorderFactory.createTitledBorder("Email"));

        JPasswordField pass = new JPasswordField();
        pass.setBorder(BorderFactory.createTitledBorder("Password"));

        JButton login = new JButton("Login");
        JButton back = new JButton("Back");

        login.addActionListener(e -> layout.show(mainPanel, "dashboard"));
        back.addActionListener(e -> layout.show(mainPanel, "welcome"));

        p.add(t);
        p.add(email);
        p.add(pass);
        p.add(login);
        p.add(back);

        return p;
    }

    // ---------------------------- 4. DASHBOARD SCREEN -----------------------------

    JPanel dashboardScreen() {
        JPanel p = new JPanel(new GridLayout(5,1,10,10));
        p.setBorder(BorderFactory.createEmptyBorder(40,30,40,30));

        JLabel t = new JLabel("USER DASHBOARD", JLabel.CENTER);
        t.setFont(new Font("Arial", Font.BOLD, 16));

        JButton openAcc = new JButton("Open a New Bank Account");
        JButton ops = new JButton("Account Operations");
        JButton logout = new JButton("Logout");

        openAcc.addActionListener(e ->
                JOptionPane.showMessageDialog(null, "Opening Account (connect backend manually)")
        );

        ops.addActionListener(e -> layout.show(mainPanel, "ops"));
        logout.addActionListener(e -> layout.show(mainPanel, "welcome"));

        p.add(t);
        p.add(openAcc);
        p.add(ops);
        p.add(logout);

        return p;
    }

    // ---------------------------- 5. ACCOUNT OPERATIONS SCREEN -----------------------------

    JPanel accountOpsScreen() {
        JPanel p = new JPanel(new GridLayout(6,1,10,10));
        p.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        JLabel t = new JLabel("ACCOUNT OPERATIONS", JLabel.CENTER);
        t.setFont(new Font("Arial", Font.BOLD, 16));

        JButton debit = new JButton("Debit Money");
        JButton credit = new JButton("Credit Money");
        JButton transfer = new JButton("Transfer Money");
        JButton balance = new JButton("Check Balance");
        JButton back = new JButton("Back");

        debit.addActionListener(e -> JOptionPane.showMessageDialog(null,"Debit (connect backend)"));
        credit.addActionListener(e -> JOptionPane.showMessageDialog(null,"Credit (connect backend)"));
        transfer.addActionListener(e -> JOptionPane.showMessageDialog(null,"Transfer (connect backend)"));
        balance.addActionListener(e -> JOptionPane.showMessageDialog(null,"Balance (connect backend)"));

        back.addActionListener(e -> layout.show(mainPanel, "dashboard"));

        p.add(t);
        p.add(debit);
        p.add(credit);
        p.add(transfer);
        p.add(balance);
        p.add(back);

        return p;
    }
}

