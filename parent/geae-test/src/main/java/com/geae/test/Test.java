package com.geae.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.geae.domain.model.Eleve;
import com.geae.service.GenericService;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(Test.class);
	
	/**
	 * @see Servlet#init(ServletConfig)  
	 */
	public void init(ServletConfig config) throws ServletException {
	 	 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenericService bean = (GenericService)WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()).getBean("genericBusiness");
		if(bean != null){
			List<Eleve> eleves = bean.getEleves();
			
			if(eleves != null){
				log.info(eleves.size() + " eleves trouves");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
