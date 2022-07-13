package brussels.digitalcity.maxdolmans.demojavaee.servlets;

import brussels.digitalcity.maxdolmans.demojavaee.models.Product;
import brussels.digitalcity.maxdolmans.demojavaee.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/product/add")
public class AddProductServlet extends HttpServlet {

    private ProductService service = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String edition = request.getParameter("edition");
        String type = request.getParameter("type");
        try{
            double price = Double.parseDouble(request.getParameter("price"));
            int id = service.insert(new Product(name, edition, type, price));

            response.sendRedirect(request.getContextPath() + "/product/getOne.jsp?id=" + id); // ranvoi une réponse de redirection
//          request.getRequestDispatcher(request.getContextPath() + "/product/getOne.jsp?id=" + id).forward(request, response); // continue la création de réponse à la page redirect.
        }
        catch (NumberFormatException ex){
            request.getRequestDispatcher(/*request.getContextPath() + */"/product/addCardForm.jsp").forward(request, response);
//            response.setStatus(400);
        }


    }
}
