/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Content;

import DOCUMENT.Document;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DocumentDao {
        public List <Document> getAllDocuments() throws SQLException {
        List<Document> documents = new ArrayList<Document>();

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM Documents";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Document document = new Document();

                document.setMaTL(rs.getInt("MATL"));
                document.setTenNXB(rs.getNString("TENNXB"));
                document.setSoBanPhatHanh(rs.getInt("SOBANPHATHANH"));
                document.setTenTG(rs.getNString("TENTG"));
                document.setSoTrang(rs.getInt("SOTRANG"));
                document.setSoPhatHanh(rs.getInt("SOPHATHANH"));
                document.setThangPhatHanh(rs.getInt("THANGPHATHANH"));
                document.setNgayPhatHanh(rs.getInt("NGAYPHATHANH"));

                documents.add(document);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return documents;
    }
    
    public void addDocument(Document document) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO documents(MATAILIEU, TENNHAXUATBAN, SOBANPHATHANH, TENTACGIA, SOTRANG, SOPHATHANH, THANGPHATHANH, NGAYPHATHANH) VALUE(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, document.getMaTL());
            preparedStatement.setString(2, document.getTenNXB());
            preparedStatement.setInt(3, document.getSoBanPhatHanh());
            preparedStatement.setString(4, document.getTenTG());
            preparedStatement.setInt(5, document.getSoTrang());
            preparedStatement.setInt(6, document.getSoPhatHanh());
            preparedStatement.setInt(7, document.getThangPhatHanh());
            preparedStatement.setInt(8, document.getNgayPhatHanh());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void updateDocument(Document document) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "UPDATE users SET TENNXB = ?,SOBANPHATHANH = ?,TENTACGIA = ?,SOTRANG = ?,SOPHATHANH = ?,THANGPHATHANH = ?,NGAYPHATHANH = ? WHERE MATL = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, document.getMaTL());
            preparedStatement.setString(2, document.getTenNXB());
            preparedStatement.setInt(3, document.getSoBanPhatHanh());
            preparedStatement.setString(4, document.getTenTG());
            preparedStatement.setInt(5, document.getSoTrang());
            preparedStatement.setInt(6, document.getSoPhatHanh());
            preparedStatement.setInt(7, document.getThangPhatHanh());
            preparedStatement.setInt(8, document.getNgayPhatHanh());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteDocument(int maTL) throws SQLException {

        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "DELETE FROM document WHERE MATL = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, maTL);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}

