package pkgApp.controller;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField TotalSaved;
	@FXML
	private TextField SaveEachMonth;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturn;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TotalSaved.setDisable(true);
		SaveEachMonth.setDisable(true);
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		//	TODO: Clear all the text inputs
		txtYearsToWork.setText("");
		txtAnnualReturn.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		TotalSaved.setText("");
		SaveEachMonth.setText("");
		return;
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		//	TODO: Call AmountToSave and TotalAmountSaved and populate
		try {
			int iYearsToWork = Integer.parseInt(txtYearsToWork.getText());
			double dAnnualReturnWorking = Double.parseDouble(txtAnnualReturn.getText());
			int iYearsRetired = Integer.parseInt(txtYearsRetired.getText());
			double dAnnualReturnRetired = Double.parseDouble(txtAnnualReturnRetired.getText());
			double dRequiredIncome = Double.parseDouble(txtRequiredIncome.getText());
			double dMonthlySSI = Double.parseDouble(txtMonthlySSI.getText());
		}
		catch (NumberFormatException e) {
			txtYearsToWork.setText("Please clear and enter an integer");
			txtAnnualReturn.setText("Please clear and enter a double");
			txtYearsRetired.setText("Please clear and enter an integer");
			txtAnnualReturnRetired.setText("Please clear and enter a double");
			txtRequiredIncome.setText("Please clear and enter a double");
			txtMonthlySSI.setText("Please clear and enter a double");
		}
		
		finally {
			int iYearsToWork = Integer.parseInt(txtYearsToWork.getText());
			double dAnnualReturnWorking = Double.parseDouble(txtAnnualReturn.getText());
			int iYearsRetired = Integer.parseInt(txtYearsRetired.getText());
			double dAnnualReturnRetired = Double.parseDouble(txtAnnualReturnRetired.getText());
			double dRequiredIncome = Double.parseDouble(txtRequiredIncome.getText());
			double dMonthlySSI = Double.parseDouble(txtMonthlySSI.getText());
			
			Retirement r = new Retirement(iYearsToWork, dAnnualReturnWorking, iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
		
			TotalSaved.setDisable(false);
			SaveEachMonth.setDisable(false);
			String month = String.format("%.2f", r.AmountToSave());
			String total = String.format("%.2f", r.TotalAmountSaved());
			SaveEachMonth.setText(month);
			TotalSaved.setText(total);
			TotalSaved.setDisable(true);
			SaveEachMonth.setDisable(true);
		}
		
	}
	
}
