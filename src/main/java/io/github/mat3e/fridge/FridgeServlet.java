package io.github.mat3e.fridge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.github.mat3e.product.Product;
import io.github.mat3e.product.ProductRepository;
import io.github.mat3e.product.ProductServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Fridge Servlet",urlPatterns = "/api/fridge/*")
public class FridgeServlet extends HttpServlet {



        private FridgeRepository fridgeRepository;
        private ObjectMapper mapper;
        private final Logger logger= LoggerFactory.getLogger(io.github.mat3e.fridge.FridgeServlet.class);

        @SuppressWarnings("unused")
        public FridgeServlet(){
            this(new FridgeRepository(),new ObjectMapper());
        }

        public FridgeServlet(FridgeRepository repository, ObjectMapper mapper){
            this.mapper=mapper;
            this.fridgeRepository =repository;
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            var newFridge=mapper.readValue(req.getInputStream(), Fridge.class);
            mapper.writeValue(resp.getOutputStream(), fridgeRepository.addFridge(newFridge));
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            logger.info("Request goes from "+getServletName());
            resp.setContentType("application/json;charset=UTF-8");
            mapper.writeValue(resp.getOutputStream(), fridgeRepository.findAll());
        }

        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //TODO

            resp.setContentType("application/json;charset=UTF-8");
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.writeValue(resp.getOutputStream(), fridgeRepository.findAll());
        }
    }

