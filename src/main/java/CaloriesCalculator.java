import java.awt.FlowLayout;
import java.text.DecimalFormat;

import javax.swing.*;

public class CaloriesCalculator {

    private JRadioButton rbtnMale;
    private JRadioButton rbtnFemale;
    private JTextField txtFeet;
    private JTextField txtInches;
    private JTextField txtWeight;
    private JTextField txtAge;
    private JTextField txtCalories;
    private JButton btnCalculate;
    DecimalFormat decimalFormat = new DecimalFormat("#.######");

    public void InitializeComponent() {
        String title = "CaloriesCalculator";
        JFrame jFrame = new JFrame(title);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Box vBox = Box.createVerticalBox();
        vBox.add(initPanelRadio());
        vBox.add(initPanelHeight());
        vBox.add(initPanelWeight());
        vBox.add(initPanelAge());
        vBox.add(initPanelCalc());
        vBox.add(initPanelCalories());

        jFrame.setContentPane(vBox);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    private JPanel initPanelCalories() {
        JPanel panelCalories = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCalories.add(new JLabel("Recommended Daily Amount:"));
        txtCalories = new JTextField(8);
        panelCalories.add(txtCalories);
        return panelCalories;
    }

    private JPanel initPanelCalc() {
        JPanel panelCalc = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnCalculate = new JButton("calculate");
        btnCalculate.addActionListener(event -> calculate());
        panelCalc.add(btnCalculate);
        return panelCalc;
    }

    private JPanel initPanelAge() {
        JPanel panelAge = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelAge.add(new JLabel("      Age:"));
        txtAge = new JTextField("12", 8);
        panelAge.add(txtAge);
        panelAge.add(new JLabel("year"));
        return panelAge;
    }

    private JPanel initPanelWeight() {
        JPanel panelWeight = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelWeight.add(new JLabel("Weight:"));
        txtWeight = new JTextField("110", 8);
        panelWeight.add(txtWeight);
        panelWeight.add(new JLabel("lb"));
        return panelWeight;
    }

    private JPanel initPanelHeight() {
        JPanel panelHeight = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHeight.add(new JLabel(" Height:"));
        txtFeet = new JTextField("5", 8);
        panelHeight.add(txtFeet);
        panelHeight.add(new JLabel("ft"));
        txtInches = new JTextField("1", 8);
        panelHeight.add(txtInches);
        panelHeight.add(new JLabel("in"));
        return panelHeight;
    }

    private JPanel initPanelRadio() {
        JPanel panelRadio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup btnGroup = new ButtonGroup();
        rbtnMale = new JRadioButton("Male");
        rbtnFemale = new JRadioButton("Female");
        rbtnMale.setSelected(true);
        btnGroup.add(rbtnMale);
        btnGroup.add(rbtnFemale);
        panelRadio.add(rbtnMale);
        panelRadio.add(rbtnFemale);
        return panelRadio;
    }

    private void calculate() {
        Double weight = Double.valueOf(txtWeight.getText());
        Double feet = Double.valueOf(txtFeet.getText());
        Double inches = Double.valueOf(txtInches.getText());
        Double age = Double.valueOf(txtAge.getText());
        boolean isMate = rbtnMale.isSelected();
        double calories = calculateCalories(isMate, weight, feet, inches, age);
        txtCalories.setText(decimalFormat.format(calories));

    }

    public String format(double doubleValue) {
        return decimalFormat.format(doubleValue);
    }

    public double calculateCalories(boolean isMate, Double weight, Double feet, Double inches, Double age) {
        double calories;
        if (isMate) {
            calories = new Person(weight, feet, inches, age).mateCalculate(weight, feet, inches, age);
        } else {
            calories = new Person(weight, feet, inches, age).femaleCalculate(weight, feet, inches, age);
        }
        return calories;
    }


    public static void main(String[] args) {
        CaloriesCalculator cc = new CaloriesCalculator();
        cc.InitializeComponent();
    }
}
