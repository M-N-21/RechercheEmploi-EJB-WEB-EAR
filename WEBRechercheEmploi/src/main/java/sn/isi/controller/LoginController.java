package sn.isi.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sn.isi.dao.ICVRemote;
import sn.isi.dao.IPersonneRemote;
import sn.isi.entities.CV;
import sn.isi.entities.Personne;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    IPersonneRemote pdao;
	@EJB
	ICVRemote cvdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("WEB-INF/login/liste.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Personne p = pdao.login(request.getParameter("email"), request.getParameter("pass"));
		HttpSession session = request.getSession();
		if (p != null) {
			session.setAttribute("user", p);
			if(session.getAttribute("cv") != null) {
				CV cv = (CV) session.getAttribute("cv");	
				cv.setPersonne(p);
				if(cvdao.add(cv) == 1) {
					request.setAttribute("success", "Cv ajouté avec succès");
					session.setAttribute("cv", null);
				}else{
					request.setAttribute("error", "Une erreur est survenue");
				}
			}
			request.setAttribute("success", "Bienvenue");
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Email et/ou mot de passe incorrect");
			doGet(request, response);
		}
	}

}
