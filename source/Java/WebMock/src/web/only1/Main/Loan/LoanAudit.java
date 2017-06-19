package web.only1.Main.Loan;

import javax.servlet.annotation.WebServlet;

import web.only1.Common.AbstractLoadServlect;
import web.only1.Common.View;
import web.only1.Common.ViewResult;

/**
 * Servlet implementation class LoanAudit
 */
@WebServlet("/LoanAudit")
public class LoanAudit extends AbstractLoadServlect {
	private static final long serialVersionUID = 1L;

	public LoanAudit() {
		super();
	}

	@Override
	protected ViewResult execute() {
		return View.nativeCode("대출 심사");
	}
}