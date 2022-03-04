/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Content.DocumentDao;
import DOCUMENT.Document;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
/*import content.UserDao;
import java.sql.SQLException;
import java.util.List;
import USER.User;*/

public class DocumentService {
    private DocumentDao documentsdao;
    
    public DocumentService() {
        documentsdao = new DocumentDao();
    }
    
    public List<Document> getAllDocuments() throws SQLException {
       return documentsdao.getAllDocuments();
    }
}

