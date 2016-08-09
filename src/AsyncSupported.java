

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsyncSupported
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AsyncSupported" })
public class AsyncSupported extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ExecutorService serv = Executors.newFixedThreadPool(5);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsyncSupported() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		final AsyncContext context = request.startAsync();
		
		Callable<String> c = new Callable<String>() {

			@Override
			public String call() throws Exception {
				context.getRequest().setAttribute("asyncdata", "Hello World");
				//context.dispatch("/asyncdone.jsp");
				context.complete();
				return "Hello World";
			}
		};
		serv.submit(c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
