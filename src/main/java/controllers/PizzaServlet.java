package controllers;

import models.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "PizzaServlet", value = "/pizza-order")
@MultipartConfig
public class PizzaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/orderPizza.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crust = null;
		String cheese = null;
		String[] sauce = null;
		String[] toppings = null;

		String street = null;
		String city = null;
		String state = null;
		String zip = null;

		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if ("street".equals(part.getName())) {
				street = request.getParameter("street");
			}
			if ("city".equals(part.getName())) {
				city = request.getParameter("city");
			}
			if ("state".equals(part.getName())) {
				state = request.getParameter("state");
			}
			if ("zip".equals(part.getName())) {
				zip = request.getParameter("zip");
			}
			if ("crust".equals(part.getName())) {
				crust = request.getParameter("crust");
			}
			if ("cheese".equals(part.getName())) {
				cheese = request.getParameter("cheese");
			}
			if ("sauce".equals(part.getName())) {
				sauce = request.getParameterValues("sauce");
			}
			if ("toppings".equals(part.getName())) {
				toppings = request.getParameterValues("toppings");
			}
		}

		Order customerOrder = new Order(crust, cheese, sauce, toppings, street, city, state, zip);

		StringBuilder sauceSpecs = new StringBuilder();
		for (String sauceType : customerOrder.getSauce()) {
			sauceSpecs.append(sauceType).append(", ");
		}
		sauceSpecs.setLength(sauceSpecs.length() - 2);

		StringBuilder toppingSpecs = new StringBuilder();
		for (String topping : customerOrder.getToppings()) {
			toppingSpecs.append(topping).append(", ");
		}
		toppingSpecs.setLength(toppingSpecs.length() - 2);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<div class=" + "container " + "pb-5" + ">");
		out.println("<jsp:include page="+"partials/navbar.jsp"+ "/>");
		out.println("<div class=\"card text-center p-0\">");
		out.println("<div class=\"card-header bg-transparent border-bottom-0 p-0 d-flex\">");
		out.println("<h1 class=\"text-start p-1 pt-5\">Your order has been placed!</h1>");
		out.println("</div>");
		out.println("<div class=\"tab-content\" id=\"myTabContent\">\n" +
				"<div class=\"tab-pane fade show active\" id=\"size-and-crust-tab-pane\" role=\"tabpanel\" aria-labelledby=\"size-and-crust-tab\" tabindex=\"0\">\n" +
				"                    <div class=\"card-body border border-top-0 rounded-top p-0\">\n" +
				"                        <div class=\"container p-0\">\n" +
				"                            <h5 class=\"card-title text-start bg-primary text-white p-2\" style=\"margin: 2px -2px 3px;\">Order Details</h5>");
		out.println("<p>Crust: " + customerOrder.getCrust() + "</p>");
		out.println("<p>Cheese: " + customerOrder.getCheese() + "</p>");
		out.println("<p>Sauce: " + sauceSpecs + "</p>");
		out.println("<p>Toppings: " + toppingSpecs + "</p>");
		out.println("</div>\n" +
				"					</div>");
		out.println("<div class=\"card-body border border-top-0 rounded-top p-0\">\n" +
				"                        <div class=\"container p-0\">\n" +
				"                            <h5 class=\"card-title text-start bg-primary text-white p-2\" style=\"margin: 2px -2px 3px;\">Delivery Details</h5>");
		out.println("<p>Street: " + customerOrder.getStreet() + "</p>");
		out.println("<p>City: " + customerOrder.getCity() + "</p>");
		out.println("<p>State: " + customerOrder.getState() + "</p>");
		out.println("<p>Zip: " + customerOrder.getZip() + "</p>");
		out.println("</div>\n" +
				"					</div>\n" +
						"			</div>");
		System.out.println("Crust: " + customerOrder.getCrust());
		System.out.println("Cheese: " + customerOrder.getCheese());
		System.out.println("Sauce: " + sauceSpecs);
		System.out.println("Toppings: " + toppingSpecs);
		System.out.println("Street: " + customerOrder.getStreet());
		System.out.println("City: " + customerOrder.getCity());
		System.out.println("State: " + customerOrder.getState());
		System.out.println("Zip: " + customerOrder.getZip());
	}
}
