package com.jzietflow.infrastructure.persistence.sqlite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jzietflow.application.project.ProjectRepository;
import com.jzietflow.domain.Project;
import com.jzietflow.domain.ProjectStatus;

public class SQLiteProjectRepository implements ProjectRepository {
    private static String DATABASE_URL = "jdbc:sqlite:jZietflow.db";

    List<Project> projects = new ArrayList<>();

    public SQLiteProjectRepository(){
        initializeDatabase();
    }
    
    private void initializeDatabase(){
        String sql = """
                CREATE TABLE IF NOT EXISTS projects(
                    id TEXT PRIMARY KEY,
                    name TEXT NOT NULL,
                    description TEXT NOT NULL,
                    status TEXT NOT NULL
                )
                """;

        try(Connection connection = DriverManager.getConnection(DATABASE_URL))
        {
            connection.createStatement().execute(sql);

        }
        catch(SQLException e)
        {
            throw new RuntimeException("Failed to initialize database");
        }
    }

    @Override 
    public Project save(Project project){
        String sql = """
                INSERT INTO projects (id, name, description, status)
                VALUES (?, ?, ?, ?)
            """;
        
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setString(1, project.getId().toString());
            statement.setString(2, project.getName());
            statement.setString(3, project.getDescription());
            statement.setString(4, project.getStatus().name());

            statement.executeUpdate();

            return project;
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Failed to save project: " + project.getId());
        }
    }

    @Override 
    public void delete(UUID id){
        String sql = """
                DELETE FROM projects
                WHERE id = ?
                """;

        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setString(1, id.toString());

            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Failed to delete the project: " + id);
        }
    }

    @Override 
    public List<Project> findAll(){
        String sql = """
                SELECT id, name, description, status
                FROM projects

                """;

        List<Project> projects = new ArrayList<>();


        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
        )
        {

            while(resultSet.next())
            {
                UUID projectId = UUID.fromString(resultSet.getString("id"));
                String projectName = resultSet.getString("name");
                String projectDescription = resultSet.getString("description");
                ProjectStatus projectStatus = ProjectStatus.valueOf(resultSet.getString("status"));

                projects.add(new Project(projectId, projectName, projectDescription, projectStatus));
            }

            return projects;
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Failed to find projects. ", e);   
        }
    }

    @Override 
    public Optional<Project> findById(UUID id){
        String sql = """
                SELECT id, name, description, status
                FROM projects
                WHERE id = ?
                """;

        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setString(1, id.toString());

            try(ResultSet resultSet = statement.executeQuery())
            {
                if(resultSet.next())
                {
                    UUID projectId = UUID.fromString(resultSet.getString("id"));
                    String projectName = resultSet.getString("name");
                    String projectDescription = resultSet.getString("description");
                    ProjectStatus projectStatus = ProjectStatus.valueOf(resultSet.getString("status"));

                    return Optional.of(new Project(projectId, projectName, projectDescription, projectStatus));
                }

                return Optional.empty();
            }
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Couldnt find");
        }
    }

    @Override 
    public void update(Project project){
        String sql = """
                UPDATE projects
                SET name = ? , description = ?, status = ?
                WHERE id = ?
                """;

        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setString(3, project.getStatus().name());
            statement.setString(4, project.getId().toString());


            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Failed to update project: " + project.getId().toString());
        }
    }
}