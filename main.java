import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.io.FileWriter; 
import java.io.FileReader;
import java.io.File; 
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class Frame
    extends JFrame
    implements ActionListener {
        public static final long serialVersionUID = 1L;
        private Container container;
        private JLabel divider;
        private JTextField custName;
        private JLabel textName;
        private JLabel textOrders;
        private JLabel textLargeWash;
        private JComboBox<String> largeWash;
        private JLabel textDry30;
        private JComboBox<String> dry30;
        private JLabel textDry40;
        private JComboBox<String> dry40;
        private JLabel textDry50;
        private JComboBox<String> dry50;
        private JLabel textDry60;
        private JComboBox<String> dry60;
        private JLabel textSmallWash;
        private JComboBox<String> smallWash;
        private JLabel textBags;
        private JComboBox<String> bags;
        private JLabel textPowder;
        private JComboBox<String> powder;
        private JLabel textExtraFee;
        private JTextField extraFee;
        private JLabel textNotes;
        private JTextField notes;
        private String textFont = "Arial";
        private JButton record;
        private JButton end;
        private JTextArea receipt;
        private int sumCost;

        private String lw[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        private String d30[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        private String d40[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        private String d50[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        private String d60[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        private String sw[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        private String b[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        private String p[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

        public Frame() {
            setTitle("Kapai Laundromat");
            setBounds(300, 90, 900, 600);
            setDefaultCloseOperation(HIDE_ON_CLOSE);
            setResizable(false);

            container = getContentPane();
            container.setLayout(null);

            //Customer Name
            textName = new JLabel("Name");
            textName.setFont(new Font(textFont, Font.PLAIN, 20));
            textName.setSize(100, 20);
            textName.setLocation(100, 50);
            container.add(textName);

            custName = new JTextField();
            custName.setFont(new Font(textFont, Font.PLAIN, 15));
            custName.setSize(190, 20);
            custName.setLocation(200, 50);
            container.add(custName);

            //Customer Orders
            textOrders = new JLabel("Orders");
            textOrders.setFont(new Font(textFont, Font.PLAIN, 20));
            textOrders.setSize(100, 20);
            textOrders.setLocation(100, 100);
            container.add(textOrders);

            divider = new JLabel("------------------------------------------------------------------------");
            divider.setSize(300, 20);
            divider.setLocation(100, 120);
            container.add(divider);

            //Wash
            textSmallWash = new JLabel("SW");
            textSmallWash.setFont(new Font(textFont, Font.PLAIN, 20));
            textSmallWash.setSize(100, 20);
            textSmallWash.setLocation(100, 150);
            container.add(textSmallWash);

            smallWash = new JComboBox<String>(sw);
            smallWash.setFont(new Font(textFont, Font.PLAIN, 15));
            smallWash.setSize(50, 20);
            smallWash.setLocation(150, 150);
            container.add(smallWash);

            textLargeWash = new JLabel("LW");
            textLargeWash.setFont(new Font(textFont, Font.PLAIN, 20));
            textLargeWash.setSize(100, 20);
            textLargeWash.setLocation(290, 150);
            container.add(textLargeWash);

            largeWash = new JComboBox<String>(lw);
            largeWash.setFont(new Font(textFont, Font.PLAIN, 15));
            largeWash.setSize(50, 20);
            largeWash.setLocation(340, 150);
            container.add(largeWash);

            //Dry
            textDry30 = new JLabel("D30");
            textDry30.setFont(new Font(textFont, Font.PLAIN, 20));
            textDry30.setSize(100, 20);
            textDry30.setLocation(100, 200);
            container.add(textDry30);

            dry30 = new JComboBox<String>(d30);
            dry30.setFont(new Font(textFont, Font.PLAIN, 15));
            dry30.setSize(50, 20);
            dry30.setLocation(150, 200);
            container.add(dry30);

            textDry40 = new JLabel("D40");
            textDry40.setFont(new Font(textFont, Font.PLAIN, 20));
            textDry40.setSize(100, 20);
            textDry40.setLocation(290, 200);
            container.add(textDry40);

            dry40 = new JComboBox<String>(d40);
            dry40.setFont(new Font(textFont, Font.PLAIN, 15));
            dry40.setSize(50, 20);
            dry40.setLocation(340, 200);
            container.add(dry40);

            textDry50 = new JLabel("D50");
            textDry50.setFont(new Font(textFont, Font.PLAIN, 20));
            textDry50.setSize(100, 20);
            textDry50.setLocation(100, 250);
            container.add(textDry50);

            dry50 = new JComboBox<String>(d50);
            dry50.setFont(new Font(textFont, Font.PLAIN, 15));
            dry50.setSize(50, 20);
            dry50.setLocation(150, 250);
            container.add(dry50);

            textDry60 = new JLabel("D60");
            textDry60.setFont(new Font(textFont, Font.PLAIN, 20));
            textDry60.setSize(100, 20);
            textDry60.setLocation(290, 250);
            container.add(textDry60);

            dry60 = new JComboBox<String>(d60);
            dry60.setFont(new Font(textFont, Font.PLAIN, 15));
            dry60.setSize(50, 20);
            dry60.setLocation(340, 250);
            container.add(dry60);

            //Bags
            textBags = new JLabel("Bags");
            textBags.setFont(new Font(textFont, Font.PLAIN, 20));
            textBags.setSize(100, 20);
            textBags.setLocation(100, 300);
            container.add(textBags);

            bags = new JComboBox<String>(b);
            bags.setFont(new Font(textFont, Font.PLAIN, 15));
            bags.setSize(50, 20);
            bags.setLocation(150, 300);
            container.add(bags);

            //Powder
            textPowder = new JLabel("P");
            textPowder.setFont(new Font(textFont, Font.PLAIN, 20));
            textPowder.setSize(150, 20);
            textPowder.setLocation(290, 300);
            container.add(textPowder);

            powder = new JComboBox<String>(p);
            powder.setFont(new Font(textFont, Font.PLAIN, 15));
            powder.setSize(50, 20);
            powder.setLocation(340, 300);
            container.add(powder);

            //Extra Cost
            textExtraFee = new JLabel("Extra Fee");
            textExtraFee.setFont(new Font(textFont, Font.PLAIN, 20));
            textExtraFee.setSize(100, 20);
            textExtraFee.setLocation(100, 350);
            container.add(textExtraFee);

            extraFee = new JTextField("0");
            extraFee.setFont(new Font(textFont, Font.PLAIN, 15));
            extraFee.setSize(50, 20);
            extraFee.setLocation(200, 350);
            container.add(extraFee);

            //Extra Notes
            textNotes = new JLabel("Notes/Comments");
            textNotes.setFont(new Font(textFont, Font.PLAIN, 20));
            textNotes.setSize(200, 20);
            textNotes.setLocation(100, 400);
            container.add(textNotes);

            notes = new JTextField();
            notes.setFont(new Font(textFont, Font.PLAIN, 15));
            notes.setSize(300, 20);
            notes.setLocation(100, 430);
            container.add(notes);
            
            //Submit Button
            record = new JButton("Record");
            record.setFont(new Font(textFont, Font.PLAIN, 20));
            record.setSize(300, 40);
            record.setLocation(100, 480);
            record.addActionListener(this);
            container.add(record);

            //Close store button
            end = new JButton("Close store");
            end.setFont(new Font(textFont, Font.PLAIN, 20));
            end.setSize(200, 40);
            end.setLocation(580, 480);
            end.addActionListener(this);
            container.add(end);

            //Receipt
            receipt = new JTextArea();
            receipt.setFont(new Font(textFont, Font.PLAIN, 15));
            receipt.setSize(200, 380);
            receipt.setLocation(580, 40);
            receipt.setLineWrap(true);
            receipt.setEditable(false);
            container.add(receipt);

            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == record && !(custName.getText().equals(""))) {
                String strName = "Name: " + custName.getText();
                String strSW = "";
                String strLW = "";
                String strd30 = "";
                String strd40 = "";
                String strd50 = "";
                String strd60 = "";
                String strBags = "";
                String strPowder = "";
                String strExtraFee = "";
                String strNotes = "";
                String defaultValue = "0";
                int totalCost = 0;
                if ((String)smallWash.getSelectedItem() != defaultValue) {
                    strSW = "\nSW × " + (String)smallWash.getSelectedItem();
                    totalCost += Integer.parseInt((String)smallWash.getSelectedItem()) * 4;
                }
                if ((String)largeWash.getSelectedItem() != defaultValue) {
                    strLW = "\nLW × " + (String)largeWash.getSelectedItem();
                    totalCost += Integer.parseInt((String)largeWash.getSelectedItem()) * 9;
                }
                if ((String)dry30.getSelectedItem() != defaultValue) {
                    strd30 = "\nD30 × " + (String)dry30.getSelectedItem();
                    totalCost += Integer.parseInt((String)dry30.getSelectedItem()) * 5;
                }
                if ((String)dry40.getSelectedItem() != defaultValue) {
                    strd40 = "\nD40 × " + (String)dry40.getSelectedItem();
                    totalCost += Integer.parseInt((String)dry40.getSelectedItem()) * 7;
                }
                if ((String)dry50.getSelectedItem() != defaultValue) {
                    strd50 = "\nD50 × " + (String)dry50.getSelectedItem();
                    totalCost += Integer.parseInt((String)dry50.getSelectedItem()) * 8.5;
                }
                if ((String)dry60.getSelectedItem() != defaultValue) {
                    strd60 = "\nD60 × " + (String)dry60.getSelectedItem();
                    totalCost += Integer.parseInt((String)dry60.getSelectedItem()) * 10;
                }
                if ((String)bags.getSelectedItem() != defaultValue) {
                    strBags = "\nBags × " + (String)bags.getSelectedItem();
                    totalCost += Integer.parseInt((String)bags.getSelectedItem()) * 1.50;
                }
                if ((String)powder.getSelectedItem() != defaultValue) {
                    strPowder = "\nP × " + (String)powder.getSelectedItem();
                    totalCost += Integer.parseInt((String)powder.getSelectedItem()) * 0.50;
                }
                if (!extraFee.getText().equals("0")) {
                    strExtraFee = "\nExtra Fee = $" + (String)extraFee.getText();
                    totalCost += Integer.parseInt((String)dry30.getSelectedItem());
                }
                if (!(notes.getText().equals(""))) {
                    strNotes = "\nNotes/Comments = " + (String)notes.getText();
                }
                receipt.setText(strName + strSW + strd30 + strLW + strd40 + strd50 + strd60 + strBags + strPowder + strExtraFee + strNotes + "\nTotal cost is $" + totalCost);
                sumCost += totalCost;
                //Exports files in a format into excel
                try {
                    //Formats the file name into year/month/day/day of the week
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd-E");
                    Date dateobj = new Date();
                    String fileName = df.format(dateobj) + ".xls";
                    //Creates file if file does not exist
                    File file = new File(fileName);
                    if(file.createNewFile());

                    FileReader read = new FileReader(fileName);
                    FileWriter write = new FileWriter(fileName, true);
                    if (read.read() == -1) {
                        write.append("Name \t\tSW \tLW \tD30 \tD40 \tD50 \tD60 \tP \tBags \tExtra \tCost \t\t\tNotes \n");
                    }
                    read.close();
                    write.append(
                        custName.getText() + "\t\t" + 
                        (String)smallWash.getSelectedItem() + "\t" + 
                        (String)largeWash.getSelectedItem() + "\t" +
                        (String)dry30.getSelectedItem() + "\t" +
                        (String)dry40.getSelectedItem() + "\t" +
                        (String)dry50.getSelectedItem() + "\t" +
                        (String)dry60.getSelectedItem() + "\t" +
                        (String)powder.getSelectedItem() + "\t" +
                        (String)bags.getSelectedItem() + "\t$" +
                        extraFee.getText() + "\t$" +
                        totalCost + "\t\t\t" +
                        notes.getText() + "\n");
                    write.close();
                    System.out.println("Successfully wrote to the file.");
                  } catch (IOException ioe) {
                    System.out.println("An error occurred.");
                    ioe.printStackTrace();
                  }
                //Reset the software to default values
                custName.setText("");
                smallWash.setSelectedIndex(0);
                largeWash.setSelectedIndex(0);
                dry30.setSelectedIndex(0);
                dry40.setSelectedIndex(0);
                dry50.setSelectedIndex(0);
                dry60.setSelectedIndex(0);
                powder.setSelectedIndex(0);
                bags.setSelectedIndex(0);
                extraFee.setText("0");
                notes.setText("");
            } else if (e.getSource() == record && custName.getText().equals("")){
                receipt.setText("Please input a name");
            }
            if (e.getSource() == end && sumCost != 0) {
                try {
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd-E");
                    Date dateobj = new Date();
                    String fileName = df.format(dateobj) + ".xls";
                    FileWriter write = new FileWriter(fileName, true);
                    write.append("\t\t\t\t\t\t\t\t\t\t\t\tTotal\t$" + sumCost);
                    write.close();
                    System.exit(0);
                } catch (IOException ioe) {
                        System.out.println("An error occurred.");
                        ioe.printStackTrace();
                    }
            } else if (e.getSource() == end && sumCost == 0) {
                receipt.setText("There are no customers savedCannot total profits");
            }
        }
    }


class Kapai{
    public static void main(String[] args) {
        Frame f = new Frame();
    }    
}