package brussels.digitalcity.maxdolmans.demojavaee.servlets;

import brussels.digitalcity.maxdolmans.demojavaee.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveServlet", value = "/product/delete")
public class RemoveServlet extends HttpServlet {

    private final ProductService service = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect(request.getContextPath() + "/product/getAll.jsp"); // renvois une réponse de redirection
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
