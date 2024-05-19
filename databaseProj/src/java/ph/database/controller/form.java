package ph.database.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ph.database.dao.formDao;
import ph.database.model.formModel;

public class form extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the current session
        HttpSession session = request.getSession();

        String action = request.getServletPath();
        switch (action) {
            case "/form/create/form":
                showFormCreateForm(request, response);
                break;
            case "/form/create":
                createForm(request, response);
                break;
            case "/form/update/form":
                showFormUpdateForm(request, response);
                break;
            case "/form/update":
                updateForm(request, response);
                break;
            default:
                viewForm(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Redirecting POST requests to GET can cause unintended behavior
    }
    
    private void viewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        formDao dao = new formDao();
        ArrayList<formModel> formList = dao.getFormList();

        // Retrieve username from session
        HttpSession session = request.getSession();
        formModel user = (formModel) session.getAttribute("form");

        request.setAttribute("formList", formList);
       request.setAttribute("username", user != null ? user.getusername() : "Guest"); // Set default if null                    

        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
        rd.forward(request, response);
    }
    

    private void showFormCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/formProj.jsp");
        rd.forward(request, response);
    }

private void createForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String username = "Guest"; // Default value
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String message = "";

    try {
        username = request.getParameter("username");
        request.setAttribute("email", email); // Attribute name corrected
        request.setAttribute("password", password); // Attribute name corrected

        formDao dao = new formDao();
        formModel newForm = new formModel(username, email, password);

        // Assuming createForm method returns a boolean or a success message
        boolean success = dao.createForm(newForm);
        message = success ? "Form submitted successfully!" : "Form submission failed.";
    } catch (Exception e) {
        // Handle exceptions
        message = "An error occurred during form submission.";
        e.printStackTrace(); // Log the exception for debugging
    }

    request.setAttribute("message", message);
    request.setAttribute("username", username);

    RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
    rd.forward(request, response);
}


private void showFormUpdateForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String message = ""; // Initialize the message

    if (username != null && !username.isEmpty()) {
        // Username passed successfully
        message = "Username passed: " + username;
    } else {
        // Username not passed or is empty
        message = "No username passed or empty.";
    }

    // Set individual attributes in the request scope
    request.setAttribute("username", username);
    request.setAttribute("email", email);
    request.setAttribute("password", password);
    request.setAttribute("message", message);

    RequestDispatcher rd = request.getRequestDispatcher("/formProjUpdate.jsp");
    rd.forward(request, response);
}



private void updateForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    formDao dao = new formDao();
    formModel updateForm = new formModel(username, email, password);
    boolean success = false;
    try {
        success = dao.updateForm(updateForm);
    } catch (Exception e) {
        // Handle the exception, log it or show an error message
        e.printStackTrace();
    }
    
    request.setAttribute("username", username); // Attribute name corrected
    request.setAttribute("email", email); // Attribute name corrected
    request.setAttribute("password", password); // Attribute name corrected
    String message;
    if (success) {
        message = "Form for user " + username + " has been updated."; // Message corrected
    } else {
        message = "Failed to update form for user " + username + "."; // Message corrected
    }
    request.setAttribute("message", message);
    
    RequestDispatcher rd = request.getRequestDispatcher("/home"); // getRequestDispatcher method corrected
    rd.forward(request, response); 
}
}

