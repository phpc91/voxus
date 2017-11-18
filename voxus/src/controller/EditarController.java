package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.TaskDAO;
import entidades.Task;

/**
 * Servlet implementation class EditarController
 */
@WebServlet("/editar")
@MultipartConfig
public class EditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Task task;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeTask = (String) request.getSession().getAttribute("nomeTask");
		request.getSession().removeAttribute("nomeTask");
		
		task = TaskDAO.getInstance().getTaskPorNome(nomeTask);
		request.setAttribute("nomeTask", task.getTitulo());
		
		request.getRequestDispatcher("/editar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO disponibilizar formulário de *criação* para edição de task
		String nome = request.getParameter("titulo");
//		String desc = request.getParameter("descricao");
//		int prioridade = Integer.parseInt(request.getParameter("prioridade"));
		
		TaskDAO.getInstance().editTask(task.getTitulo(), nome); //nome original, nome novo
		
//	    List<Part> fileParts = 
//	    		request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());
//
//	    for (Part filePart : fileParts) {
//	        String fileName = getSubmittedFileName(filePart);
//	        InputStream fileContent = filePart.getInputStream();
//	        // implementar inserção no bd
//	    }
	    
	    request.getRequestDispatcher("/sucesso").forward(request, response);
	}
	
	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
	        }
	    }
	    return null;
	}

}
