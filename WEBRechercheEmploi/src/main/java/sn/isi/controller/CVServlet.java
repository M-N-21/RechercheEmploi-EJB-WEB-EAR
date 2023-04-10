package sn.isi.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sn.isi.dao.ICVRemote;
import sn.isi.entities.CV;
import sn.isi.entities.Personne;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Servlet implementation class CVServlet
 */
public class CVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	ICVRemote cvdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CVServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		if(request.getParameter("page").equals("liste"))
			request.getRequestDispatcher("WEB-INF/cv/liste.jsp").forward(request, response);
		else {
			List<CV> cvs = cvdao.list(new CV());
			List<CV> listecv = cvdao.list(new CV());
			if(session.getAttribute("user") != null) {
				/*Personne p = ((Personne) session.getAttribute("user"));
				for (CV cv : cvs) {
					if(cv.getPersonne().getId() == p.getId()) {
						System.out.println(cv.getExperience());
						listecv.add(cv);
						
					}
				}*/
				request.setAttribute("listecv", listecv);
			}else {
				request.setAttribute("error", "vous devez vous connecter d'abord");
				request.getRequestDispatcher("WEB-INF/login/liste.jsp").forward(request, response);
			}
			
			
			request.getRequestDispatcher("WEB-INF/cv/all.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CV cv = new CV();
		cv.setTitre(request.getParameter("titre"));
		cv.setProfil(request.getParameter("profil"));
		cv.setDivers(request.getParameter("divers"));
		cv.setEtude(request.getParameter("etude"));
		cv.setExperience(request.getParameter("experience"));
		cv.setCompetence(request.getParameter("competence"));
		cv.setLangue(request.getParameter("langue"));
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			Personne p = (Personne) session.getAttribute("user");
			cv.setPersonne(p);
			if(cvdao.add(cv) == 1) {
				request.setAttribute("success", "Cv ajouté avec succès");
			}else{
				request.setAttribute("error", "Une erreur est survenue");
			}
		}else{
			session.setAttribute("cv", cv);
			System.out.println("ok");
			request.getRequestDispatcher("WEB-INF/login/liste.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
