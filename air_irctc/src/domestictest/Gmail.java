package domestictest;

import com.air_irctc.GmailTestPage;
import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.annotations.UiElement;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;

import groovyjarjarantlr.CommonAST;

import com.qmetry.qaf.automation.util.Randomizer;

public class Gmail extends BaseFormDataBean {
	
	
	@Randomizer(prefix="rahul",type=RandomizerTypes.LETTERS_ONLY,length=0)
	@UiElement(fieldLoc="text.firstname",order=1)
	private String firstname;
	
	@Randomizer(prefix="gandhi",type=RandomizerTypes.LETTERS_ONLY,length=0)
	@UiElement(fieldLoc="text.lastname",order=2)
	private String lastname;
	
	@Randomizer(prefix="rahulgandhi123",type=RandomizerTypes.MIXED,length=0)
	@UiElement(fieldLoc="text.gmailaddress",order=3)
	private String emailadress;
	
	@Randomizer(prefix="abcde123",type=RandomizerTypes.MIXED,length=0)
	@UiElement(fieldLoc="password.passwd",order=4)
	private String password;
	
	@Randomizer(prefix="abcde123",type=RandomizerTypes.MIXED,length=0)
	@UiElement(fieldLoc="password.passwdagain",order=5)
	private String passwordagain;
	
	
}
