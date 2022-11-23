package tp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tp.appliSpring.core.entity.Compte;
import tp.appliSpring.core.service.ServiceCompte;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private ServiceCompte serviceCompte;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext application = this.getServletContext(); // application prédéfini au sein d'une page JSP
		WebApplicationContext contextSpringWeb =
		       WebApplicationContextUtils.getWebApplicationContext(application);
		this.serviceCompte = contextSpringWeb.getBean(ServiceCompte.class);
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		List<Compte> comptes = serviceCompte.rechercherTousComptes();
		for(Compte c : comptes) {
			out.println("<p>" + c.toString() + "</p>");
		}
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
