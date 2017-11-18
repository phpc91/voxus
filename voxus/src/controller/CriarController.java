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

/**
 * Servlet implementation class CriarController
 */
@WebServlet("/criar")
@MultipartConfig
public class CriarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/criar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("titulo");
		String desc = request.getParameter("descricao");
		int prioridade = Integer.parseInt(request.getParameter("prioridade"));
		TaskDAO dao = TaskDAO.getInstance();
		dao.createTask(nome);
		
	    List<Part> fileParts = 
	    		request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());

	    for (Part filePart : fileParts) {
	        String fileName = getSubmittedFileName(filePart);
	        InputStream fileContent = filePart.getInputStream();
	        //TODO implementar inserção no bd
	    }
	    
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
