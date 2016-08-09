

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StockServlet
 */
@WebServlet("/StockServlet")
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AtomicInteger count = new AtomicInteger(0);
    /**
     * Default constructor. 
     */
    public StockServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Request in thread: " + count.incrementAndGet());
		try{
			Thread.sleep(600000);
		} catch (InterruptedException r) {}
		response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();
        out.print("Hello World!");
        out.close();
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
	}

}
