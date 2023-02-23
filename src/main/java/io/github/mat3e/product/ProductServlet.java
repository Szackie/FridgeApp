package io.github.mat3e.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Product Servlet",urlPatterns = "/api/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;
    private ObjectMapper mapper;
    private final Logger logger=LoggerFactory.getLogger(ProductServlet.class);

    @SuppressWarnings("unused")
    public ProductServlet(){
        this(new ProductRepository(),new ObjectMapper());
    }

    public ProductServlet(ProductRepository repository, ObjectMapper mapper){
        this.mapper=mapper;
        this.productRepository =repository;
        }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String reqPath=req.getPathInfo();
        try {
            var todoId = Integer.valueOf(reqPath.substring(1));
            var todo= productRepository.toggleProduct(todoId);
            resp.setContentType("application/json;charset=UTF-8");
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.writeValue(resp.getOutputStream(),todo);
        }
        catch(NumberFormatException e)
        {
            logger.warn("non numeric todo id used" + reqPath);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

var newProduct=mapper.readValue(req.getInputStream(), Product.class);
mapper.writeValue(resp.getOutputStream(), productRepository.addProduct(newProduct));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Request goes from "+getServletName());
        resp.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(), productRepository.findAll());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(Product product: productRepository.findAll())
        if(product.isDone())
            productRepository.deleteProduct(product.getId());
        resp.setContentType("application/json;charset=UTF-8");
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.writeValue(resp.getOutputStream(), productRepository.findAll());
    }
}