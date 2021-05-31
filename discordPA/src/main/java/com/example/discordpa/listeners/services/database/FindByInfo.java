package com.example.discordpa.listeners.services.database;

import com.example.discordpa.listeners.QuestionListener;
import com.example.discordpa.questions.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FindByInfo {


    //Finds the info for a specific keyword in DB


    public static Question findQuestion(String keyword) throws SQLException {
        int id=0;
        String infos=null;
        Connection connection=DBService.getMyConnection();
        String sql="Select * from questions where questions.keyword=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,keyword);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            id=resultSet.getInt("id");
            infos=resultSet.getString("information");
        }
        return new Question(id,keyword,infos);
    }

}
