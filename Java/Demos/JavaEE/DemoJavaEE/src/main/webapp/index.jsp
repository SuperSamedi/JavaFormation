<%--Créez les pages suivantes en jsp:--%>

<%--- une page d'accueil permettant de joindre les autres--%>
<%--- une page contenant un formulaire d'ajout d'un produit--%>
<%--- une page contenant la liste des produits--%>
<%--- une page de détail de produit--%>

<%--Faites en sorte d'obtenir une navigation relativement fluide entre les pages--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
    <html>
        <head>
            <title>Cards!</title>
            <%@ include file="WEB-INF/fragments/baseCSS.jsp"%>
            <%@ include file="WEB-INF/fragments/baseJS.jsp"%>
            <%@ include file="WEB-INF/fragments/favicon.jsp"%>
        </head>
    <body>
        <h1>Cards!</h1>
        <br/>
        <nav>
            <a href="product/addCardForm.jsp">Add a card</a><br/>
            <a href="product/getAll.jsp">All cards</a><br/>
        </nav>
    </body>
</html>