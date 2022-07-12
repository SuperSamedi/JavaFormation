package brussels.digitalcity.maxdolmans.demojavaee;

import brussels.digitalcity.maxdolmans.demojavaee.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    private final List<Product> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        list.add(new Product(1, "Mountain", "Alpha", "Basic Land", 40.));
        list.add(new Product(2, "Forest", "Alpha", "Basic Land", 36.27));
        list.add(new Product(3, "Island", "Alpha", "Basic Land", 75.25));
        list.add(new Product(4, "Plains", "Alpha", "Basic Land", 26.99));
        list.add(new Product(5, "Swamp", "Alpha", "Basic Land", 43.12));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String id = request.getParameter("id");
        if(id == null){
            getAll(response);
        }
        else{
            getOne(response, Integer.parseInt(id));
        }
    }

    private void getAll(HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        response.setStatus(200);
        PrintWriter out = response.getWriter();

        out.println(
                "<!doctype html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\"\n" +
                        "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                        "    <title>Document</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<a href=\"http://localhost:8080/demo/\">Back</a>" +
                        "    <h1>Product list</h1>\n" +
                        "    <ul>\n"
        );

        for (Product product : list) {
            out.println(
                    "        <li>\n" +
                            "            <div>\n" +
                            "                <p><span>Name : </span><strong>" + product.getName() + "</strong></p>\n" +
//                            "-------------------------" +
                            "                <p><span>id : </span>" + product.getId() + "</p>\n" +
                            "                <p><span>Set : </span>" + product.getEdition() + "</p>\n" +
                            "                <p><span>Type : </span>" + product.getType() + "</p>\n" +
                            "                <p><span>Price : </span>" + product.getPrice() + "</p>\n" +
                            "<hr>" +
                            "            </div>\n" +
                            "        </li>\n"
            );
        }

        out.println(
                "    </ul>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }

    private void getOne(HttpServletResponse response, int id) throws IOException{
        Product p = list.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);

        if (p == null){
            response.setStatus(404);
        }
        else{
            PrintWriter out = response.getWriter();
            out.println(
                    "<!doctype html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <meta name=\"viewport\"\n" +
                            "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                            "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                            "    <title>Document</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <h1>Product " + id + "</h1>\n" +
                            "            <div>\n" +
                            "                <p><span>id : </span>" + p.getId() + "</p>\n" +
                            "                <p><span>Name : </span>" + p.getName() + "</p>\n" +
                            "                <p><span>Set : </span>" + p.getEdition() + "</p>\n" +
                            "                <p><span>Type : </span>" + p.getType() + "</p>\n" +
                            "                <p><span>Price : </span>" + p.getPrice() + "€</p>\n" +
                            "            </div>\n" +
                            "</body>\n" +
                            "</html>"
            );
        }
    }
}
