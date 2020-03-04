import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JButton  btnCalculate;
	DecimalFormat decimalFormat = new DecimalFormat("#.######");
	public void InitializeComponent() {
		JFrame jFrame = new JFrame("CaloriesCalculator");
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


		JPanel panelRadio = initPanelRadio();


		JPanel panelHeight = initPanelHeight();


		JPanel panelWeight = initPanelWeight();


		JPanel panelAge = initPanelAge();

		JPanel panelCalc = initPanelCalc();

		JPanel panalCalories = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panalCalories.add(new JLabel("Recommended Daily Amount:"));
		txtCalories = new JTextField(8);
		panalCalories.add(txtCalories);
		
		Box vBox = Box.createVerticalBox();
		vBox.add(panelRadio);
		vBox.add(panelHeight);
		vBox.add(panelWeight);
		vBox.add(panelAge);
		vBox.add(panelCalc);
		vBox.add(panalCalories);		
		
		jFrame.setContentPane(vBox);
		jFrame.pack();
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}

	private JPanel initPanelCalc() {
		JPanel panelCalc = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Calculate();
			}

		});
		panelCalc.add(btnCalculate);
		return panelCalc;
	}

	private JPanel initPanelAge() {
		JPanel panelAge = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelAge.add(new JLabel("      Age:"));
		txtAge = new JTextField("12",8);
		panelAge.add(txtAge);
		panelAge.add(new JLabel("year"));
		return panelAge;
	}

	private JPanel initPanelWeight() {
		JPanel panelWeight = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelWeight.add(new JLabel("Weight:"));
		txtWeight = new JTextField("110",8);
		panelWeight.add(txtWeight);
		panelWeight.add(new JLabel("lb"));
		return panelWeight;
	}

	private JPanel initPanelHeight() {
		JPanel panelHeight = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelHeight.add(new JLabel(" Height:"));
		txtFeet = new JTextField("5",8);
		panelHeight.add(txtFeet);
		panelHeight.add(new JLabel("ft"));
		txtInches = new JTextField("1",8);
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

	private void Calculate() {	
		if (rbtnMale.isSelected()) 
		{			
			txtCalories.setText(decimalFormat.format(66
					 + (6.3 *  Double.valueOf(txtWeight.getText()))
					 + (12.9 * ((Double.valueOf(txtFeet.getText()) * 12)
					 + Double.valueOf(txtInches.getText())))
					 -(6.8 * Double.valueOf(txtAge.getText()))));
		}
		else {
			txtCalories.setText(decimalFormat.format(655
			 + (4.3 *  Double.valueOf(txtWeight.getText()))
			 + (4.7 * ((Double.valueOf(txtFeet.getText()) * 12)
			 + Double.valueOf(txtInches.getText())))
			 -(4.7 * Double.valueOf(txtAge.getText()))));			
		}
	}
	
	
	public static void main(String[] args) {
		CaloriesCalculator cc = new CaloriesCalculator();
		cc.InitializeComponent();
	}
}
