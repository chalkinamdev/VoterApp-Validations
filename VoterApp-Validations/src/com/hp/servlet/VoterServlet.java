package com.hp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {

	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet::process(-,-)");
		PrintWriter pw = null;
		String name = null, tage = null;
		int age = 0;
		List<String> list = null;
		String vstatus = null;

		pw = res.getWriter();
		res.setContentType("text/html");

		name = req.getParameter("fname");
		tage = req.getParameter("fage");

		vstatus = req.getParameter("vflag");

		if (vstatus.equalsIgnoreCase("no")) {
			System.out.println("VoterServlet:: server side form validations...");

			list = new ArrayList();
			if (name == null || name.equals("") || name.length() == 0) {
				list.add("<p style='color:red'> person name is required</p>");
			}
			if (tage == null || tage.equals("") || tage.length() == 0) {
				list.add("<p style='color:red'> person age is required</p>");
			} else {
				try {
					age = Integer.parseInt(tage);
				} catch (NumberFormatException nfe) {
					list.add("<p style='color:red'>Person age must be numeric value");

				}
				if (age <= 0 || age > 125) {
					list.add("<p style='color:red'> Person age should be in between 1-125");
				}
			}
			if (list.size() != 0) {
				for (String msg : list) {
					pw.println(msg);
				}
				return;
			}
		} else {
			age = Integer.parseInt(tage);
		}

		if (age < 18)
			pw.println("<h1 style='color:red'>Mr/Miss. " + name + " u r not eligible to vote</h1>");
		else
			pw.println("<h1 style='color:green'>Mr/Miss. " + name + " u r eligible to vote</h1>");

		pw.println("<a href='input.html'><img src='james.png'/></a>");

		pw.close();

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet:: doGet(-,-)");
		process(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet:: doPost(-,-)");
		process(req, res);
	}

}
