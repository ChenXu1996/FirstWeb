import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FirstServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		Cookie cookie=null;
		String value="";
		Cookie co[]=request.getCookies();
		if(co!=null)
		for(int i=0;i<co.length;i++){
			if(co[i].getName().equals("ServletStudy")){
				value=co[i].getValue();
				cookie=co[i];
				System.out.println("Cookie found: value "+value);
				System.out.println(co[i].getMaxAge());
				//response.addCookie(cookie);//¼ÇµÃÊÔÒ»ÊÔ
			}
		}
		else{
			System.out.println("cookie not found");
			cookie=new Cookie("ServletStudy","haha");
			cookie.setMaxAge(100);
			response.addCookie(cookie);
		}
		
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("Cookie name:"+cookie.getName());
		out.println("<br>");
		out.println("Cookie maxAge:"+cookie.getMaxAge());
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		response.setContentType("text/html;charset=gb2312");
//		request.setCharacterEncoding("gb2312");
//		PrintWriter out = response.getWriter();
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.println("username:"+username+"<br>");
//		out.println("password:"+password+"<br>");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
		performTask(request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		System.out.println("servlet is inited...");
	}
	
	private void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			String pdfFileName = "1.pdf";
			String contextPath = getServletContext().getRealPath(File.separator);
			File pdfFile = new File(contextPath + pdfFileName);
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename="
			+ pdfFileName);
			response.setContentLength((int) pdfFile.length());

			FileInputStream fileInputStream = new FileInputStream(pdfFile);
			OutputStream responseOutputStream = response.getOutputStream();
			int bytes;
			while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
			}}

}
