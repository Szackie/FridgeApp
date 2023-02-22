package io.github.mat3e.todo;

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
import java.util.List;

@WebServlet(name="Todo Servlet",urlPatterns = "/api/todos/*")
public class TodoServlet extends HttpServlet {

    private TodoRepository todoRepository;
    private ObjectMapper mapper;
    private final Logger logger=LoggerFactory.getLogger(TodoServlet.class);

    @SuppressWarnings("unused")
    public TodoServlet(){
        this(new TodoRepository(),new ObjectMapper());
    }

    public TodoServlet(TodoRepository repository,ObjectMapper mapper){
        this.mapper=mapper;
        this.todoRepository =repository;
        }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String reqPath=req.getPathInfo();
        try {
            var todoId = Integer.valueOf(reqPath.substring(1));
            var todo=todoRepository.toggleTodo(todoId);
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

var newTodo=mapper.readValue(req.getInputStream(),Todo.class);
mapper.writeValue(resp.getOutputStream(),todoRepository.addTodo(newTodo));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Request goes from "+getServletName());
        resp.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(), todoRepository.findAll());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(Todo todo: todoRepository.findAll())
        if(todo.isDone())
            todoRepository.deleteTodo(todo.getId());
        resp.setContentType("application/json;charset=UTF-8");
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.writeValue(resp.getOutputStream(),todoRepository.findAll());
    }
}