package io.github.mat3e.todo;

import io.github.mat3e.HibernateUtil;
import io.github.mat3e.lang.Lang;

import java.util.List;
import java.util.Optional;

public class TodoRepository {

    public Todo addTodo(Todo newTodo){
         var session = HibernateUtil.getSessionFactory().openSession();
         var transaction = session.beginTransaction();

         session.persist("todos",newTodo);

         transaction.commit();
         session.close();
         return newTodo;
    }

    public Todo toggleTodo(Integer id){
        var session= HibernateUtil.getSessionFactory().openSession();
        var transaction=session.beginTransaction();


        var todo = session.load(Todo.class,id);
        todo.setDone(!todo.isDone());

        transaction.commit();
        session.close();
        return todo;

    }
        public void deleteTodo(Integer id){
        var session= HibernateUtil.getSessionFactory().openSession();
        var transaction=session.beginTransaction();

        var todo = session.load(Todo.class,id);
        session.delete("todos",todo);


        transaction.commit();
        session.close();
    }

public List<Todo> findAll(){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createQuery("from Todo",Todo.class).list();
transaction.commit();
session.close();

        return result;
    }


}
