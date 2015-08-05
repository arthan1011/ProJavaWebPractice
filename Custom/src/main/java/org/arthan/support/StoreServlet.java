package org.arthan.support;

import com.google.common.collect.Maps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Артур on 05.08.2015.
 * Next to Ufa.
 */

@WebServlet(
        name = "storeServlet",
        urlPatterns = {"/shop"}
)
public class StoreServlet extends HttpServlet {
    public static final String CART_ATTRIBUTE_NAME = "cart";
    private final Map<Integer, String> products = Maps.newHashMap();

    public StoreServlet() {
        products.put(1, "Sandpaper");
        products.put(2, "Nails");
        products.put(3, "Glue");
        products.put(4, "Paint");
        products.put(5, "Tape");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = defineAction(request);

        switch (action) {
            case "addToCart":
                addToCart(request, response);
                break;
            case "viewCart":
                viewCart(request, response);
                break;
            case "emptyCart":
                emptyCart(request, response);
                break;
            case "browse":
            default:
                browse(request, response);
                break;
        }

    }

    private void emptyCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute(CART_ATTRIBUTE_NAME);
        response.sendRedirect("shop?action=viewCart");
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productID;
        try {
            productID = Integer.parseInt(request.getParameter("productId"));
        } catch (NumberFormatException e) {
            response.sendRedirect("shop");
            return;
        }

        HttpSession session = request.getSession();
        createCartIfNotExist(session);
        addProductToCart(productID, session);

        response.sendRedirect("shop?action=viewCart");
    }

    private void createCartIfNotExist(HttpSession session) {
        if (session.getAttribute(CART_ATTRIBUTE_NAME) == null) {
            session.setAttribute(CART_ATTRIBUTE_NAME, Maps.<Integer, Integer>newHashMap());
        }
    }

    private void addProductToCart(int productID, HttpSession session) {
        @SuppressWarnings("unchecked")
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute(CART_ATTRIBUTE_NAME);
        if (!cart.containsKey(productID)) {
            cart.put(productID, 0);
        }
        cart.put(productID, cart.get(productID) + 1);
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/jsp/view/shop/viewCart.jsp").forward(request, response);
    }

    private void browse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/jsp/view/shop/browse.jsp").forward(request, response);
    }

    private String defineAction(HttpServletRequest request) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "browse";
        }
        return action;
    }
}
