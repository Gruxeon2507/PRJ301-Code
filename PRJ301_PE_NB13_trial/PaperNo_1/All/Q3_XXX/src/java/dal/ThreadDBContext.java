/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;
import model.Thread1;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class ThreadDBContext extends DBContext{
    public ArrayList<Thread1> all(){
        ArrayList<Thread1> threads = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT tid,tcontent FROM Thread";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Thread1 t = new Thread1();
                t.setId(rs.getInt("tid"));
                t.setComment(rs.getString("tcontent"));
                threads.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return threads;
        
    }
}
