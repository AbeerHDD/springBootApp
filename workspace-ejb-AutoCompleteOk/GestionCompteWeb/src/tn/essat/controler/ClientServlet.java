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
import tn.essat.service.ClientBanqueServiceLocal;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ClientBanqueServiceLocal service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServlet() {
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
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");

			ClientBanque client = new ClientBanque(cin, nom, prenom, adresse);

			service.save(client);
		} else if ("delete".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			service.delete(cin);

			return;

		} else if ("edit".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			ClientBanque client = service.getById(cin);
			request.setAttribute("client", client);

			RequestDispatcher dispatcher = request.getRequestDispatcher("editClient.jsp");
			dispatcher.forward(request, response);
			return;
		} else if ("update".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");

			ClientBanque client = new ClientBanque(cin, nom, prenom, adresse);

			service.update(client);

		} else if ("getDto".equals(request.getParameter("action"))) {
			String dtos = service.getAll4AutoComplete();
			response.getWriter().println(dtos);
			return;
		}

		request.setAttribute("clients", service.getAll());

		RequestDispatcher dispatcher = request.getRequestDispatcher("clients.jsp");
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
