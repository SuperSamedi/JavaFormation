package brussels.digitalcity.maxdolmans.demojavaee.servlets;

import brussels.digitalcity.maxdolmans.demojavaee.models.Product;
import brussels.digitalcity.maxdolmans.demojavaee.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/product/update")
public class UpdateServlet extends HttpServlet {
    private final ProductService service = ProductService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = 0;
        try{
            id = Integer.parseInt(request.getParameter("id"));
        }
        catch (NumberFormatException ex) {
            response.sendError(400, "id invalid");
        }

        Product p = service.getOne(id);

        request.setAttribute("product", p);
        request.getRequestDispatcher("product/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
