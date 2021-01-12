package com.actitime.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.generics.WebDriverCommonLib;
import com.actitime.objectrepository.EnterTimeTrackPage;

import com.actitime.objectrepository.TaskListPage;

@Listeners(com.actitime.generics.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	@Test
	public static void createCustomer() throws IOException, InterruptedException {
		/*
		 * WebDriverCommonLib l1 = new WebDriverCommonLib(); l1.WaitForElement(driver);
		 */
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		// click on the task
		e.getTaskbar().click();
		// Create object of tasklistpage
		TaskListPage t = new TaskListPage(driver);
		// clickonaddnew
		t.getAddnew().click();
		// clickonaddnewcustomer
		t.getAddnewcustomer().click();
		// to pass the value of excel to webelement, create object of filelib
		FileLib g = new FileLib();
		// get customer name and customer description from excel file
		String cn = g.getPropertyExcel("createCustomer", 1, 5);
		String cd = g.getPropertyExcel("createCustomer", 1, 6);
		// send cn to the webelement
		t.getCustomername().sendKeys(cn);
		// send cd to the webelement
		t.getCustomerdescription().sendKeys(cd);
		// click on select dropdown
		t.getCustomerdropdown().click();
		// get the placeholder and write our compny
		t.getPlaceholder().sendKeys("Our");
		// click on our compny

		t.getSelectourcompany().click();
		// click on createcustomerbutton
		t.getCreatecustomerbutton().click();
		// explicit wait
		WebDriverCommonLib l = new WebDriverCommonLib();
		l.WaitForElement(driver, t.getVerify(), "title", cn);
		// take text in variable to verify
		String n = t.getVerify().getText();
		/*
		 * System.out.println(cn +" original"); System.out.println(n +" not original");
		 */
		Assert.assertEquals(n, cn);
		if (n.equals(cn)) {
			g.SetPropertyExcel("pass", "createCustomer", 1, 7);
		} else {
			g.SetPropertyExcel("fail", "createCustomer", 1, 7);
		}
	}

	/*
	 * @Test(dataProvider = "logInwrong") public static void
	 * logInwrongcredential(String un, String pw) {
	 * 
	 * }
	 * 
	 * @DataProvider public Object[][] logInwrong() { Object[][] obj = new
	 * Object[2][2]; obj[0][0] = "admin1"; obj[0][1] = "manager1"; obj[1][0] =
	 * "admin2"; obj[1][1] = "manager2"; return obj; }
	 */

}
