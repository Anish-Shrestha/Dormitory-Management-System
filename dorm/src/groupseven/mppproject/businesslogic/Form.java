package groupseven.mppproject.businesslogic;

import java.time.LocalDate;

public class Form {
	private int formId;
	private LocalDate filledDate;
	private String formType;
	
	Form(int formId, LocalDate filledDate, String formType){
		this.formId = formId;
		this.filledDate = filledDate;
		this.formType = formType;
	}
}
