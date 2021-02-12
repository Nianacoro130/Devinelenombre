package packexercice3;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import packdevine.Jdevine;

/**
 * Servlet implementation class Devinservlet
 */
@WebServlet({"/index.php","*.php"})
public class Devinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Jdevine packdevine;
	private ArrayList<HttpSession> sessions;
	
	
	public void init() throws ServletException {
	    packdevine = new Jdevine();
	    sessions= new ArrayList<>();
	   
	} 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path= request.getServletPath();
		
		if(path.equals("/index.php")) {
			request.setAttribute("Jdevine", new Testdevine());
			request.getRequestDispatcher("Devine.jsp").forward(request, response);
		}
		else if (path.equals("/jedevine.php")) {
			String action=request.getParameter("cherch"); //la derniere modif
			HttpSession session =request.getSession();
			if(action.equals("Essaie")) {
				if(packdevine.isFini()==false) {
					int nombre = Integer.parseInt(request.getParameter("nombre"));
					String resultat=packdevine.chercher(nombre);
					if(session.getAttribute("Jdevine") != null) {
						Testdevine model=(Testdevine)session.getAttribute("Jdevine");
						model.setNombre(nombre);
						model.addtoHistorique(resultat);
						request.setAttribute("fini", packdevine.isFini());
						request.setAttribute("atrouver", packdevine.getAtrouver());
					}else {
						sessions.add(session);
						Testdevine model = new Testdevine();
						model.setNombre(nombre);
						model.addtoHistorique(resultat);
						session.setAttribute("Jdevine" , model);
						request.setAttribute("fini", packdevine.isFini());
						request.setAttribute("atrouver", packdevine.getAtrouver());
					            }	
					}else {
						request.setAttribute("fini", packdevine.getAtrouver());
						request.setAttribute("atrouver", packdevine.getAtrouver());
					}
					}else if (action.equals("Rejouer")) {
						if(!sessions.isEmpty() && packdevine.isFini()) {
							for(HttpSession s:sessions) {
								s.invalidate();
							}
							sessions.clear();
							packdevine.setFini(false);
							request.setAttribute("fini", packdevine.isFini());
						}
					}

		this.getServletContext().getRequestDispatcher("/Devine.jsp").forward(request, response);
		
		
		}/** fin protected*/

	}
}
