package member_service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CommandProcess;

public class mbdeleteAction implements CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		return "/member/mbdelete.jsp";
		
	}
}
