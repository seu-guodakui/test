package com.cn.KUI.services.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.KUI.services.Action.ActionJson;
import com.cn.KUI.services.exception.BusinessException;

import net.sf.json.JSONException;

public class JsonServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
			String pathname = request.getServletPath();
			System.out.println("pathname  "+ pathname);
			
			int index = pathname.indexOf(".");
			String key = pathname.substring(1,index);
			System.out.println(key);
			
			//create jsonbean
			BeanManager manager = new BeanManager();
			String className = manager.getClass(key);
			System.out.println(className);
			ActionJson action = manager.createJsonAction(className);

			
			String json = new String (request.getParameter("params").getBytes("iso-8859-1"),"utf-8");
			System.out.println("params: "+json);
			try {
				String resp = action.execute(json);
				System.out.print(resp);
				
				PrintWriter pw = response.getWriter();
				pw.println(resp);
				pw.close();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			
			
		/*
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>nihao</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("test  ahhdhisadcjni  "+getInitParameter("param_name"));
			out.println("</body>");
			out.println("</html>");		
			
		*/
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		super.init();
		// Put your code here
	}


}
