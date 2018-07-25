package com.bstek.urule.springboot;

import com.bstek.urule.TT.Invoke;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jacky.gao
 * @since 2016年10月12日
 */
@WebServlet(name = "TestServlet",urlPatterns = "/fire")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 9155627652423910928L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Invoke.doBatchTest();
		}catch (Exception e){
			//
		}
		resp.getWriter().print("hello word");
		resp.getWriter().flush();
		resp.getWriter().close();
	}
}
