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
        request.getRequestDispatcher("/product/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product p = new Product();

        String name = request.getParameter("name");
        String edition = request.getParameter("edition");
        String type = request.getParameter("type");

        p.setName(name);
        p.setEdition(edition);
        p.setType(type);

        double price = 0;
        int id = 0;

        try{
            id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            price = Double.parseDouble(request.getParameter("price"));
            p.setPrice(price);

            service.update(p.getId(), p.getName(), p.getEdition(), p.getType(), p.getPrice());
            response.sendRedirect(request.getContextPath() + "/product/getOne.jsp?id=" + id); // ranvoi une réponse de redirection
        }
        catch (NumberFormatException ex){
            request.setAttribute("error", "Données entrées non valides");
            if (p.getId() != 0){
                request.setAttribute("product", p);
                request.getRequestDispatcher("/product/update?id=" + id).forward(request, response);
            }
            else {
                response.sendError(400, "ID invalid");
            }
        }
    }
}
