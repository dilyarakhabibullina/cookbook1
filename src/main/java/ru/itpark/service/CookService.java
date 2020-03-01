package ru.itpark.service;

import ru.itpark.domain.Recipe;
import ru.itpark.util.JdbcTemplateV3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CookService {

    private final Collection<Recipe> items = new LinkedList<>();


    public List<Recipe> getAll() throws SQLException {
        List<Recipe> recipes = JdbcTemplateV3.<Recipe>executeQuery(
                "jdbc:sqlite:D:/JAVA_STEP_TWO/cookbook1/src/main/resources\\db",
                "SELECT id, name, ingredients, description FROM recipes",
                resultSet -> new Recipe(resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("ingredients"),
                        resultSet.getString("description"))
        );

        return recipes;
    }


}
