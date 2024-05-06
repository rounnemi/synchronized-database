import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BOinterface {
    public BOinterface(String dbName) {
        JFrame frame = new JFrame(dbName);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel productLabel = new JLabel("Product Name:");
        JTextField productNameField = new JTextField();
        panel.add(productLabel);
        panel.add(productNameField);

        JLabel qtyLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();
        panel.add(qtyLabel);
        panel.add(quantityField);

        JLabel regionLabel = new JLabel("Region:");
        JTextField regionField = new JTextField();
        panel.add(regionLabel);
        panel.add(regionField);

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();
        panel.add(costLabel);
        panel.add(costField);

        JLabel amtLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();
        panel.add(amtLabel);
        panel.add(amountField);

        JLabel taxLabel = new JLabel("Tax:");
        JTextField taxField = new JTextField();
        panel.add(taxLabel);
        panel.add(taxField);

        JLabel messageLabel = new JLabel();
        messageLabel.setForeground(Color.RED);
        panel.add(messageLabel);
        panel.add(new JLabel());

        JButton addButton = new JButton("Add Product");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String product = productNameField.getText();
                String region = regionField.getText();
                int qty = 0;
                try {
                    qty = Integer.parseInt(quantityField.getText());
                } catch (NumberFormatException ex) {
                    messageLabel.setText("* Invalid Quantity");
                    return;
                }

                float cost = 0, amt = 0, tax = 0;
                try {
                    cost = Float.parseFloat(costField.getText());
                    amt = Float.parseFloat(amountField.getText());
                    tax = Float.parseFloat(taxField.getText());
                } catch (NumberFormatException ex) {
                    messageLabel.setText("* Invalid Numeric Input");
                    return;
                }

                float total = (qty * cost) + amt + (tax * (qty * cost));
                Product p = new Product( product, qty, cost, amt, tax, total, region);

                ManageData.sendToDB(p,dbName);
                ManageData.sendToHO(p);

                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("* SUCCESS: Product added");
                clearFields(productNameField, quantityField, regionField, costField, amountField, taxField);
            }
        });
        panel.add(addButton);

        JButton showButton = new JButton("Show Products");
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VisualiseData(dbName);
            }
        });
        panel.add(showButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }


}
