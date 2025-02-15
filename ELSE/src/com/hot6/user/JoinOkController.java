package com.hot6.user;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hot6.Execute;
import com.hot6.Result;
import com.hot6.user.dao.UserDAO;
import com.hot6.user.vo.UserVO;

public class JoinOkController implements Execute{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException {
		// 500 뜨는데 한글 꺠져서 넣음
		req.setCharacterEncoding("utf-8");
		
		UserDAO userDAO = new UserDAO();
		Result result = new Result();
		HttpSession session = req.getSession();
		
		session.setAttribute("userName", req.getParameter("userName"));
		session.setAttribute("userPhoneNum", req.getParameter("userPhoneNum"));
		session.setAttribute("userPassword", req.getParameter("userPassword"));
		
		result.setPath(req.getContextPath() + "/user/termsOfService.us");
		
		return result;
	}
}

//https://creamilk88.tistory.com/154
//insert 할때, 생성자로 정보 다 떄려박기?