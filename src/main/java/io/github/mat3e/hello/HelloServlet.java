package io.github.mat3e.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Servlet powitania", urlPatterns = {"/api/*"})

public class HelloServlet extends HttpServlet {

    private HelloService service;

    private static final String NAME_PARAM="name";
    private static final String LANG_PARAM="lang";
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @SuppressWarnings("unused")
    public HelloServlet()
    {
        this(new HelloService());
    }

    public HelloServlet(HelloService service)
    {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Request goes " + getServletName());

        var name=req.getParameter(NAME_PARAM);
        var lang=req.getParameter(LANG_PARAM);
        Integer langId=null;
        try {
            langId = Integer.valueOf(lang);
        }
        catch(NumberFormatException e)
        {
            logger.warn("non numeric Language id used" + lang);
        }
        resp.getWriter().write(service.prepareGreeting(name,langId));
    }
}
