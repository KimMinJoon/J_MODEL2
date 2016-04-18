package j_meetboard_service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j_meetboard.J_MeetBoard;
import j_meetboard.J_MeetBoardDao;
import service.CommandProcess;

public class WriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		String ip = request.getRemoteAddr();//아이피주소를 남기기위해 씀
		J_MeetBoard meetboard = new J_MeetBoard();
		meetboard.setM_no(Integer.parseInt(request.getParameter("m_no")));
		meetboard.setBrd_content(request.getParameter("brd_content"));
		meetboard.setBrd_subject(request.getParameter("brd_subject"));
		meetboard.setMc_code(request.getParameter("mc_code"));
		meetboard.setL_code(request.getParameter("l_code"));
		meetboard.setBrd_ip(ip);
		J_MeetBoardDao bd = J_MeetBoardDao.getInstance();
		int result = bd.insert(meetboard);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
		
		return "/meetBoard/write.jsp";
	}

}
