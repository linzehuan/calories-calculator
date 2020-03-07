import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.*;

public class CaloriesCalculator {

    public CaloriesCalculator(){
        initCaloriesInfo();
    }
    private JTextField txtFeet;
    private JTextField txtInches;
    private JTextField txtWeight;
    private JTextField txtAge;
    private JTextField txtCalories;
    DecimalFormat decimalFormat = new DecimalFormat("#.######");
    private ButtonGroup btnGroup;

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
        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(event -> Calculate());
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
        btnGroup = new ButtonGroup();

        sexCaloriesInfo.forEach((s, doubles) -> {
            JRadioButton sexButton = new JRadioButton(s);
            btnGroup.add(sexButton);
            panelRadio.add(sexButton);
        });
        btnGroup.getElements().nextElement().setSelected(true);
        return panelRadio;
    }


    private final LinkedHashMap<String, CalorieInfo> sexCaloriesInfo = new LinkedHashMap<>();

    private void initCaloriesInfo() {
        sexCaloriesInfo.put("Male", new CalorieInfo(66, 6.3, 12.9, 6.8));
        sexCaloriesInfo.put("Female", new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put("x1", new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put("x2", new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put("x3", new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put("x4", new CalorieInfo(655, 4.3, 4.7, 4.7));
        sexCaloriesInfo.put("x5", new CalorieInfo(655, 4.3, 4.7, 4.7));
    }


    public double calculateCalories(Double weight, Double inches, Double feet, Double age, String selectSex) {
        CalorieInfo caloriesInfo = sexCaloriesInfo.get(selectSex);
        return caloriesInfo.calculate(weight, inches, feet, age);
    }

    private void Calculate() {
        Double weight = Double.valueOf(txtWeight.getText());
        Double feet = Double.valueOf(txtFeet.getText());
        Double inches = Double.valueOf(txtInches.getText());
        Double age = Double.valueOf(txtAge.getText());

        String selectSex = getSelectedSex();
        double calories = calculateCalories(weight, inches, feet, age, selectSex);
        txtCalories.setText(decimalFormat.format(calories));
    }

    private String getSelectedSex() {
        Enumeration<AbstractButton> elements = btnGroup.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }




    public static void main(String[] args) {
        CaloriesCalculator cc = new CaloriesCalculator();
        cc.InitializeComponent();
    }

    public String format(double calculateCalories) {
        return decimalFormat.format(calculateCalories);
    }
}
