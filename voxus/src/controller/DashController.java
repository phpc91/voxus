package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import entidades.Task;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/dash")
public class DashController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TaskDAO dao = TaskDAO.getInstance();

    public DashController() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Task> tasks = dao.getAllTasks();
		String[] nomesTasks = new String[tasks.size()];
		
		for(int i=0; i<nomesTasks.length; i++) {
			nomesTasks[i] = tasks.get(i).getTitulo();
		}
		
		request.setAttribute("nomesTasks", nomesTasks);
		request.getRequestDispatcher("/dash.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
