package com.example.discordpa.listeners.services.database;

import com.example.discordpa.questions.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FindByKeyWord {



    //Find all the keyword in the database


    public static List<Question> findKeyword() throws SQLException {
        List<Question> questions = new ArrayList<>();
        int id = 0;
        String infos = null;
        Connection connection = DBService.getMyConnection();
        String sql = "Select * from questions";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String keyword = null;
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            infos = resultSet.getString("information");
            keyword = resultSet.getString("keyword");
            questions.add(new Question(id, keyword, infos));
        }
        return questions;
    }


        //It returns a string that contains all the keywords
    public static String listAllKeywords() throws SQLException {
        List<Question> questions = findKeyword();
        String build ="";
        for (var question : questions) {
                build=build+" `"+question.getKeyword()+"` ";
        }
        return build;
    }
}
