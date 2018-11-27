package tn.essat.controler;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.essat.entity.ClientBanque;
import tn.essat.entity.CompteBancaire;
import tn.essat.service.ClientBanqueServiceLocal;
import tn.essat.service.CompteBancaireServiceLocal;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CompteBancaireServiceLocal serviceCompte;

	@EJB
	private ClientBanqueServiceLocal serviceClient;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("add".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			float solde = Float.parseFloat(request.getParameter("solde"));

			serviceCompte.save(solde, cin);

		} else if ("delete".equals(request.getParameter("action"))) {
			long rib = Long.parseLong(request.getParameter("rib"));
			serviceCompte.delete(rib);

			return;

		} else if ("edit".equals(request.getParameter("action"))) {
			long rib = Long.parseLong(request.getParameter("rib"));
			CompteBancaire compte = serviceCompte.getById(rib);
			request.setAttribute("compte", compte);

			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
			return;
		} else if ("update".equals(request.getParameter("action"))) {
			long rib = Long.parseLong(request.getParameter("rib"));
			String client = request.getParameter("client");
			float solde = Float.parseFloat(request.getParameter("solde"));

			CompteBancaire compte = new CompteBancaire(solde, null);
			compte.setRib(rib);

			serviceCompte.update(compte);

		}

		request.setAttribute("comptes", serviceCompte.getAll());

		RequestDispatcher dispatcher = request.getRequestDispatcher("comptes.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
