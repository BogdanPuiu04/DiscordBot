package com.example.discordpa.listeners.services.database;

import com.example.discordpa.questions.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FindByKeyWord {


    //Find all the keyword in the database


    public static List<Question> findKeyword() throws SQLException {
        List<Question> questions = new ArrayList<>();
        int id;
        String infos;
        Connection connection = DBService.getMyConnection();
        String sql = "Select * from questions";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String keyword;
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
        StringBuilder build = new StringBuilder();
        for (var question : questions) {
            build.append(" `").append(question.getKeyword()).append("` ");
        }
        return build.toString();
    }
}
