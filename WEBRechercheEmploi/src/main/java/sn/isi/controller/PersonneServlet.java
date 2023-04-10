package sn.isi.controller;

import jakarta.ejb.EJB;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sn.isi.dao.ICVRemote;
import sn.isi.dao.IPersonneLocal;
import sn.isi.dao.IPersonneRemote;
import sn.isi.dao.IRoleRemote;
import sn.isi.entities.CV;
import sn.isi.entities.Personne;
import sn.isi.entities.Role;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Servlet implementation class PersonneServlet
 */
@WebServlet(urlPatterns = "/Personne")
public class PersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IPersonneRemote pdao;
	@EJB
	private ICVRemote cvdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("WEB-INF/personne/liste.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
	    String prenom = request.getParameter("prenom");
	    String telephone = request.getParameter("telephone");
	    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	    Date datenaiss = null;
		try {
			datenaiss = sdf.parse(request.getParameter("datenaiss"));
			System.out.println(datenaiss);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String adresse = request.getParameter("adresse");
	    String nationalite = request.getParameter("nationalite");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    Personne p = new Personne();
	    p.setAdresse(adresse);
	    p.setDatenaiss(datenaiss);
	    p.setEmail(email);
	    p.setNationalite(nationalite);
	    p.setNom(nom);
	    p.setPrenom(prenom);
	    p.setTelephone(telephone);
	    p.setPassword(password);
	    p.setRole(null);
	    HttpSession session = request.getSession();
	    try {
		    if (pdao.add(p) == 1) {
		    	try {
		            String to = p.getEmail(); // l'adresse e-mail du destinataire
		            String from = "modyndiaye416@gmail.com"; // votre adresse e-mail

		            Properties properties = System.getProperties();
		            properties.setProperty("mail.smtp.host", "smtp.gmail.com"); // le serveur SMTP que vous utilisez
		            properties.setProperty("mail.smtp.port", "587"); // le port SMTP
		            properties.setProperty("mail.smtp.starttls.enable", "true"); // utiliser TLS
		            properties.setProperty("mail.smtp.auth", "true"); // activer l'authentification

		            Authenticator auth = new Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication("modyndiaye416@gmail.com", "vzcvoovlagstelyl"); // votre adresse e-mail et votre mot de passe
		                }
		            };

		            Session sessionmail = Session.getDefaultInstance(properties, auth);
		            MimeMessage message = new MimeMessage(sessionmail);

		            message.setFrom(new InternetAddress(from));
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		            message.setSubject("Nouvelle Inscription dans YAKARLIGUEY");
		            message.setText("Bienvenue M."+p.getPrenom()+" "+p.getNom()+" dans notre plateform YAKARLIGUEY! Bonne chance :)");

		            Transport.send(message);
		        } catch (MessagingException mex) {
		            mex.printStackTrace();
		            System.out.println("erreur messagerie");
		        }
		    	System.out.println("ok");
		    	p = pdao.login(p.getEmail(), p.getPassword());
			    if(session.getAttribute("cv") != null) {
					CV cv = (CV) session.getAttribute("cv");	
					cv.setPersonne(p);
					if(cvdao.add(cv) == 1) {
						request.setAttribute("success", "Cv ajouté avec succès");
						session.setAttribute("cv", null);
					}else{
						request.setAttribute("error", "Une erreur lors de l'enregistrement du cv est survenue");
					}
				}
			    request.setAttribute("success", "Bienvenue");
				request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		    }
	    } catch (Exception e) {
	    	request.setAttribute("error", "Une erreur lors de l'enregistrement de vos informations");
		}
		doGet(request, response);
	}

}
